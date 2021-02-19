package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.NBTTagList;
import popbobhack.main.Category;

public class AutoMine extends Module{

	public AutoMine() {
		super("AutoMine", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindAttack.pressed = true;
			super.onUpdate();
		}
	}
	   public void onDisable() {
		   mc.gameSettings.keyBindAttack.pressed = false;
		   super.onDisable();
	   }

}