package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import popbobhack.main.Category;

public class FullBright extends Module{

	public FullBright() {
		super("FullBright", 0, Category.RENDER);
		// TODO Auto-generated constructor stub
	}
	public void onUpdate() {
		if(isToggled()) {
		if(!mc.isRunningOnMac) {
		mc.gameSettings.gammaSetting = 10000f;
		} else {
		mc.thePlayer.addChatMessage("<popbob> FullBright has decided not to activate because it was disgusted by the fact that you're using a mac");	
		toggle();
		}
		}else{
			mc.gameSettings.gammaSetting = 1f;
		}
	}

}
