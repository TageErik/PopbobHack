package popbobhack.utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.text.WordUtils;
import org.lwjgl.input.Keyboard;

import net.minecraft.src.Block;
import net.minecraft.src.GuiChest;
import net.minecraft.src.GuiDisconnected;
import net.minecraft.src.GuiEditSign;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiScreenBook;
import net.minecraft.src.Item;
import net.minecraft.src.ItemEditableBook;
import net.minecraft.src.Minecraft;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagString;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet250CustomPayload;
import popbobhack.config.KeyBinds;
import popbobhack.config.RandomShit;
import popbobhack.main.PopbobHack;
import popbobhack.mods.*;

public class ChatCommands {
	
	public static NBTTagList bookPagesCopy = null;
	public static int pagesSpam = 50;
	public static boolean closeBook = false;
	public static NBTTagList bookPages;
	public static boolean autotiting = false;
	public static int autotittimer = 0;
	public static boolean autotitnow = false;
	public static void sendChatmsgs(String var3) {
	if(var3.startsWith(".")) {
		try {
		boolean commandfound = false;
		if(PopbobHack.getModules().get(34).isToggled()) {
			Minecraft.getMinecraft().thePlayer.sendChatMessage(var3);
		}
		
		Pattern pattern = Pattern.compile(".Recording", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(var3);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      commandfound = true;
	      var3 = var3.substring(11, var3.length());
	      Recording.RecordingName = var3;
	      PopbobHack.getModules().get(32).toggle();
	      Recording.SetListToTxt();
	    }  else {
	    	pattern = Pattern.compile(".Macro", Pattern.CASE_INSENSITIVE);
		    matcher = pattern.matcher(var3);
		    matchFound = matcher.find();
		    if(matchFound) {
		      commandfound = true;
		      var3 = var3.substring(7, var3.length());
		      Macro.MacroName = var3;
		      Recording.RecordingName = var3;
		      Macro.first = true;
		      PopbobHack.getModules().get(33).toggle();
		      Recording.SetListToTxt();
		    }  else {	
		String str1 = ".";
		int size = PopbobHack.mods.size();
		for(int i = 0; i < size; i++) {
			String str2 = PopbobHack.getModules().get(i).getName();
			String str3 = str1.concat(str2);
			if(var3.equalsIgnoreCase(str3)) {
				PopbobHack.getModules().get(i).toggle();
				commandfound = true;
				break;
			}
		}
	    }
	    }
	    pattern = Pattern.compile(".Fly speed ", Pattern.CASE_INSENSITIVE);
	    matcher = pattern.matcher(var3);
	    matchFound = matcher.find();
	    if(matchFound) {
	      commandfound = true;
	      var3 = var3.substring(10, var3.length());
	      float var3tofloat = Float.parseFloat(var3);
	      Fly.flyHackSpeed = var3tofloat;
	      RandomShit.onListUpdated();
	    } 
	    	
	    	
	    	pattern = Pattern.compile(".Fly yspeed ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	      commandfound = true;	
    	      var3 = var3.substring(11, var3.length());
    	      float var3tofloat = Float.parseFloat(var3);
    	      Fly.flyHackHorizontalSpeed = var3tofloat;
    	    } 
    	    
    	    
    	    pattern = Pattern.compile(".Xray add ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	      commandfound = true;	
    	      var3 = var3.substring(10, var3.length());
    	      int var3toint = 0;
    	      try {
          	       var3toint = Integer.parseInt(var3);
          	      }catch(Exception e) {
          	    	var3toint = NameToId.NameToIdFunc(var3);
          	      }
    	      try {
    	      Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> " + Block.blocksList[var3toint].getLocalizedName() + " was added to Xray!");
    	      }catch(Exception e) {
    	    	  int var3toint1 = 0;
        	      try {
              	       var3toint1 = Integer.parseInt(var3);
              	     Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> hello I am the infamous griefer popbob and I've come to inform you that \"" + WordUtils.capitalizeFully(var3) + "\" is in fact not a valid block id and that you are mentally retarded");	
              	      }catch(Exception e1) {
              	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> hello I am the infamous griefer popbob and I've come to inform you that \"" + WordUtils.capitalizeFully(var3) + "\" is in fact not a block and that you are mentally retarded");	
              	      }	
    	    	    }
    	     if(!Xray.xrayIds.contains(var3toint)) { 
    	     Xray.xrayIds.add(var3toint);
    	     }
    	      if(PopbobHack.getModules().get(4).isToggled()) {
    	    	  XrayUtils.initXRayBlocks();
    	    	  Minecraft.getMinecraft().renderGlobal.loadRenderers();  
    	      }
    	      Xray.onListUpdated();
    	    }
    	     pattern = Pattern.compile(".Xray del ", Pattern.CASE_INSENSITIVE);
      	    matcher = pattern.matcher(var3);
      	    matchFound = matcher.find();
      	    if(matchFound) {
      	      commandfound = true;
      	      var3 = var3.substring(10, var3.length());
      	    int var3toint = 0;
  	      try {
        	       var3toint = Integer.parseInt(var3);
        	      }catch(Exception e) {
        	    	var3toint = NameToId.NameToIdFunc(var3);
        	      }
  	    try { 
  	    Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> " + Block.blocksList[var3toint].getLocalizedName() + " was removed from Xray!");
  	    }catch(Exception e) {
  	    	int var3toint1 = 0;
    	      try {
          	       var3toint1 = Integer.parseInt(var3);
          	     Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> hello I am the infamous griefer popbob and I've come to inform you that \"" + WordUtils.capitalizeFully(var3) + "\" is in fact not a valid block id and that you are mentally retarded");	
          	      }catch(Exception e1) {
          	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> hello I am the infamous griefer popbob and I've come to inform you that \"" + WordUtils.capitalizeFully(var3) + "\" is in fact not a block and that you are mentally retarded");	
          	      }	
  	    }
  	    
  	    	if(Xray.xrayIds.contains(var3toint)) { 
  	    		Xray.xrayIds.remove(Xray.xrayIds.indexOf(var3toint));
  	    		}
  	    
      	      if(PopbobHack.getModules().get(4).isToggled()) {
      	    	  XrayUtils.initXRayBlocks();
      	    	  Minecraft.getMinecraft().renderGlobal.loadRenderers();  
      	      }
      	    Xray.onListUpdated();
    	    }
      	    
      	    pattern = Pattern.compile(".Tele x ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(8, var3.length());
    	    	Teleport.telex = Float.parseFloat(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".KillAura delay ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(16, var3.length());
    	    	KillAura.hitdelay = Integer.parseInt(var3);
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".Scaffold delay ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(16, var3.length());
    	    	Scaffold.scaffolddelay = (byte) Integer.parseInt(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".Scaffold x ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(12, var3.length());
    	    	Scaffold.x = Integer.parseInt(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".Scaffold y ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(12, var3.length());
    	    	Scaffold.y = Integer.parseInt(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".Scaffold z ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(12, var3.length());
    	    	Scaffold.z = Integer.parseInt(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".Scaffold sideHit ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(18, var3.length());
    	    	Scaffold.sideHit = Integer.parseInt(var3);
    	    }
    	    
    	    
    	    pattern = Pattern.compile(".spam delay ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(12, var3.length());
    	    	Spam.delay = Integer.parseInt(var3);
    	    	
    	    }
    	    
    	    pattern = Pattern.compile(".CutShit ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(9, var3.length());
    	    	Macro.cutNothing = Boolean.parseBoolean(var3);
    	    	
    	    }
    	    
    	    
    	    
    	    pattern = Pattern.compile(".goto add ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(10, var3.length());
    	    	Minecraft.getMinecraft().thePlayer.rotationYaw += Float.parseFloat(var3);
    	    	
    	    }
    	    pattern = Pattern.compile(".pp goto ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(9, var3.length());
    	    	//Minecraft.getMinecraft().thePlayer.addChatMessage(var3);
    	    	
        	    	for(int i = 0; i < var3.length(); i++) {
        	    		String var4 = var3.substring(i,i+1);
        	    		if(var4.contains(" ")) {
        	    			String var5 = var3.substring(0, i);
        	    			String var6 = var3.substring(i+1);
        	    			EnderShit.Destinationx = Integer.parseInt(var5);
        	    			EnderShit.Destinationz = Integer.parseInt(var6);
        	    		}
        	    	}

    	    } else {
    	    	pattern = Pattern.compile(".goto ", Pattern.CASE_INSENSITIVE);
	    	    matcher = pattern.matcher(var3);
	    	    matchFound = matcher.find();
	    	    if(matchFound) {
	    	    	commandfound = true;
	    	    	var3 = var3.substring(6, var3.length());
	    	    	pattern = Pattern.compile(" ", Pattern.CASE_INSENSITIVE);
	        	    matcher = pattern.matcher(var3);
	        	    matchFound = matcher.find();
	        	    if(matchFound) {
	        	    	for(int i = 0; i < var3.length(); i++) {
	        	    		String var4 = var3.substring(i,i+1);
	        	    		if(var4.contains(" ")) {
	        	    			String var5 = var3.substring(0, i);
	        	    			String var6 = var3.substring(i+1);
	        	    			Goto.GotoLocation(Integer.parseInt(var5), Integer.parseInt(var6));
	        	    		}
	        	    	}
	        	    } else {
	        	    	var3 = String.valueOf(Integer.valueOf("hej"));
	        	    }
	    	    }
    	    }
    	   
    	    
    	    
    	    pattern = Pattern.compile(".CustomAuthor ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(14, var3.length());
    	    	CustomBook.TotallyLegitAuthorName = var3;
    	    	CustomBook.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".CustomTitle ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(13, var3.length());
    	    	CustomBook.TotallyLegitTitle = var3;
    	    	CustomBook.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".pp timerAdd ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(13, var3.length());
    	    	EnderShit.timerAdd = Float.parseFloat(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".pp pathLength ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(15, var3.length());
    	    	EnderShit.pathLength = Integer.parseInt(var3);
    	    } 
    	    
    	    pattern = Pattern.compile(".vclip ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(7, var3.length());
    	    	int distance = Integer.parseInt(var3);
    	    	Minecraft.getMinecraft().thePlayer.setPositionAndUpdate(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY + distance, Minecraft.getMinecraft().thePlayer.posZ);
    	    }
    	    
    	    pattern = Pattern.compile(".steal infMode ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(15, var3.length());
    	    	GuiChest.infMode = Boolean.parseBoolean(var3);
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".Ascend ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(8, var3.length());
    	    	Ascend.AscendNumber = Integer.parseInt(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".CensorWords add ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(17, var3.length());
    	    	CensorNaughtyWords.CensorWords[CensorNaughtyWords.CensorWordsLength] = var3;
    	    	CensorNaughtyWords.CensorWordsLength +=1;
    	    	CensorNaughtyWords.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".CensorWords del ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(17, var3.length());
    	    	try {
    	    	int hejsannoob = CensorNaughtyWords.FindLocationOfWord(var3);
    	    	if(hejsannoob < 1337) {
    	    	CensorNaughtyWords.onRemoveElement(hejsannoob);
    	    	CensorNaughtyWords.CensorWordsLength -=1;
    	    	CensorNaughtyWords.onListUpdated();
    	    	}
    	    	}catch(Exception e) {
    	    		
    	    	}
    	    }
    	    
    	    pattern = Pattern.compile(".side ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(6, var3.length());
    	    	Scaffold.side = Integer.parseInt(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".calc ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(6, var3.length());
    	    	MathCalc.DoMath(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".math ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(6, var3.length());
    	    	MathCalc.DoMath(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".AutoReconnect delay ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(21, var3.length());
    	    	GuiDisconnected.reconnecttimerdelay = Integer.parseInt(var3);
    	    	GuiDisconnected.reconnecttimer = GuiDisconnected.reconnecttimerdelay;
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".CensorWords print")) {
    	    	commandfound = true;
    	    	CensorNaughtyWords.CensorWordsPrint();
    	    }

    	    if(var3.equalsIgnoreCase(".CensorWords Default")) {
    	    	commandfound = true;
 				   int i = 0;
 				   String Content = "anal\r\n"
 				   		+ "anus\r\n"
 				   		+ "arse\r\n"
 				   		+ "ass\r\n"
 				   		+ "ballsack\r\n"
 				   		+ "balls\r\n"
 				   		+ "bastard\r\n"
 				   		+ "bitch\r\n"
 				   		+ "biatch\r\n"
 				   		+ "bloody\r\n"
 				   		+ "blowjob\r\n"
 				   		+ "blow job\r\n"
 				   		+ "bollock\r\n"
 				   		+ "bollok\r\n"
 				   		+ "boner\r\n"
 				   		+ "boob\r\n"
 				   		+ "bugger\r\n"
 				   		+ "bum\r\n"
 				   		+ "butt\r\n"
 				   		+ "buttplug\r\n"
 				   		+ "clitoris\r\n"
 				   		+ "cock\r\n"
 				   		+ "coon\r\n"
 				   		+ "crap\r\n"
 				   		+ "cunt\r\n"
 				   		+ "damn\r\n"
 				   		+ "dick\r\n"
 				   		+ "dildo\r\n"
 				   		+ "dyke\r\n"
 				   		+ "fag\r\n"
 				   		+ "feck\r\n"
 				   		+ "fellate\r\n"
 				   		+ "fellatio\r\n"
 				   		+ "felching\r\n"
 				   		+ "fuck\r\n"
 				   		+ "fudgepacker\r\n"
 				   		+ "fudge packer\r\n"
 				   		+ "flange\r\n"
 				   		+ "Goddamn\r\n"
 				   		+ "God damn\r\n"
 				   		+ "hell\r\n"
 				   		+ "homo\r\n"
 				   		+ "jerk\r\n"
 				   		+ "jizz\r\n"
 				   		+ "knobend\r\n"
 				   		+ "knob end\r\n"
 				   		+ "labia\r\n"
 				   		+ "lmao\r\n"
 				   		+ "lmfao\r\n"
 				   		+ "muff\r\n"
 				   		+ "nigger\r\n"
 				   		+ "nigga\r\n"
 				   		+ "omg\r\n"
 				   		+ "penis\r\n"
 				   		+ "piss\r\n"
 				   		+ "poop\r\n"
 				   		+ "prick";
 				       try {
 				       FileWriter writer = new FileWriter("/PopbobHack/CensorWordsList.txt");
 				       writer.write(Content);
 				       writer.close(); 
 				       }catch(Exception e)  {}
 				       CensorNaughtyWords.SetListToTxt();
    	    }
    	    pattern = Pattern.compile(".BlockFinder add ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(17, var3.length());
    	    	BlockFinder.BlockFinderList[BlockFinder.BlockFinderListLength] = var3;
    	    	BlockFinder.BlockFinderListLength +=1;
    	    	BlockFinder.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".BlockFinder del ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(17, var3.length());
    	    	try {
    	    	int hejsannoob = BlockFinder.FindLocationOfWord(var3);
    	    	if(hejsannoob < 1337) {
    	    	BlockFinder.onRemoveElement(hejsannoob);
    	    	BlockFinder.BlockFinderListLength -=1;
    	    	BlockFinder.onListUpdated();
    	    	}
    	    	}catch(Exception e) {
    	    		
    	    	}
    	    	try {
    	    		int hejsannoob = BlockFinder.FindLocationOfWord(Block.blocksList[Integer.parseInt(var3)].getLocalizedName());
        	    	if(hejsannoob < 1337) {
        	    	BlockFinder.onRemoveElement(hejsannoob);
        	    	BlockFinder.BlockFinderListLength -=1;
        	    	BlockFinder.onListUpdated();
        	    	}
    	    	}catch(Exception e) {
    	    		int hejsannoob = BlockFinder.FindLocationOfWord(String.valueOf(NameToId.NameToIdFunc(var3)));
        	    	if(hejsannoob < 1337) {
        	    	BlockFinder.onRemoveElement(hejsannoob);
        	    	BlockFinder.BlockFinderListLength -=1;
        	    	BlockFinder.onListUpdated();
        	    	}
    	    	}
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".BlockFinder print")) {
    	    	commandfound = true;
    	    	BlockFinder.BlockFinderListPrint();
    	    }
    	    
    	    pattern = Pattern.compile(".signdelay ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(11, var3.length());
    	    	GuiEditSign.delay = Integer.parseInt(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".LogOnSight add ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(16, var3.length());
    	    	LogOnSight.LOSList[LogOnSight.LOSListLength] = var3;
    	    	LogOnSight.LOSListLength +=1;
    	    	LogOnSight.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".LogOnSight del ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(16, var3.length());
    	    	try {
    	    	int hejsannoob = LogOnSight.FindLocationOfWord(var3);
    	    	if(hejsannoob < 1337) {
    	    	LogOnSight.onRemoveElement(hejsannoob);
    	    	LogOnSight.LOSListLength -=1;
    	    	LogOnSight.onListUpdated();
    	    	}
    	    	}catch(Exception e) {
    	    		
    	    	}
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".LogOnSight print")) {
    	    	commandfound = true;
    	    	LogOnSight.LOSListPrint();
    	    }
    	    
    	    pattern = Pattern.compile(".Bind ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(6, var3.length());
    	    	String var4 = var3.substring(0,var3.indexOf(" "));
    	    	int Modulepos = 69;
    	    	for(int i = 0; i < PopbobHack.getModules().size(); i++) {
    	    		if(PopbobHack.getModules().get(i).getName().equalsIgnoreCase(var4)) {
    	    			Modulepos = i;
    	    			break;
    	    		}
    	    	}
    	    	var3 = var3.substring(var3.indexOf(" ") + 1);
    	    	if(Modulepos != 69) {
    	    	KeyBinds.KeyBindsList[Modulepos+1] = PopbobHack.getModules().get(Modulepos).getName() + ":"  + var3;
    	    	} else {
    	    	String penis = "cockcockcockcockcockcockcockcockcockcockcockcockcockcockcockcockpenis";
    	    	penis = penis.substring(420, 1337);
    	    	}
    	    	KeyBinds.onListUpdated();
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".Binds print")) {
    	    	commandfound = true;
    	    	KeyBinds.KeyBindsListPrint();
    	    }
    	    
    	    
    	    
    	    
    	    if(var3.equalsIgnoreCase(".round")) {
    	    	commandfound = true;
    	    	Minecraft.getMinecraft().thePlayer.rotationYaw = (float) (Math.floor(Minecraft.getMinecraft().thePlayer.rotationYaw/10) * 10);
    	    }
    	    
    	    pattern = Pattern.compile(".bookspam pages ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(16, var3.length());
    	    	pagesSpam = Integer.parseInt(var3);
    	    }
    	    
    	    pattern = Pattern.compile(".bookspam true ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(15, var3.length());
    	    	while(Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").tagCount() > 0) {
    	    		Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").removeTag(0);
    	    	}
    	    	int bookTotalPages = 0;
    	    			//Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").tagCount();
    	    	for(int i = 0; i < pagesSpam; i++) {
    	    	Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").appendTag(new NBTTagString("" + (bookTotalPages + 1), var3));
    	    	bookTotalPages++;
    	    	}
    	    }
    	    
    	    pattern = Pattern.compile(".bookspam false ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    
        	    if(matchFound) {
        	    	commandfound = true;
        	    	var3 = var3.substring(15, var3.length());
        	    	String var4 = var3;
        	    	int length = 256;
        	    	for(int i = 0; i < length; i+=var3.length()) {
        	    		var4 += var3;
        	    	}
        	    	var3 = var4.substring(1,(int) (Math.floor(length/var3.length()) * var3.length()));
        	    	while(Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").tagCount() > 0) {
        	    		Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").removeTag(0);
        	    	}
        	    	int bookTotalPages = 0;
        	    			//Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").tagCount();
        	    	for(int i = 0; i < pagesSpam; i++) {
        	    	Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").appendTag(new NBTTagString("" + (bookTotalPages + 1), var3));
        	    	bookTotalPages++;
        	    	}
        	    }
    	    
    	    
			if(var3.equalsIgnoreCase(".book copy")) {
    	    	commandfound = true;
    	    	bookPagesCopy = (NBTTagList) GuiScreenBook.bookPagesCopy.copy();
    	    	//System.out.println(bookPagesCopy);
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".book paste")) {
    	    	commandfound = true;
    	    	while(Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").tagCount() > 0) {
    	    		Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").removeTag(0);
    	    	}
    	    	for(int i = 0; i < bookPagesCopy.tagCount(); i++) {
    	    		Minecraft.getMinecraft().thePlayer.getHeldItem().getTagCompound().getTagList("pages").appendTag(bookPagesCopy.tagAt(i));
    	    	}
    	    }
    	    
    	    pattern = Pattern.compile(".BookBot ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(9, var3.length());
    	    	//System.out.println(var3);
    	    	BookBot.Run(var3);
    	    }
    	   
    	    pattern = Pattern.compile(".AutoDisconnect ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(16, var3.length());
    	    	//System.out.println(var3);
    	    	AutoDisconnect.disconnecthealth = Integer.parseInt(var3);
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    
    	    
    	    pattern = Pattern.compile(".AutoWhisper ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(13, var3.length());
    	    	AutoWhisper.player = var3;
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".DisconnectNoFall ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(18, var3.length());
    	    	DisconnectFall.falldistancedisconnect = Integer.parseInt(var3);
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    pattern = Pattern.compile(".SignBot ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(9, var3.length());
    	    	SignBot.file2 = var3;
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".Bookclear")) {
    	    	commandfound = true;
    	    	BookBot.i3 = 0;
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".Signclear")) {
    	    	commandfound = true;
    	    	BookBot.i3 = 0;
    	    	RandomShit.onListUpdated();
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".help")) {
    	    	commandfound = true;
    	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> do .modules to get a list of modules.");
    	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> do .commands to get a list of commands.");
    	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> do .help CommandName/moduleName to get help about a specific command/module");
    	    }
    	    if(var3.equalsIgnoreCase(".Modules")) {
    	    	commandfound = true;
    	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> AntiFall, AutoArmor, AutoEat, AutoMine, AutoR, AutoSwim, AutoWalk, AutoWhisper, BlockFinder, CensorWords, ChestFinder, CustomBook, FastPlace, Fly, Freecam, FullBright, GamerFov, Glide, Jesus, KillAura, LogOnSight, LongMessages, Macro, NoClip, NoFall, Recording, SafeWalk, Scaffold, Spam, Sprint, SuperJesus, Teleport, Tracers, Xray");
    	    }
    	    
    	    if(var3.equalsIgnoreCase(".commands")) {
    	    	commandfound = true;
    	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> AutoReconnect, BookBot, Book copy, Book paste, Bookspam, Bind, Goto, Math, Steal, Vclip");
    	    }
    	    
    	    
	    	
    	    
    	    pattern = Pattern.compile(".help ", Pattern.CASE_INSENSITIVE);
    	    matcher = pattern.matcher(var3);
    	    matchFound = matcher.find();
    	    if(matchFound) {
    	    	commandfound = true;
    	    	var3 = var3.substring(6, var3.length());
    	    	boolean foundhelp = false;
    	    	for(int i = 0; i < PopbobHack.mods.size(); i++) {
    	    		String str10 = PopbobHack.getModules().get(i).getName();
    	    		if(var3.equalsIgnoreCase(str10)) {
    	    			foundhelp = true;
    	    			Minecraft.getMinecraft().thePlayer.addChatMessage(CommandHelp.commandHelp.get(i));
    	    		}
    	    			
    	    	}
    	    	
    	    	
    	    	
    	    	if(var3.equalsIgnoreCase("BookBot")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> Syntax is .BookBot fileName. Converts a txt file into a minecraft book. If the txt file is longer than 50 minecraft pages it converts the rest of the txt file if you run the command again. If you do .BookClear it sets the contents it's converting to the original file.");
    	    	}
    	    	
    	    	if(var3.equalsIgnoreCase("Book copy")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> copies the contents of the book you're holding. To paste it do .Book paste");
    	    	}
    	    	
    	    	if(var3.equalsIgnoreCase("Book paste")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> pastes the contents of book copied using .book copy");
    	    	}
    	    	
    	    	if(var3.equalsIgnoreCase("Bookspam")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> fills a book with spam. Syntax is .Bookspam String Boolean. The string is what the book gets spammed with. boolean = false makes so it spams the string multiple times on the page otherwise it only writes it once.");
    	    	}
    	    	
    	    	if(var3.equalsIgnoreCase("Bind")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> .bind moduleName key I hope you understand :)");
    	    	}
    	    	
    	    	if(var3.equalsIgnoreCase("goto")) {
        	    	foundhelp = true;
        	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> .goto x z is the syntax. This isn't fucking baritone it just calculates the optimal yaw to walk towards though I hate arctan so the angle is often off by 180 degress so do .goto add 180 if its wrong you nerd.");
        	    }
    	    	
    	    	if(var3.equalsIgnoreCase("steal")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> syntax = .steal infMode boolean. Boolean should be true if you want to steal infs. Can only steal 9 infs at the time.");
    	    	}
    	    	
    	    	if(var3.equalsIgnoreCase("math")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> the syntax is .math mathThings. It only supports +, -, / and *. You can also use .calc which does the same thing.");
    	    	}
    	    	
    	    	if(var3.equalsIgnoreCase("vclip")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> vclip = vertical clip. NCP patches this so I don't see why you care. I hope you understand this and stop caring.");
    	    	}
    	    	
    	    	if(var3.equalsIgnoreCase("AutoReconnect")) {
    	    		foundhelp = true;
    	    		Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> syntax is .Autoreconnect delay NUMBER");
    	    	}
    	    	
    	    	if(!foundhelp) {
    	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> " + var3 + " is not a command or module retard");
    	    	}
    	    	
    	    }
    	    var3 = var3.substring(1);
    	    if(!commandfound) {
    	    	Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> " + var3 + " is not a command or module retard do .help because your clearly clueless");
    	    }
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
		}catch(Exception e) {
			e.printStackTrace();
			Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> thats not how you do syntax try again");
		}
	} else {
		if(PopbobHack.getModules().get(35).isToggled()) {
			var3 = "/r " + var3;
		}else if(PopbobHack.getModules().get(37).isToggled()) {
			var3 = "/w " + AutoWhisper.player + " " + var3;
		}
		if(!Minecraft.getMinecraft().getSession().getUsername().equals(PopbobHack.ShadowBan) || var3.startsWith("/")) {
		Minecraft.getMinecraft().thePlayer.sendChatMessage(var3);
		}else {
			Minecraft.getMinecraft().thePlayer.addChatMessage("<" + PopbobHack.ShadowBan + "> " + var3);
		}
	}
	}
}