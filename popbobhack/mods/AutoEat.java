package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiScreen;
import popbobhack.main.Category;
import popbobhack.utils.FoodItems;
import popbobhack.utils.MoveItem;

public class AutoEat extends Module{

	public AutoEat() {
		super("AutoEat", 0, Category.PLAYER);
		
	}
	public static boolean isFoodItem;
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.getFoodStats().needFood()) {
			isFoodItem = false;
			try {	
			for(int i = 0; i < FoodItems.FoodItemsIDS.size(); i++) {
			if(mc.thePlayer.getHeldItem().itemID == FoodItems.FoodItemsIDS.get(i)) {
				isFoodItem = true;
			} 
			}
			} catch(Exception e) {}
			
			if(isFoodItem == false) {
				for(int i2 = 0; i2 < FoodItems.FoodItemsIDS.size(); i2++) {
					MoveItem.MoveItemToHotbar(FoodItems.FoodItemsIDS.get(i2));
				}
			}
			if(isFoodItem == true) {
				mc.gameSettings.keyBindUseItem.pressed = true;
			}
			} else {
			if(isFoodItem == true) {
				mc.gameSettings.keyBindUseItem.pressed = false;
				isFoodItem = false;
			}
			}
			super.onUpdate();
		}
	}
	   public void onDisable() {
		   mc.gameSettings.keyBindUseItem.pressed = false;
		   super.onDisable();
	   }

}

