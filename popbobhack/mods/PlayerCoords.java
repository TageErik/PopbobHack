package popbobhack.mods;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.src.GuiChest;
import net.minecraft.src.Minecraft;
import popbobhack.main.Category;
import popbobhack.main.PopbobHack;
import popbobhack.utils.CommandHelp;

public class PlayerCoords extends Module{

	public PlayerCoords() {
		super("PlayerCoords", Keyboard.KEY_Y, Category.PLAYER);
		
	}
	public static String PlayerInfo;
	public static String EpicPlayerInfo;
	public static String x;
	public static String y;
	public static String z;
	public static String PlayerName;
	public static String PlayerInfoStringIndex;
	public static ArrayList<String> PlayerInfoString = new ArrayList<String>();
	
	public void onUpdate() {
		if(isToggled()) {
			PlayerInfoString.clear();
			for(int i = 0; i < Minecraft.getMinecraft().theWorld.playerEntities.size(); i++) {
				PlayerInfo = Minecraft.getMinecraft().theWorld.playerEntities.get(i).toString();
				
				 
				 Pattern pattern = Pattern.compile("EntityClientPlayerMP", Pattern.CASE_INSENSITIVE);
				    Matcher matcher = pattern.matcher(PlayerInfo);
				    boolean matchFound = matcher.find();
				    if(matchFound) {
				    					    	EpicPlayerInfo = PlayerInfo.substring(PlayerInfo.substring(PlayerInfo.indexOf("'")+1).indexOf("'")+1+PlayerInfo.indexOf("'"));
				    	//EpicPlayerInfo = PlayerInfo.substring(PlayerInfo.substring(EpicPlayerInfo.indexOf("'")+1).indexOf("'")+1);
				    	//mc.thePlayer.addChatMessage(EpicPlayerInfo);
				    	x = EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('x')+2, EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('x')).indexOf(",") + EpicPlayerInfo.indexOf('x'));
						
						y = EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('y')+2, EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('y')).indexOf(",") + EpicPlayerInfo.indexOf('y'));
						try {
							y = String.valueOf(Integer.parseInt(y) - 1);
						}catch(Exception e) {}
						
						z = EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('z')+2, EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('z')).indexOf(",") + EpicPlayerInfo.indexOf('z'));
						
				    } else {
				    	try {
				EpicPlayerInfo = PlayerInfo.substring(PlayerInfo.substring(PlayerInfo.indexOf("'")+1).indexOf("'")+1 + PlayerInfo.indexOf("'"));
				//mc.getLogAgent().logInfo(EpicPlayerInfo);
				
				
				x = EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('x')+2, EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('x')).indexOf(".") + EpicPlayerInfo.indexOf('x'));
				
				
				y = EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('y')+2, EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('y')).indexOf(".") + EpicPlayerInfo.indexOf('y'));
				try {
					y = String.valueOf(Integer.parseInt(y) - 1);
				}catch(Exception e) {}
				
				z = EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('z')+2, EpicPlayerInfo.substring(EpicPlayerInfo.indexOf('z')).indexOf(".") + EpicPlayerInfo.indexOf('z'));
				    	} catch(Exception e69) {}
				    }
				    
			
				
				PlayerName = PlayerInfo.substring(PlayerInfo.indexOf("'") + 1, PlayerInfo.substring(PlayerInfo.indexOf("'")+1).indexOf("'") + PlayerInfo.indexOf("'") + 1);
				PlayerInfoStringIndex = PlayerCoords.PlayerName + " is at " + PlayerCoords.x + " " + PlayerCoords.y + " " + PlayerCoords.z;
				
				PlayerInfoString.add(i, PlayerInfoStringIndex);
			}
		}
	}

	
}
