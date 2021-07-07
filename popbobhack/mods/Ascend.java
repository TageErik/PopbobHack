package popbobhack.mods;

import popbobhack.main.Category;

public class Ascend extends Module {

	public Ascend() {
		super("Ascend", 0, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}

	public static int AscendNumber = 8;

	public void onUpdate() {
		if (isToggled()) {
			mc.thePlayer.setPositionAndUpdate(mc.thePlayer.posX, mc.thePlayer.posY + AscendNumber, mc.thePlayer.posZ);
		}
	}

}
