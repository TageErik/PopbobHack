package popbobhack.mods;

import popbobhack.config.Config;
import popbobhack.main.Category;

public class AutoSign extends Module{

	public AutoSign() {
		super("AutoSign", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	public static String[] AutoSignText = new String[4];
	public static int AutoSignTextLength;
	
	public static void SetListToTxt() {
		AutoSignTextLength = Config.SetListToTxt(AutoSignText, AutoSignTextLength, "/PopbobHack/AutoSignText.txt");
		AutoSignTextLength = 4;
	}
	
	
	
	public static void onListUpdated() {
		Config.onListUpdated(AutoSignText, AutoSignTextLength, "/PopbobHack/AutoSignText.txt");
	}
}
