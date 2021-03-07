package popbobhack.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import popbobhack.main.PopbobHack;

public class KeyBinds {
	public static String[] KeyBindsList = new String[100];
	public static int KeyBindsListLength;
	
	public static void SetListToTxt() {
		KeyBindsListLength = Config.SetListToTxt(KeyBindsList, KeyBindsListLength, "/PopbobHack/KeyBinds.txt");
		try {
		if(!KeyBindsList[0].equals(PopbobHack.ClientName)) {
			if(!KeyBindsList[0].contains("PopbobHack")) {
			File f = new File("/PopbobHack/KeyBinds.txt");
			f.delete();
			KeyBinds.SetListToTxt();
			} else {
			KeyBindsList[0] = PopbobHack.ClientName;
			int i = PopbobHack.getModules().size();
			while(KeyBindsList[i] == null) {
				KeyBindsList[i] = PopbobHack.getModules().get(i - 1).getName() + ":loser";
				i-=1;
			}
			KeyBindsListLength = PopbobHack.getModules().size();
			onListUpdated();
			}
		}
		}catch(Exception e) {}
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
