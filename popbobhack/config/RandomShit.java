package popbobhack.config;

import net.minecraft.src.GuiChest;
import popbobhack.mods.AutoDisconnect;
import popbobhack.mods.AutoWhisper;
import popbobhack.mods.Fly;
import popbobhack.mods.KillAura;

public class RandomShit {
	public static String[] RandomList = new String[500];
	public static int RandomListLength;
	
	public static void SetListToTxt() {
		RandomListLength = Config.SetListToTxt(RandomList, RandomListLength, "/PopbobHack/RandomShit.txt");
		RandomListLength = 5;
		try {
		AutoDisconnect.disconnecthealth = Integer.parseInt(RandomList[0].substring(17));
		AutoWhisper.player = RandomList[1].substring(12);
		Fly.flyHackSpeed = Float.parseFloat(RandomList[2].substring(9));
		KillAura.hitdelay = Integer.parseInt(RandomList[3].substring(16));
		GuiChest.infMode = Boolean.parseBoolean(RandomList[4].substring(8));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void onListUpdated() {
		RandomList[0] = "DisconnectHealth:" + AutoDisconnect.disconnecthealth;
		RandomList[1] = "AutoWhisper:" + AutoWhisper.player;
		RandomList[2] = "FlySpeed:" + Fly.flyHackSpeed;
		RandomList[3] = "ForceFieldDelay:" + KillAura.hitdelay;
		RandomList[4] = "infMode:" + GuiChest.infMode;
		Config.onListUpdated(RandomList, RandomListLength, "/PopbobHack/RandomShit.txt");
	}
}
