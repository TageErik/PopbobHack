package popbobhack.utils;

import net.minecraft.src.Block;

public class NameToId {
	public static int NameToIdFunc(String var3) {
		for(int i = 0; i < Block.blocksList.length; i++) {
			try {
			//System.out.println(Block.blocksList[i]);
			if(var3.equalsIgnoreCase(Block.blocksList[i].getLocalizedName())) {
				return Block.blocksList[i].blockID;
			}
			}catch(Exception e) {}
		}
		return 0;
	}
}
