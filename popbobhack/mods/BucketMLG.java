package popbobhack.mods;

import net.minecraft.src.Packet12PlayerLook;
import popbobhack.main.Category;

public class BucketMLG extends Module{

	public BucketMLG() {
		super("BucketMLG", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public static boolean HoldingBucket;
	public static int on = 0;
	
	public void onUpdate() {
		if(isToggled()) {
			if(mc.thePlayer.fallDistance > 3) {
				HoldingBucket = false;
				on = 0;
				try {	
				if(mc.thePlayer.getHeldItem().itemID == 326) {
					HoldingBucket = true;
				} 
				} catch(Exception e) {
				}
				
				if(HoldingBucket == false) {
					for(int i = 0; i < 36; i++) {
						try {
							if(mc.thePlayer.inventory.mainInventory[i].itemID == 326) {
							if(i < 9) {
							mc.thePlayer.inventory.currentItem = i;
							} else {
								mc.playerController.windowClick(0, i, 0, 1, mc.thePlayer);
							}
							HoldingBucket = true;
							}
						} catch(Exception e) {}
						if(HoldingBucket == true) {
							break;
						}
					}
				}
				if(HoldingBucket == true) {
					mc.gameSettings.keyBindUseItem.pressed = true;
				}
				} else {
					if(on == 0) {				
						mc.gameSettings.keyBindUseItem.pressed = false;
					}
					if(on == 4) {					
						mc.gameSettings.keyBindUseItem.pressed = true;
					}
					if(on == 8) {				
						mc.gameSettings.keyBindUseItem.pressed = false;
					}
					if(on < 10) {
						on++;
					}
				}
		}
	}
}