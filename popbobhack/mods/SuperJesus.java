package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStationary;
import net.minecraft.src.Material;
import popbobhack.main.Category;

public class SuperJesus extends Module{

	public SuperJesus() {
		super("Super Jesus", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public int count = 0;
	public int count2 = 25;
	public boolean disabletoenable = false;
	public void onDisable() {
		count2 = 0;
		toggle();
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(count == 1) {
			mc.thePlayer.addChatMessage("JESUS ISNT REAL LOL!!!");
			}
			if(count2 == 25) {
			count++;
			} else {
				count2++;
				if(count2%5 == 0) {
					mc.thePlayer.addChatMessage("JESUS IS ALWAYS WITH YOU!!!");
				}
			}
			if(count > 5) {
				count = 0;
			}
		}
		}

}
