package popbobhack.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import net.minecraft.src.Minecraft;
import popbobhack.main.PopbobHack;

public class Config {	
	public static int SetListToTxt(String[] List, int ListLength, String name) {
		try {
		   String home = System.getProperty("user.home");
		   name = home + name;
		   name.replaceAll("/", Pattern.quote(File.separator));
		   File file = new File(name);
		   if(!file.exists()) {
			   try {
			   file.getParentFile().mkdirs();
			   }catch(Exception e) {
				   e.printStackTrace();
			   }
			   file.createNewFile();
			   if(List == KeyBinds.KeyBindsList) {
				   int i = 0;
				   String Content = PopbobHack.ClientName + System.lineSeparator();
			       while(i < PopbobHack.getModules().size()) {
				    	 Content += PopbobHack.getModules().get(i).getName() + ":loser" + System.lineSeparator();
				    	 i++;
				       }
			       FileWriter writer = new FileWriter(file);
			       writer.write(Content);
			       writer.close();
			   }
		   }
	       String oldContent = "";
	       BufferedReader reader = new BufferedReader(new FileReader(file));
	       String line = reader.readLine();
	       int i = 0;
	       while(line != null) {
	    	 List[i] = line;
	    	 i++;
	    	 line = reader.readLine();
	       }
	       ListLength = i;
	       reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ListLength;
	}
	
	
	
	public static void onListUpdated(String[] List, int ListLength, String name) {
			try {
			   String home = System.getProperty("user.home");
			   name = home + name;
			   name.replaceAll("/", Pattern.quote(File.separator));
		       File file = new File(name);
		       String Content = "";
		       BufferedReader reader = new BufferedReader(new FileReader(file));
		       String line = reader.readLine();
		       int i = 0;
		       while(i < ListLength) {
		    	 Content = Content + List[i] + System.lineSeparator();
		    	 i++;
		       }
		       
		       FileWriter writer = new FileWriter(file);
		       writer.write(Content);
		       reader.close();
		       writer.close();
			}catch(Exception e) {
			}
	}
	
	public static int FindLocationOfWord(String var3, String[] List, int ListLength) {
		for(int i = 0; i < ListLength; i++) {
			if(var3.equalsIgnoreCase(List[i])) {
				return i;
			}
		}
		return 1337;
	}
	
	public static void onRemoveElement(int location, String[] List, int ListLength) {
		for(int i = location + 1; i < ListLength; i++) {
			List[i-1] = List[i];
		}
	}
	
	
	public static void ListPrint(String[] List, int ListLength) {
		String ListString = "";
		for(int i = 0; i < ListLength; i++) {
			ListString += List[i];
			ListString += ", ";
		}
		ListString = ListString.substring(0, ListString.length() - 2);
		Minecraft.getMinecraft().thePlayer.addChatMessage(ListString);
	}

}
