package popbobhack.config;

public class Shortcuts {
	public static String[] ShortcutsList = new String[500];
	public static int ShortcutsListLength;
	
	public static void SetListToTxt() {
		ShortcutsListLength = Config.SetListToTxt(ShortcutsList, ShortcutsListLength, "/PopbobHack/Shortcuts.txt");
	}
	
	public static void onListUpdated() {
		Config.onListUpdated(ShortcutsList, ShortcutsListLength, "/PopbobHack/Shortcuts.txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, ShortcutsList, ShortcutsListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, ShortcutsList, ShortcutsListLength);
	}
	
	
	public static void ShortcutsListPrint() {
		Config.ListPrint(ShortcutsList, ShortcutsListLength);
	}
}
