package popbobhack.mods;

import popbobhack.main.Category;

public class NoClip extends Module{

	public NoClip() {
		super("NoClip", 0, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}

	public void onEnable() {
		mc.thePlayer.noClip = true;
	}
	
	public void onDisable() {
		mc.thePlayer.noClip = false;
	}
}
