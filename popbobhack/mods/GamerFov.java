package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.EnumGameType;
import popbobhack.main.Category;

public class GamerFov extends Module{

	public GamerFov() {
		super("GamerFov", 0, Category.PLAYER);
		
	}
	   public void onDisable()  {
		   super.onDisable();
	   }
	
		public void onUpdate() {
			if(this.isToggled()) {
				mc.gameSettings.fovSetting = 3;
				super.onUpdate();
			}
		}
	}

