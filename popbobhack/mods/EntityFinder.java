package popbobhack.mods;

import popbobhack.config.Config;
import popbobhack.main.Category;

import java.util.ArrayList;

import net.minecraft.src.Entity;

public class EntityFinder extends Module{

	public EntityFinder() {
		super("EntityFinder", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	public static String[] EntityFinderList = new String[100];
	public static int EntityFinderListLength;
	public static ArrayList<Integer> EntityIDS = new ArrayList<Integer>();
	
	public void onUpdate() {
		if(isToggled()) {
			for(int i = 0; i < mc.theWorld.loadedEntityList.size(); i++) { 
				for(int i2 = 0; i2 < EntityFinderListLength; i2++) {
					if(((Entity)mc.theWorld.loadedEntityList.get(i)).getEntityName().equalsIgnoreCase(EntityFinderList[i2])) {
						if(!EntityIDS.contains(((Entity)mc.theWorld.loadedEntityList.get(i)).entityId)) { 
							mc.thePlayer.addChatMessage("<popbob> " + EntityFinderList[i2] + " found at " + ((Entity)mc.theWorld.loadedEntityList.get(i)).posX + " " + ((Entity)mc.theWorld.loadedEntityList.get(i)).posY + " " + ((Entity)mc.theWorld.loadedEntityList.get(i)).posZ);
							EntityIDS.add(((Entity)mc.theWorld.loadedEntityList.get(i)).entityId);
						}
					}
				}
			}
			for(int i = 0; i < EntityIDS.size(); i++) { 
				if(mc.theWorld.getEntityByID(EntityIDS.get(i)) == null) {
					EntityIDS.remove(i);
				}
			}
		}
	}
	
	public static void SetListToTxt() {
		EntityFinderListLength = Config.SetListToTxt(EntityFinderList, EntityFinderListLength, "/PopbobHack/FinderEntitys.txt");
	}
	
	
	
	public static void onListUpdated() {
		Config.onListUpdated(EntityFinderList, EntityFinderListLength, "/PopbobHack/FinderEntitys.txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, EntityFinderList, EntityFinderListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, EntityFinderList, EntityFinderListLength);
	}
	
	
	public static void EntityFinderListPrint() {
		Config.ListPrint(EntityFinderList, EntityFinderListLength);
	}

}
