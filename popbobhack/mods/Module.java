package popbobhack.mods;

import net.minecraft.src.Minecraft;
import popbobhack.config.SaveSettings;
import popbobhack.main.Category;
import popbobhack.main.PopbobHack;

public class Module {

	protected Minecraft mc = Minecraft.getMinecraft();
	private String name; 
	private int key;
	public boolean toggled;
	private Category category;
	
	public Module(String nm, int k, Category c) {
		name = nm;
		key  = k;
		category = c;
		toggled = false;
	}

	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
			if(!PopbobHack.isFirstTime) {
			SaveSettings.SettingsList[SaveSettings.SettingsListLength] = getName();
	    	SaveSettings.SettingsListLength +=1;
	    	SaveSettings.onListUpdated();
			}
		} else {
			onDisable();
			if(!PopbobHack.isFirstTime) {
	    	try {
	    	int hejsannoob = SaveSettings.FindLocationOfWord(getName());
	    	if(hejsannoob < 1337) {
	    	SaveSettings.onRemoveElement(hejsannoob);
	    	SaveSettings.SettingsListLength -=1;
	    	SaveSettings.onListUpdated();
	    	}
	    	}catch(Exception e) {
	    		
	    	}
			}
		}
	}
	
	public void onEnable() {}
	public void onDisable() {}
	public void onUpdate() {}
	public void onRender() {}
	
	
	public Minecraft getMc() {
		return mc;
	}

	public void setMc(Minecraft mc) {
		this.mc = mc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}	
}
