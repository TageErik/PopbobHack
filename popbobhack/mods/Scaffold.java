package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.MathHelper;
import net.minecraft.src.Packet15Place;
import net.minecraft.src.Vec3;
import popbobhack.main.Category;
import popbobhack.main.PopbobHack;

public class Scaffold extends Module{

	public Scaffold() {
		super("Scaffold", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public static byte scaffolddelaycount = 0;
	public static byte scaffolddelay = 1;
	public static int sideHit = 0;
	public static int x = 0;
	public static int y = 2;
	public static int z = 0;
	public static Vec3 par69Vec3;
	public static int side = 4;
	public static boolean scaffoldPlace = false;
	private double lastX = 0;
	private double lastY = 0;
	private double lastZ = 0;
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.theWorld.getBlockId((int)mc.thePlayer.posX - 1, (int)mc.thePlayer.posY - 2, (int)mc.thePlayer.posZ) == 0) {
				scaffolddelaycount++;
				mc.gameSettings.keyBindUseItem.pressed = true;
				mc.rightClickDelayTimer = 0;
				if(!mc.theWorld.isAirBlock((int) Math.floor(mc.thePlayer.posX - 1), (int)Math.floor(mc.thePlayer.posY - 2), (int)Math.floor(mc.thePlayer.posZ))) {
					side = 5;
				} else if(!mc.theWorld.isAirBlock((int) Math.floor(mc.thePlayer.posX + 1), (int)Math.floor(mc.thePlayer.posY - 2), (int)Math.floor(mc.thePlayer.posZ))) {
					side = 4;
				} else if(!mc.theWorld.isAirBlock((int) Math.floor(mc.thePlayer.posX), (int)Math.floor(mc.thePlayer.posY - 2), (int)Math.floor(mc.thePlayer.posZ + 1))) {
					side = 2;
				} else if(!mc.theWorld.isAirBlock((int) Math.floor(mc.thePlayer.posX), (int)Math.floor(mc.thePlayer.posY - 2), (int)Math.floor(mc.thePlayer.posZ - 1))) {
					side = 3;
				} else if(!mc.theWorld.isAirBlock((int) Math.floor(mc.thePlayer.posX), (int)Math.floor(mc.thePlayer.posY - 3), (int)Math.floor(mc.thePlayer.posZ))) {
					side = 1;
				}
				lastX = mc.thePlayer.posX;
				lastY = mc.thePlayer.posY;
				lastZ = mc.thePlayer.posZ;
				
				if(side == 4) {
					x = 0;
					y = 2;
					z = 0;
				} else if(side == 3) {
					x = 1;
					y = 2;
					z = 1;
				} else if(side == 2) {
					x = 1;
					y = 2;
					z = -1;
				} else if(side == 5) {
					x = 2;
					y = 2;
					z = 0;
				} else if(side == 1) {
					x = 1;
					y = 3;
					z = 0;
				}
				if(scaffolddelaycount >= scaffolddelay) {
				scaffoldPlace = true;
				
				//mc.thePlayer.sendQueue.addToSendQueue(new Packet15Place((int)mc.thePlayer.posX, (int)mc.thePlayer.posY - 2, (int)mc.thePlayer.posZ - 1,  4, mc.thePlayer.inventory.getCurrentItem(), x, y, z));

				/*int var25 = MathHelper.floor_double((double)(mc.thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;*/	
				
				par69Vec3 = Vec3.createVectorHelper(mc.thePlayer.posX - x, mc.thePlayer.posY-y, mc.thePlayer.posZ-z);
				//mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getCurrentEquippedItem(), (int)mc.thePlayer.posX - x, (int)mc.thePlayer.posY - y, (int)mc.thePlayer.posZ - z,  side, par69Vec3);
				
				scaffolddelaycount = 0;
				}
			} else {	
				if(scaffoldPlace) {
				mc.gameSettings.keyBindUseItem.pressed = false;
				scaffoldPlace = false;
				}
			}
		}

}
}
