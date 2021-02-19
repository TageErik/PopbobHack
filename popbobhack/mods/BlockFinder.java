package popbobhack.mods;

import popbobhack.config.Config;
import popbobhack.main.Category;

public class BlockFinder extends Module{

	public BlockFinder() {
		super("BlockFinder", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	public static String[] BlockFinderList = new String[100];
	public static int BlockFinderListLength;
	
	public void onUpdate() {
	}
	
	public static void SetListToTxt() {
		BlockFinderListLength = Config.SetListToTxt(BlockFinderList, BlockFinderListLength, "/PopbobHack/FinderBlocks.txt");
	}
	
	
	
	public static void onListUpdated() {
		Config.onListUpdated(BlockFinderList, BlockFinderListLength, "/PopbobHack/FinderBlocks.txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, BlockFinderList, BlockFinderListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, BlockFinderList, BlockFinderListLength);
	}
	
	
	public static void BlockFinderListPrint() {
		Config.ListPrint(BlockFinderList, BlockFinderListLength);
	}

}
