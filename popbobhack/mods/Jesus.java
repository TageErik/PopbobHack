package popbobhack.mods;

import org.lwjgl.input.Keyboard;

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
	}
	
	public void onUpdate() {
		if(isToggled()) {
		
		mc.gameSettings.keyBindJump.pressed = true;
		
		}
	}

}
