package popbobhack.config;

public class InventoryActions {

	public static String ActionName;
	public static String[] ActionList = new String[50000];
	public static int ActionListLength;
	
	public static void SetListToTxt() {
		ActionListLength = Config.SetListToTxt(ActionList, ActionListLength, "/PopbobHack/Actions/" + ActionName + ".txt");
	}
	
	public static void onListUpdated() {
		Config.onListUpdated(ActionList, ActionListLength, "/PopbobHack/Actions/" + ActionName + ".txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, ActionList, ActionListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, ActionList, ActionListLength);
	}
	
	
	public static void ActionListPrint() {
		Config.ListPrint(ActionList, ActionListLength);
	}
	
}
