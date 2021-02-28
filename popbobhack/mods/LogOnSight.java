package popbobhack.mods;

import net.minecraft.src.GuiDisconnected;
import net.minecraft.src.Minecraft;
import popbobhack.config.Config;
import popbobhack.main.Category;

public class LogOnSight extends Module{

	public LogOnSight() {
		super("LogOnSight", 0, Category.COMBAT);
		// TODO Auto-generated constructor stub
	}
	
	public static String[] LOSList = new String[100];
	public static int LOSListLength;
	
	
	public void onUpdate() {
		if(isToggled()) {
				for(int i2 = 0; i2 < LOSListLength; i2++) {
					GuiDisconnected.reconnectenabled = false;
					mc.theWorld.sendQuittingDisconnectingPacket();
				}
		}
	}

	
	
	public static void SetListToTxt() {
		LOSListLength = Config.SetListToTxt(LOSList, LOSListLength, "/PopbobHack/LogOnSight.txt");
	}
	
	
	
	public static void onListUpdated() {
		Config.onListUpdated(LOSList, LOSListLength, "/PopbobHack/LogOnSight.txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, LOSList, LOSListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, LOSList, LOSListLength);
	}
	
	
	public static void LOSListPrint() {
		Config.ListPrint(LOSList, LOSListLength);
	}
	
}
