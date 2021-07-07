package popbobhack.mods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import net.minecraft.src.GuiEditSign;
import net.minecraft.src.Minecraft;
import net.minecraft.src.NBTTagString;
import popbobhack.config.RandomShit;
import popbobhack.main.Category;

public class SignBot extends Module{

	public SignBot() {
		super("SignBot", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	public static String file2 = "reasons why your mom is cool";
	public static int i3 = 0;
	
	public static void CreateSignText() {
		try {
			String file = "/PopbobHack/Signs/" + file2 + ".txt";
			//System.out.println(file);
			String home = System.getProperty("user.home");
			file = home + file;
			file.replaceAll("/", Pattern.quote(File.separator));
			File Sign = new File(file);
			if(!Sign.exists()) {
				try {
					   Sign.getParentFile().mkdirs();
					   }catch(Exception e) {
						   e.printStackTrace();
					   }
				Sign.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(Sign));
			String FileText = "";
			String line = reader.readLine();
			while(line != null) {
			FileText+=" " + line;
			line = reader.readLine();
			}
	    	int SignTotalPages = 0;
	    	int i2 = 0;
	    	boolean fuckingpenis = false;
	    	int i4 = 0;
	    	int i5 = 0;
	    	for(float i = 0; i3 < FileText.length() && i < 4; i++) {
	    	String var3 = null;
	    	try {
	    	var3 = FileText.substring(i3, i3 + 15);
	    	try {
	    	i4 = var3.lastIndexOf(" ");
	    	i3+=i4;
	    	var3 = var3.substring(1,i4);
	    	while(var3.startsWith(" ")) {
	    		var3 = var3.substring(2);
	    	}
	    	}catch(Exception e) {
	    		i3 +=15;
	    	}
	    	}catch(Exception e) {
	    	fuckingpenis = true;
	    	var3 = FileText.substring(i3, FileText.length());
	    	while(var3.startsWith(" ")) {
	    		var3 = var3.substring(1);
	    	}
	    	i3 = FileText.length() + 1; 
	    	
	    	}
	    	if(var3 != null) {
	    	GuiEditSign.entitySign.signText[SignTotalPages] = var3;
	    	SignTotalPages++;
	    	}
	    	}
	    	
	    	if(fuckingpenis) {
	    	i3 = 0;
	    	}
	    	RandomShit.onListUpdated();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
