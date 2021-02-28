package popbobhack.config;

import net.minecraft.src.GuiChest;
import net.minecraft.src.GuiDisconnected;
import popbobhack.mods.AutoDisconnect;
import popbobhack.mods.AutoWhisper;
import popbobhack.mods.BookBot;
import popbobhack.mods.DisconnectFall;
import popbobhack.mods.Fly;
import popbobhack.mods.KillAura;
import popbobhack.mods.SignBot;

public class RandomShit {
	public static String[] RandomList = new String[500];
	public static int RandomListLength;
	
	public static void SetListToTxt() {
		RandomListLength = Config.SetListToTxt(RandomList, RandomListLength, "/PopbobHack/RandomShit.txt");
		RandomListLength = 10;
		try {
		AutoDisconnect.disconnecthealth = Integer.parseInt(RandomList[0].substring(17));
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
		AutoWhisper.player = RandomList[1].substring(12);
		}catch(Exception e) {}
		try {
		Fly.flyHackSpeed = Float.parseFloat(RandomList[2].substring(9));
		}catch(Exception e) {}
		try {
		KillAura.hitdelay = Integer.parseInt(RandomList[3].substring(16));
		}catch(Exception e) {}
		try {
		GuiChest.infMode = Boolean.parseBoolean(RandomList[4].substring(8));
		}catch(Exception e) {}
		try {
		GuiDisconnected.reconnecttimerdelay = Integer.parseInt(RandomList[5].substring(19));
		GuiDisconnected.reconnecttimer = GuiDisconnected.reconnecttimerdelay;
		}catch(Exception e) {}
		try {
		DisconnectFall.falldistancedisconnect = Integer.parseInt(RandomList[6].substring(25));
			}catch(Exception e) {}
		try {
		BookBot.i3 = Integer.parseInt(RandomList[7].substring(13));
			}catch(Exception e) {}
		try {
		SignBot.i3 = Integer.parseInt(RandomList[8].substring(13));
			}catch(Exception e) {}
		try {
		SignBot.file2 = RandomList[9].substring(12);
			}catch(Exception e) {}
	}
	
	public static void onListUpdated() {
		RandomList[0] = "DisconnectHealth:" + AutoDisconnect.disconnecthealth;
		RandomList[1] = "AutoWhisper:" + AutoWhisper.player;
		RandomList[2] = "FlySpeed:" + Fly.flyHackSpeed;
		RandomList[3] = "ForceFieldDelay:" + KillAura.hitdelay;
		RandomList[4] = "infMode:" + GuiChest.infMode;
		RandomList[5] = "AutoReconnectDelay:" + GuiDisconnected.reconnecttimerdelay;
		RandomList[6] = "DisconnectNoFallDistance:" + DisconnectFall.falldistancedisconnect;
		RandomList[7] = "BookDistance:" + BookBot.i3;
		RandomList[8] = "SignDistance:" + SignBot.i3;
		RandomList[9] = "SignBotName:" + SignBot.file2;
		Config.onListUpdated(RandomList, RandomListLength, "/PopbobHack/RandomShit.txt");
	}
}
