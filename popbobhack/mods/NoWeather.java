package popbobhack.mods;
import java.awt.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;

import net.minecraft.src.Minecraft;
import popbobhack.main.Category;

public class NoWeather extends Module{

	public NoWeather() {
		super("NoWeather", 0, Category.RENDER);
		
	}

}
