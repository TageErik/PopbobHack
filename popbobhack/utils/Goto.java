package popbobhack.utils;

import net.minecraft.src.Minecraft;

public class Goto {
public static void GotoLocation(int x, int z) {
	double x2 = x - Minecraft.getMinecraft().thePlayer.posX;
	double z2 = z - Minecraft.getMinecraft().thePlayer.posZ;
	float rotation = (float) Math.toDegrees(Math.atan2(z2,x2))-90;
	Minecraft.getMinecraft().thePlayer.rotationYaw = rotation;
	Minecraft.getMinecraft().thePlayer.addChatMessage(String.valueOf(z));
}
}
