package popbobhack.config;

import popbobhack.main.PopbobHack;
import popbobhack.mods.Module;

public class SaveSettings {
	
	public static String[] SettingsList = new String[100];
	public static int SettingsListLength;
	
	public static void SetListToTxt() {
		SettingsListLength = Config.SetListToTxt(SettingsList, SettingsListLength, "/PopbobHack/SettingsSave.txt");
	}
	
	
	
	public static void onListUpdated() {
		Config.onListUpdated(SettingsList, SettingsListLength, "/PopbobHack/SettingsSave.txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, SettingsList, SettingsListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, SettingsList, SettingsListLength);
	}
	
	
	public static void SettingsListPrint() {
		Config.ListPrint(SettingsList, SettingsListLength);
	}

}
