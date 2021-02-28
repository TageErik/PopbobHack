package popbobhack.mods;


import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiMultiplayer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.IntegratedServer;
import net.minecraft.src.Minecraft;
import net.minecraft.src.Packet;
import net.minecraft.src.ServerData;
import popbobhack.main.Category;

public class AutoReconnect{


	public static String serverIP = "macrochasm.net:25565";

	public static void Reconnect() {
		GuiMultiplayer GuiMultiplayer = new GuiMultiplayer((GuiScreen)null);
		ServerData par1ServerData = new ServerData("Macrochasm", "macrochasm.net:25565");
		GuiMultiplayer.mc.displayGuiScreen(new GuiConnecting(GuiMultiplayer, GuiMultiplayer.mc, par1ServerData));
	}
}
