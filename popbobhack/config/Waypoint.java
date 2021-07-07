package popbobhack.config;

public class Waypoint {

	
	public static String[] WaypointList = new String[100];
	public static int WaypointListLength;
	
	public static void SetListToTxt() {
		WaypointListLength = Config.SetListToTxt(WaypointList, WaypointListLength, "/PopbobHack/Waypoints.txt");
	}
	
	
	
	public static void onListUpdated() {
		Config.onListUpdated(WaypointList, WaypointListLength, "/PopbobHack/Waypoints.txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, WaypointList, WaypointListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, WaypointList, WaypointListLength);
	}
	
	
	public static void WaypointListPrint() {
		Config.ListPrint(WaypointList, WaypointListLength);
	}
}
