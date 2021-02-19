package popbobhack.utils;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStationary;
import net.minecraft.src.Minecraft;
import popbobhack.mods.Xray;

public class XrayUtils {
	public static void initXRayBlocks() {
		Xray.xrayBlocks.clear();
		for(int i = 0; i < Xray.xrayIds.size(); i++) {
			Xray.xrayBlocks.add(Block.blocksList[Xray.xrayIds.get(i)]);
		}
	}
	
	public static boolean isXrayBlock(Block b) {
		if(Xray.xrayBlocks.contains(b)) {
			return true;
		}
		return false;
	}
}
