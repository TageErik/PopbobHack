package popbobhack.utils;

import net.minecraft.src.Minecraft;

public class WaypointGoto {

	public static void Waypoint(String var3) {
		for(int i = 0; i < popbobhack.config.Waypoint.WaypointListLength; i++) {
			if(popbobhack.config.Waypoint.WaypointList[i].contains(var3.toLowerCase())) {
				var3 = ".EnderShitter goto" + popbobhack.config.Waypoint.WaypointList[i].substring(popbobhack.config.Waypoint.WaypointList[i].indexOf(":") + 1);
				ChatCommands.sendChatmsgs(var3);
				break;
			}
		}
		
	}

}
