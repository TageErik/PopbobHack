package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.Timer;
import popbobhack.main.Category;

public class Jesus extends Module{

	public Jesus() {
		super("Jesus", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	public void onEnable() {
	mc.thePlayer.onGround = true;
	}
	
	public void onDisable() {
		mc.thePlayer.onGround = false;
		mc.gameSettings.keyBindJump.pressed = Keyboard.isKeyDown(mc.gameSettings.keyBindJump.keyCode);
		mc.thePlayer.speedInAir = 0.02f;
	}
	
	public void onUpdate() {
		if(isToggled()) {
		if(mc.theWorld.getBlockId((int)mc.thePlayer.posX, (int)mc.thePlayer.posY - 2, (int)mc.thePlayer.posZ) == 9) {
			mc.thePlayer.setSprinting(false);
			mc.gameSettings.keyBindJump.pressed = true;
			mc.thePlayer.speedInAir = 0.03f;
			Timer.CustomTimer = 1.08f;
		} else {
			mc.gameSettings.keyBindJump.pressed = Keyboard.isKeyDown(mc.gameSettings.keyBindJump.keyCode);
			mc.thePlayer.speedInAir = 0.02f;
			Timer.CustomTimer = 1.00f;
		}
		}
	}

}
