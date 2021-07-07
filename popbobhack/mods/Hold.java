package popbobhack.mods;

import popbobhack.main.Category;
import popbobhack.utils.MoveItem;

public class Hold extends Module{

	public Hold() {
		super("Hold", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public static int ItemHoldID = 49;
	
	public void onUpdate() {
		if(isToggled()) {
			MoveItem.MoveItemToHotbar(ItemHoldID);
		}
	}

}
