package popbobhack.mods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.minecraft.src.GuiScreenBook;
import net.minecraft.src.Minecraft;
import net.minecraft.src.NBTTagString;

public class BookBot {
	public static int i3 = 0;
	public static void Run(String file){
		try {
			file = "/PopbobHack/Books/" + file + ".txt";
			//System.out.println(file);
			File Book = new File(file);
			if(!Book.exists()) {
				try {
					   Book.getParentFile().mkdirs();
					   }catch(Exception e) {
						   e.printStackTrace();
					   }
				Book.createNewFile();
			}
			if(!(Minecraft.getMinecraft().thePlayer.getHeldItem() == null)) {
			if(Minecraft.getMinecraft().thePlayer.getHeldItem().getUnlocalizedName().equals("item.book_writable")) {
			BufferedReader reader = new BufferedReader(new FileReader(Book));
			String FileText = "";
			String line = reader.readLine();
			while(line != null) {
			FileText+=" " + line;
			line = reader.readLine();
			}
			if(Minecraft.getMinecraft().thePlayer.getHeldItem().hasTagCompound()) {
	    	while(Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").tagCount() > 0) {
	    		Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").removeTag(0);
	    	}
	    	int bookTotalPages = 0;
	    	int i2 = 0;
	    	boolean fuckingpenis = false;
	    	int i4 = 0;
	    	int i5 = 0;
	    	for(float i = 0; i3 < FileText.length() && i < 50; i++) {
	    	String var3 = null;
	    	try {
	    	var3 = FileText.substring(i3, i3 + 256);
	    	try {
	    	i4 = var3.lastIndexOf(" ");
	    	i3+=i4;
	    	var3 = var3.substring(1,i4);
	    	while(var3.startsWith(" ")) {
	    		var3 = var3.substring(2);
	    	}
	    	}catch(Exception e) {
	    		i3 +=256;
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
	    	Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").appendTag(new NBTTagString("" + (bookTotalPages + 1), var3));
	    	bookTotalPages++;
	    	}
	    	}
	    	
	    	if(fuckingpenis) {
	    	i3 = 0;
	    	}
			reader.close();
			} else {
				Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> ERROR: Book needs to have text written in it");
			}
			} else {
				Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> You need to hold a fucking book retard");
			}
			} else {
				Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> You need to hold a fucking book retard");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		GuiScreenBook.bookModified = true;
		
	}
}
