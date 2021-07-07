package popbobhack.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.ChatMessageComponent;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.Minecraft;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.RenderGlobal;
import popbobhack.config.*;
import popbobhack.mods.*;
import popbobhack.mods.Module;
import popbobhack.utils.ChatCommands;
import popbobhack.utils.CommandHelp;
import popbobhack.utils.FoodItems;
import popbobhack.utils.XrayUtils;

public class PopbobHack {

	public static ArrayList<Module> mods;
	public static boolean isFirstTime = true;
	
	public PopbobHack() {
		mods = new ArrayList<Module>();
		XrayUtils.initXRayBlocks();
		CommandHelp.commandHelplist();
		FoodItems.FoodItemsADD();
		AddMod(new Fly());
		AddMod(new Teleport());
		AddMod(new FullBright());
		AddMod(new NoFall());
		AddMod(new Xray());
		AddMod(new Jesus());
		AddMod(new Sprint());
		AddMod(new GamerFov());
		AddMod(new SuperJesus());
		AddMod(new FastPlace());
		//10
		AddMod(new AutoMine());
		AddMod(new AutoWalk());
		AddMod(new AutoEat());
		AddMod(new Tracers());		
		AddMod(new NickName());
		AddMod(new ChestFinder());
		AddMod(new KillAura());
		AddMod(new Scaffold());
		AddMod(new Freecam());
		AddMod(new Spam());
		//20
		AddMod(new PlayerCoords());
		AddMod(new AutoArmor());
		AddMod(new SafeWalk());
		AddMod(new AutoSwim());
		AddMod(new Ascend());
		AddMod(new LongMessages());
		AddMod(new NoWeather());
		AddMod(new CustomBook());
		AddMod(new CensorNaughtyWords());
		AddMod(new Glide());
		//30
		AddMod(new EnderShit());
		AddMod(new LogOnSight());
		PopbobHack.getModules().get(14).toggled = true;
		AddMod(new Recording());
		AddMod(new Macro());
		AddMod(new SendCommands());
		AddMod(new AutoR());
		AddMod(new AntiFall());
		AddMod(new AutoWhisper());
		AddMod(new AutoDisconnect());
		AddMod(new NoClip());
		//40
		AddMod(new BlockFinder());
		AddMod(new NoHurtCam());
		AddMod(new Glide2());
		AddMod(new AntiKB());
		AddMod(new BucketMLG());
		AddMod(new DisconnectFall());
		AddMod(new SignBot());
		AddMod(new SoundLocator());
		AddMod(new AutoSign());
		AddMod(new EntityFinder());
		//50
		AddMod(new LeetH4xx0r());
		AddMod(new EnderShitter());
		AddMod(new PortalFinder());
		AddMod(new Hold());
		AddMod(new BuildMode());
		
		CustomBook.SetListToTxt();
		RandomShit.SetListToTxt();
		CensorNaughtyWords.SetListToTxt();
		BlockFinder.SetListToTxt();
		EntityFinder.SetListToTxt();
		Xray.SetListToTxt();
		LogOnSight.SetListToTxt();
		KeyBinds.SetListToTxt();
		SaveSettings.SetListToTxt();
		AutoSign.SetListToTxt();
		Waypoint.SetListToTxt();
		Shortcuts.SetListToTxt();
	}
	public static String ClientName = "PopbobHack 1.6.4 V1.3";
	public static String ShadowBan = "MinistroMinhoca";
	
	public static void AddMod(Module m) {
		mods.add(m);
	} 
	public static ArrayList<Module> getModules() {
		return mods;
	}

	public static void onUpdate() {
		for(Module m: mods) {
			m.onUpdate();
		}
	}
	public static void onRender() {
		for(Module m: mods) {
			m.onRender();
		}
		if(isFirstTime) {
		for(int i = 0; i < SaveSettings.SettingsListLength; i++) {
			for(int i2 = 0; i2 < PopbobHack.getModules().size(); i2++) {
				if(!PopbobHack.getModules().get(i2).getName().equals("Recording") && !PopbobHack.getModules().get(i2).getName().equals("Macro") && !PopbobHack.getModules().get(i2).getName().equals("EnderShit") && !PopbobHack.getModules().get(i2).getName().equals("AutoR") && !PopbobHack.getModules().get(i2).getName().equals("AutoWhisper") && !PopbobHack.getModules().get(i2).getName().equals("EnderShitter")) {
				if(PopbobHack.getModules().get(i2).getName().equals(SaveSettings.SettingsList[i])) {
					PopbobHack.getModules().get(i2).toggle();
				}
				}
			}
		}
		}
		isFirstTime = false;
	}
	
	public static void onKeyPressed(int k) {
		for(Module m: mods) {
			for(int i = 1; i < KeyBinds.KeyBindsListLength; i++) {
				if(m.getName().equalsIgnoreCase(KeyBinds.KeyBindsList[i].substring(0, KeyBinds.KeyBindsList[i].indexOf(":")))) {
					m.setKey(Keyboard.getKeyIndex((KeyBinds.KeyBindsList[i].substring(KeyBinds.KeyBindsList[i].indexOf(":") + 1)).toUpperCase()));
				}
			}
			if(m.getKey() == k) {
				m.toggle();
			}
		}
	}

	
	
}