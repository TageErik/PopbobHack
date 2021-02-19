package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import popbobhack.main.Category;

public class Sprint extends Module{

	public Sprint() {
		super("Sprint", 0, Category.PLAYER);
		
	}

	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.setSprinting(true);
		}
	}
	}
	

