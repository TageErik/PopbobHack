package popbobhack.utils;

import net.minecraft.src.GuiConnecting;
import net.minecraft.src.Minecraft;
import net.minecraft.src.Packet;
import popbobhack.mods.AutoReconnect;

public class AutoReconnbs {
	public static String popbob;
	public static int popbobcountercount = 0;
public static void autoreconnectpenis() {
	try {
	popbob = Packet.serverIpLol.toString();
	}catch(Exception e) {
		popbob = "lolpopbob";
	}
	if(!(popbob == AutoReconnect.popbob)) {
		/*popbobcountercount++;
		if(popbobcountercount >= 500) {
			popbobcountercount = 0;*/
			
		//}
	}
}
}
