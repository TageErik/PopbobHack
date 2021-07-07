package popbobhack.utils;

import net.minecraft.src.Minecraft;

public class MoveItem {

	public static void MoveItemToHotbar(int itemID) {
		Minecraft mc = Minecraft.getMinecraft();
		boolean HoldingItem = false;
		try {
			if(mc.thePlayer.getHeldItem().itemID == itemID) {
				HoldingItem = true;
			}
		} catch(Exception e) {
		}

		for(int i69 = 0; i69 < 2 /*&& HoldingItem == false*/; i69++) {
			for(int i = 0; i < 36; i++) {
				try {
					if(mc.thePlayer.inventory.mainInventory[i].itemID == itemID) {
						if(i < 9) {
							mc.thePlayer.inventory.currentItem = i;
						} else {
							mc.playerController.windowClick(0, i, 0, 1, mc.thePlayer);
							if(mc.thePlayer.inventory.mainInventory[i] != null) {
								mc.playerController.windowClick(0, i, 0, 2, mc.thePlayer);
							}
						}
						HoldingItem = true;
					}
				} catch(Exception e) {
				}
				if(HoldingItem == true) {
					break;
				}
			}
		}
/*		if(HoldingItem == true) {
			mc.gameSettings.keyBindUseItem.pressed = true;
		}*/
	}
}
