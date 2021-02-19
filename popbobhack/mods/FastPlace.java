package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import popbobhack.main.Category;

public class FastPlace extends Module{

	public FastPlace() {
		super("FastPlace", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public void onUpdate() {
		if(this.isToggled()) {
			mc.rightClickDelayTimer = 0;
		}
	}

}
