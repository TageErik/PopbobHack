package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import popbobhack.main.Category;

public class AutoWalk extends Module{

	public AutoWalk() {
		super("AutoWalk", 0, Category.MOVEMENT);
		
	}

	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindForward.pressed = true;
			super.onUpdate();
		}
	}
	   public void onDisable() {
		   mc.gameSettings.keyBindForward.pressed = false;
		   super.onDisable();
	   }
	
}
