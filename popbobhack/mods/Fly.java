package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import popbobhack.main.Category;
import popbobhack.main.PopbobHack;

public class Fly extends Module{

	public static float flyHackSpeed = 5f;
	public static float flyHackHorizontalSpeed = 0.2f;
	
	public Fly() {
		super("Fly", 0,Category.MOVEMENT);
	}
   public void onDisable() {
	   if(!PopbobHack.getModules().get(42).isToggled()) {
		   mc.thePlayer.capabilities.isFlying = false;
	   }
	   super.onDisable();
   }
	
	public void onUpdate() {
		if(this.isToggled() && !PopbobHack.getModules().get(18).isToggled()) {
			
			mc.thePlayer.capabilities.isFlying = true;
			//mc.thePlayer.jumpMovementFactor = flyHackHorizontalSpeed;
			
			if(mc.gameSettings.keyBindJump.isPressed()) {
				mc.thePlayer.motionY += flyHackHorizontalSpeed;
			}
			
			if(mc.gameSettings.keyBindSneak.isPressed()) {
				mc.thePlayer.motionY -= flyHackHorizontalSpeed;
			}
			
			if(mc.gameSettings.keyBindForward.isPressed()) {
				mc.thePlayer.capabilities.setFlySpeed(flyHackSpeed);
			}
			super.onUpdate();
		}
	}
}
