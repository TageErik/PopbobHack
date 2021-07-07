package popbobhack.mods;

import net.minecraft.src.Packet12PlayerLook;
import popbobhack.main.Category;
import popbobhack.utils.MoveItem;

public class BucketMLG extends Module{

	public BucketMLG() {
		super("BucketMLG", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public static boolean HoldingItem;
	public static int on = 0;
	
	public void onUpdate() {
		if(isToggled()) {
			if(mc.thePlayer.fallDistance > 3) {
				on = 0;
				MoveItem.MoveItemToHotbar(326);
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