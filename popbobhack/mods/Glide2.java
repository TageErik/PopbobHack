package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.Material;
import popbobhack.main.Category;
import popbobhack.main.PopbobHack;

public class Glide2 extends Module {

	public Glide2() {
		super("Glide2", 0, Category.MOVEMENT);

	}

	public void onUpdate() {
		double oldY = mc.thePlayer.motionY;
		float oldJ = mc.thePlayer.jumpMovementFactor;
		if(this.isToggled()) {
			if(!mc.gameSettings.keyBindJump.pressed) {
				mc.thePlayer.motionY = -.125D;
				mc.thePlayer.jumpMovementFactor *= 1.12337f;
			}
			mc.thePlayer.capabilities.isFlying = true;
		} else {
			mc.thePlayer.motionY = oldY;
			mc.thePlayer.jumpMovementFactor = oldJ;
			if(!PopbobHack.getModules().get(0).isToggled()) {
				mc.thePlayer.capabilities.isFlying = false;
			}
		}
	}
}
