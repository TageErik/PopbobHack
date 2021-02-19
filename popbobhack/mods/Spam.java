package popbobhack.mods;

import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.Packet255KickDisconnect;
import popbobhack.main.Category;

public class Spam extends Module{

	public Spam() {
		super("Spam", 0, Category.PLAYER);
		
	}
	
	public static int delaycount = 0;
	public static int delay = 100;
 public void onUpdate() {
	 if(isToggled()) {
		 delaycount++;
		 if(delaycount >= delay) {
		 int min = 10000;
		 int max = 1000000;
		 int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		 mc.thePlayer.sendChatMessage("I Just Popbob'd " + randomNum + " Bases And Monuments Thanks To PopbobHack!");
		 delaycount = 0;
		 }
	 }
 }
}
