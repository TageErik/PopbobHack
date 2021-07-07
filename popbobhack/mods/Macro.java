package popbobhack.mods;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import popbobhack.main.Category;
import popbobhack.utils.MoveItem;

public class Macro extends Module{

	public Macro() {
		super("Macro", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	public static String MacroName;
	public static int ticks = 0;
	public static boolean cutNothing = false;
	private String keys;
	private boolean forward;
	private float yaw;
	private float pitch;
	private boolean left;
	private boolean right;
	private boolean backward;
	private int currentItem;
	private boolean jump;
	private boolean attack;
	private boolean useItem;
	private boolean sneak;
	private String ChatmsgSent;
	
	public static boolean first = true;
	public static boolean plusYawMode = false;
	public static boolean plusPitchMode = false;
	public static float startYaw = 0;
	public static float startPitch = 0;
	
	public void onUpdate() {
		if(isToggled()) {
			keys = Recording.RecordingList[ticks];
			forward = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			
			plusYawMode = keys.substring(0,keys.indexOf(":")).substring(0,1).equals("+");
			if(plusYawMode) {
				keys = keys.substring(1);
			}
			
			yaw = Float.parseFloat(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			
			plusPitchMode = keys.substring(0,keys.indexOf(":")).substring(0,1).equals("+");
			if(plusPitchMode) {
				keys = keys.substring(1);
			}
			
			pitch = Float.parseFloat(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			left = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			right = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			backward = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			if(!keys.substring(0,keys.indexOf(":")).equals("null")) {
				if(keys.substring(0,keys.indexOf(":")).substring(0,1).equals("#")) {
					keys = keys.substring(1);
					currentItem = Integer.parseInt(keys.substring(0,keys.indexOf(":")));
					MoveItem.MoveItemToHotbar(currentItem);
					currentItem = mc.thePlayer.inventory.currentItem;
				} else {
					currentItem = Integer.parseInt(keys.substring(0,keys.indexOf(":")));
				}
			} else {
				currentItem = 69;
			}
			keys = keys.substring(keys.indexOf(":") + 1);
			jump = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			attack = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			useItem = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			sneak = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			ChatmsgSent = keys;
			first = false;
			ticks++;
			first = true;
			//Recording.RecordingList[ticks] = String.valueOf(mc.gameSettings.keyBindForward + ":" + mc.thePlayer.rotationYaw + ":" + mc.thePlayer.rotationPitch + ":" + mc.gameSettings.keyBindLeft + ":" + mc.gameSettings.keyBindRight + ":" + mc.gameSettings.keyBindBack + ":" + mc.thePlayer.inventory.currentItem + ":" + mc.gameSettings.keyBindJump + ":" + mc.gameSettings.keyBindAttack + ":" + mc.gameSettings.keyBindUseItem + ":" + mc.gameSettings.keyBindSneak);
			mc.gameSettings.keyBindForward.pressed = forward;
			mc.gameSettings.keyBindBack.pressed = backward;
			mc.gameSettings.keyBindRight.pressed = right;
			mc.gameSettings.keyBindLeft.pressed = left;
			if(!plusYawMode) {
				mc.thePlayer.rotationYaw = 0;
			} else {
				mc.thePlayer.rotationPitch = startYaw;
			}
			
			if(!plusPitchMode) {
				mc.thePlayer.rotationPitch = 0;
			} else {
				mc.thePlayer.rotationPitch = startPitch;
			}
			
			mc.thePlayer.rotationYaw += yaw;
			mc.thePlayer.rotationPitch += pitch;
			if(currentItem != 69) {
				mc.thePlayer.inventory.currentItem = currentItem;
			}
			mc.gameSettings.keyBindJump.pressed = jump;
			mc.gameSettings.keyBindAttack.pressed = attack;
			mc.gameSettings.keyBindUseItem.pressed = useItem;
			mc.gameSettings.keyBindSneak.pressed = sneak;
			if(!ChatmsgSent.equalsIgnoreCase("null")) { 
				mc.thePlayer.sendChatMessage(ChatmsgSent);
			}
			if(ticks > Recording.RecordingListLength - 1) {
				toggle();
				mc.gameSettings.keyBindForward.pressed = false;
			}
		} else {
			ticks = 0;
		}
	}

}