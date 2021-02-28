package popbobhack.mods;

import net.minecraft.src.GuiDisconnected;
import net.minecraft.src.Packet255KickDisconnect;
import popbobhack.main.Category;

public class AutoDisconnect extends Module{

	public AutoDisconnect() {
		super("AutoDisconnect", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	public static int disconnecthealth = 0;
	
	public void onUpdate() {
		if(isToggled()) {
			if(mc.thePlayer.getHealth() < disconnecthealth) {
				GuiDisconnected.reconnectenabled = false;
				mc.theWorld.sendQuittingDisconnectingPacket();
			}
		}
	}

}
