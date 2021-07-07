package popbobhack.mods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.src.Minecraft;
import popbobhack.main.Category;
import popbobhack.utils.FoodItems;

public class AutoArmor extends Module {

	public AutoArmor() {
		super("AutoArmor", 0, Category.COMBAT);

	}

	public static short var3;

	public void onUpdate() {
		if (isToggled()) {
			// if(mc.thePlayer.inventory.getStackInSlot(5))
			for (int i = 0; i < 4; i++) {
				try {
					var3 = (short) mc.thePlayer.inventory.armorInventory[i].itemID;
				} catch (Exception e) {
					var3 = 0;
				}

				if (!(var3 == 313 - i)) {
					for (int i2 = 0; i2 < 36; i2++) {
						try {
							if (mc.thePlayer.inventory.mainInventory[i2].itemID == 313 - i) {
								if (i2 < 9) {
									mc.thePlayer.inventory.currentItem = i2;
								} else {
									mc.playerController.windowClick(0, i2, 0, 1, mc.thePlayer);
								}
								mc.gameSettings.keyBindUseItem.pressed = true;
							}
						} catch (Exception e) {
						}
					}
				}
			}
		}
	}
}
