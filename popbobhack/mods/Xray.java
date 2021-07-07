package popbobhack.mods;

import java.util.ArrayList;
import java.util.Arrays;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.Block;
import net.minecraft.src.RenderBlocks;
import popbobhack.config.Config;
import popbobhack.main.Category;
import popbobhack.utils.XrayUtils;

public class Xray extends Module{

	public static ArrayList<Block> xrayBlocks = new ArrayList();
	public static ArrayList<Integer> xrayIds = new ArrayList<Integer>();
	public Xray() {
		super("Xray", 0, Category.RENDER);
	}

	public void onEnable() {
		XrayUtils.initXRayBlocks();
		mc.renderGlobal.loadRenderers();
		RenderBlocks.renderAllFaces = true;
	}
	public void onDisable() {
		mc.renderGlobal.loadRenderers();
		RenderBlocks.renderAllFaces = false;
	}
	
	public static String[] xrayBlocksList = new String[500];
	public static int xrayBlocksLength;
	
	public static void SetListToTxt() {
		xrayBlocksLength = Config.SetListToTxt(xrayBlocksList, xrayBlocksLength, "/PopbobHack/XrayIds.txt");
		for(int i = 0; i < xrayBlocksLength; i++) {
		xrayIds.add(Integer.parseInt(xrayBlocksList[i]));
		}
	}
	
	
	
	public static void onListUpdated() {
		xrayBlocksList = new String[500];
		for(int i = 0; i < xrayIds.size(); i++) {
			xrayBlocksList[i] = String.valueOf(xrayIds.get(i));
		}
		xrayBlocksLength = xrayIds.size();
		Config.onListUpdated(xrayBlocksList, xrayBlocksLength, "/PopbobHack/XrayIds.txt");
	}
}