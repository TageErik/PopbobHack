package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import popbobhack.main.Category;
import popbobhack.main.PopbobHack;

public class NickName extends Module{

	public NickName() {
		super("NickName", 0, Category.RENDER);
		
	}
	   public void onDisable() {
		   PopbobHack.getModules().get(14).toggle();
	   }

}
