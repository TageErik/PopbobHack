package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.Material;
import popbobhack.main.Category;

public class Glide extends Module{

	public Glide() {
		super("Glide", 0, Category.PLAYER);
		
	}
	public void onUpdate() {
		double oldY = mc.thePlayer.motionY;
		float oldJ = mc.thePlayer.jumpMovementFactor;
		if(this.isToggled()) {
			if(mc.thePlayer.motionY < 0.0D && mc.thePlayer.isAirBorne && !mc.thePlayer.isInWater() && !mc.thePlayer.isOnLadder()) {
				if(!mc.thePlayer.isInsideOfMaterial(Material.lava)) {
					mc.thePlayer.motionY = -.125D;
					mc.thePlayer.jumpMovementFactor *= 1.12337f;
				}
			}
		} else {
			mc.thePlayer.motionY = oldY;
			mc.thePlayer.jumpMovementFactor = oldJ;
		}
	}
}
