package popbobhack.mods;

import org.lwjgl.input.Keyboard;
import popbobhack.config.Config;
import popbobhack.config.KeyBinds;
import popbobhack.main.Category;
import popbobhack.main.PopbobHack;

public class Recording extends Module{

	public Recording() {
		super("Recording", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public static String RecordingName;
	public static String[] RecordingList = new String[50000];
	public static int RecordingListLength;
	public static String chatMessageBeingSent = "null";
	
	public static int ticks = 0;
	
	public static String keys = "";
	
	public static void SetListToTxt() {
		RecordingListLength = Config.SetListToTxt(RecordingList, RecordingListLength, "/PopbobHack/Recordings/" + RecordingName + ".txt");
	}
	
	public static void onListUpdated() {
		Config.onListUpdated(RecordingList, RecordingListLength, "/PopbobHack/Recordings/" + RecordingName + ".txt");
	}
	
	public static int FindLocationOfWord(String var3) {
		return Config.FindLocationOfWord(var3, RecordingList, RecordingListLength);
	}
	
	public static void onRemoveElement(int location) {
		Config.onRemoveElement(location, RecordingList, RecordingListLength);
	}
	
	
	public static void RecordingListPrint() {
		Config.ListPrint(RecordingList, RecordingListLength);
	}
	
	public static String ItemSlot = "0";
	public static boolean UseItemName = true;
	
	public void onUpdate() {
		if(isToggled()) {
			keys = "";
			if(!UseItemName) {
				ItemSlot = String.valueOf(mc.thePlayer.inventory.currentItem);
			}
	    	Recording.RecordingList[ticks] = String.valueOf(mc.gameSettings.keyBindForward.pressed + ":" + mc.thePlayer.rotationYaw + ":" + mc.thePlayer.rotationPitch + ":" + mc.gameSettings.keyBindLeft.pressed + ":" + mc.gameSettings.keyBindRight.pressed + ":" + mc.gameSettings.keyBindBack.pressed + ":" + ItemSlot + ":" + mc.gameSettings.keyBindJump.pressed + ":" + mc.gameSettings.keyBindAttack.pressed + ":" + mc.gameSettings.keyBindUseItem.pressed + ":" + mc.gameSettings.keyBindSneak.pressed + ":" + chatMessageBeingSent);
	    	chatMessageBeingSent = "null";
	    	Recording.RecordingListLength = ticks+1;
			ticks++;
			keys = "";
			if(PopbobHack.getModules().get(33).isToggled()) {
				toggle();
			}
		}
	}
	
	public void onDisable() {
		Recording.onListUpdated();
	}

}
