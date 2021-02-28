package popbobhack.mods;

import popbobhack.main.Category;

public class AntiKB extends Module{

	public AntiKB() {
		super("AntiKB", 0, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}

	public void onUpdate() {
		if(isToggled()) {
			if (mc.thePlayer.hurtTime > 0) {
				mc.thePlayer.motionX = 0;
				mc.thePlayer.motionY = 0;
				mc.thePlayer.motionZ = 0;
			}
		}
	}
}
