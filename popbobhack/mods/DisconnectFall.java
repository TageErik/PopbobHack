package popbobhack.mods;

import net.minecraft.src.GuiDisconnected;
import popbobhack.main.Category;

public class DisconnectFall extends Module{

	public DisconnectFall() {
		super("DisconnectNoFall", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public static int falldistancedisconnect = 7;
	public void onUpdate() {
		if(isToggled()) {
			if(!mc.theWorld.isAirBlock((int)mc.thePlayer.posX,(int)mc.thePlayer.posY - 5 , (int)mc.thePlayer.posZ) && !mc.thePlayer.onGround && mc.thePlayer.motionY < 0 && mc.thePlayer.fallDistance > falldistancedisconnect) {
				mc.thePlayer.fallDistance = 0;
				GuiDisconnected.reconnectenabled = true;
				mc.theWorld.sendQuittingDisconnectingPacket();
			}
		}
	}

}