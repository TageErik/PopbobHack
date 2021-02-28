package popbobhack.mods;

import popbobhack.main.Category;

public class AutoSwim extends Module{

	public AutoSwim() {
		super("AutoSwim", 0, Category.MOVEMENT);
		
	}
	public static boolean popbob = false;
	public void onUpdate() {
		if(isToggled()) {
			if(mc.thePlayer.isInWater()) {
			mc.gameSettings.keyBindJump.pressed = true;
			popbob = true;
			} else {
				if(popbob == true) {
					mc.gameSettings.keyBindJump.pressed = false;
					popbob = false;
				}
			}
		}
	}
	
	public void onDisable() {
		mc.gameSettings.keyBindJump.pressed = false;			
	}
}
