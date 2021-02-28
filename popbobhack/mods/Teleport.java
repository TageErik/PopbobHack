package popbobhack.mods;



import org.lwjgl.input.Keyboard;

import popbobhack.main.Category;

public class Teleport extends Module{
	
	public static double telex = 0;
	public static double telez = 0;
	public Teleport() {
		super("Teleport", 0,Category.MOVEMENT);
	}
   public void onDisable() {
	   super.onDisable();
   }
	
	public void onUpdate() {
		if(this.isToggled()) {
			
			super.onUpdate();
		}
	}
}