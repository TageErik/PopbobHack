package popbobhack.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class KeyBinds {
	public static String[] KeyBindsList = new String[100];
	public static int KeyBindsListLength;
	
	public static void SetListToTxt() {
		KeyBindsListLength = Config.SetListToTxt(KeyBindsList, KeyBindsListLength, "/PopbobHack/KeyBinds.txt");
	}
	
	
	
	public static void onListUpdated() {
		Config.onListUpdated(KeyBindsList, KeyBindsListLength, "/PopbobHack/KeyBinds.txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, KeyBindsList, KeyBindsListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, KeyBindsList, KeyBindsListLength);
	}
	
	
	public static void KeyBindsListPrint() {
		Config.ListPrint(KeyBindsList, KeyBindsListLength);
	}
}
