package popbobhack.mods;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import popbobhack.main.Category;

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
	
	public static boolean first = true;
	
	public void onUpdate() {
		if(isToggled()) {
			while((ticks < Recording.RecordingListLength) && (first || (cutNothing && forward == mc.gameSettings.keyBindForward.pressed && backward == mc.gameSettings.keyBindBack.pressed && left == mc.gameSettings.keyBindLeft.pressed && right == mc.gameSettings.keyBindRight.pressed && sneak == mc.gameSettings.keyBindSneak.pressed && jump == mc.gameSettings.keyBindJump.pressed && attack == mc.gameSettings.keyBindAttack.pressed && yaw == mc.thePlayer.rotationYaw && pitch == mc.thePlayer.rotationPitch && useItem == mc.gameSettings.keyBindUseItem.pressed && currentItem == mc.thePlayer.inventory.currentItem && mc.gameSettings.keyBindAttack.pressed == false && mc.gameSettings.keyBindUseItem.pressed == false && mc.gameSettings.keyBindForward.pressed == false && mc.gameSettings.keyBindBack.pressed == false && mc.gameSettings.keyBindLeft.pressed == false && mc.gameSettings.keyBindRight.pressed == false))) {
			keys = Recording.RecordingList[ticks];
			forward = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			yaw = Float.parseFloat(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			pitch = Float.parseFloat(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			left = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			right = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			backward = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			currentItem = Integer.parseInt(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			jump = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			attack = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			useItem = Boolean.parseBoolean(keys.substring(0,keys.indexOf(":")));
			keys = keys.substring(keys.indexOf(":") + 1);
			sneak = Boolean.parseBoolean(keys);
			first = false;
			ticks++;
			}
			first = true;
			//Recording.RecordingList[ticks] = String.valueOf(mc.gameSettings.keyBindForward + ":" + mc.thePlayer.rotationYaw + ":" + mc.thePlayer.rotationPitch + ":" + mc.gameSettings.keyBindLeft + ":" + mc.gameSettings.keyBindRight + ":" + mc.gameSettings.keyBindBack + ":" + mc.thePlayer.inventory.currentItem + ":" + mc.gameSettings.keyBindJump + ":" + mc.gameSettings.keyBindAttack + ":" + mc.gameSettings.keyBindUseItem + ":" + mc.gameSettings.keyBindSneak);
			mc.gameSettings.keyBindForward.pressed = forward;
			mc.gameSettings.keyBindBack.pressed = backward;
			mc.gameSettings.keyBindRight.pressed = right;
			mc.gameSettings.keyBindLeft.pressed = left;
			mc.thePlayer.rotationYaw = yaw;
			mc.thePlayer.rotationPitch = pitch;
			mc.thePlayer.inventory.currentItem = currentItem;
			mc.gameSettings.keyBindJump.pressed = jump;
			mc.gameSettings.keyBindAttack.pressed = attack;
			mc.gameSettings.keyBindUseItem.pressed = useItem;
			mc.gameSettings.keyBindSneak.pressed = sneak;
			ticks++;
			if(ticks > Recording.RecordingListLength - 1) {
				toggle();
				mc.gameSettings.keyBindForward.pressed = false;
			}
		} else {
			ticks = 0;
		}
	}

}
