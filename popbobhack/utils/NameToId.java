package popbobhack.utils;

import net.minecraft.src.Item;

public class NameToId {
	public static int NameToIdFunc(String var3) {
		for(int i = 0; i < Item.itemsList.length; i++) {
			try {
			//System.out.println(item.itemsList[i]);
			if(var3.equalsIgnoreCase(Item.itemsList[i].getStatName())) {
				return Item.itemsList[i].itemID;
			}
			}catch(Exception e) {}
		}
		return 0;
	}
}
