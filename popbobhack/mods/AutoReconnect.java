package popbobhack.mods;


import net.minecraft.src.IntegratedServer;
import net.minecraft.src.Minecraft;
import net.minecraft.src.Packet;
import popbobhack.main.Category;

public class AutoReconnect extends Module{

	public AutoReconnect() {
		super("AutoReconnect", 0, Category.PLAYER);
		
	}
	public static String popbob;
	public void onUpdate() {
		if(isToggled()) {
				try {
					popbob = Packet.serverIpLol.toString();
				mc.getLogAgent().logInfo(popbob);
				}catch(Exception e) {}
		}
	}
	public void onEnable() {

	}
}
