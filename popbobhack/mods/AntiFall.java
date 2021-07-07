package popbobhack.mods;

import net.minecraft.src.Entity;
import popbobhack.main.Category;
import popbobhack.main.PopbobHack;

public class AntiFall extends Module {

	public AntiFall() {
		super("AntiFall", 0, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}

	public void onUpdate() {
		if (isToggled()) {
			if (mc.thePlayer.fallDistance > 3) {
				if (!PopbobHack.getModules().get(18).isToggled()) {
					mc.thePlayer.motionY = -.125d;
				}
			}
		}
	}

}
