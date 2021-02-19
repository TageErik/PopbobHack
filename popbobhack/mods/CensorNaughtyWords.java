package popbobhack.mods;

import popbobhack.config.Config;
import popbobhack.main.Category;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.common.base.FinalizableWeakReference;

import net.minecraft.src.Minecraft;
public class CensorNaughtyWords extends Module{

	public CensorNaughtyWords() {
		super("CensorWords", 0, Category.RENDER);
		
	}
	public static String[] CensorWords = new String[100];
	public static int CensorWordsLength;
	
	
	public static void SetListToTxt() {
		CensorWordsLength = Config.SetListToTxt(CensorWords, CensorWordsLength, "/PopbobHack/CensorWordsList.txt");
	}
	
	
	
	public static void onListUpdated() {
		Config.onListUpdated(CensorWords, CensorWordsLength, "/PopbobHack/CensorWordsList.txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, CensorWords, CensorWordsLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, CensorWords, CensorWordsLength);
	}
	
	
	public static void CensorWordsPrint() {
		Config.ListPrint(CensorWords, CensorWordsLength);
}
}
