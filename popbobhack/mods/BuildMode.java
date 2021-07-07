package popbobhack.mods;

import net.minecraft.src.Timer;
import popbobhack.main.Category;

public class BuildMode extends Module{

	public BuildMode() {
		super("BuildMode", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}

	public void onUpdate() {
		if(isToggled()) {
			if(mc.gameSettings.keyBindJump.pressed) {
				Timer.CustomTimer = 1.5F;
			} else {
				Timer.CustomTimer = 1.0F;
			}
		}
	}
}
