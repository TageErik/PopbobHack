package popbobhack.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityOtherPlayerMP;
import net.minecraft.src.Minecraft;
import popbobhack.main.Category;
import popbobhack.main.PopbobHack;

public class Freecam extends Module{

	public Freecam() {
		super("Freecam", 0, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}
	
	private EntityOtherPlayerMP fakePlayer = null;
	private double oldX;
	private double oldY;
	private double oldZ;
	
	public void onEnable()
	{
		mc.thePlayer.noClip = true;
		oldX = Minecraft.getMinecraft().thePlayer.posX;
		oldY = Minecraft.getMinecraft().thePlayer.posY;
		oldZ = Minecraft.getMinecraft().thePlayer.posZ;
		
		Minecraft.getMinecraft().thePlayer.noClip = true;
		
		EntityOtherPlayerMP fakePlayer = new EntityOtherPlayerMP(Minecraft.getMinecraft().theWorld, Minecraft.getMinecraft().thePlayer.getEntityName());
		fakePlayer.copyDataFrom(Minecraft.getMinecraft().thePlayer, true);
		fakePlayer.posY -= 1.62;
		fakePlayer.rotationYawHead = Minecraft.getMinecraft().thePlayer.rotationYawHead;
		Minecraft.getMinecraft().theWorld.addEntityToWorld(-69, fakePlayer);
	}
	
	public void onUpdate()
	{
		if(!this.isToggled())
			return;
		if(PopbobHack.getModules().get(0).isToggled()) {
		Minecraft.getMinecraft().thePlayer.noClip = true;
		mc.thePlayer.motionX = 0;
		mc.thePlayer.motionY = 0;
		mc.thePlayer.motionZ = 0;
		Minecraft.getMinecraft().thePlayer.capabilities.isFlying = false;
		Minecraft.getMinecraft().thePlayer.jumpMovementFactor = Fly.flyHackSpeed / 10;
		if(Minecraft.getMinecraft().gameSettings.keyBindJump.pressed)
		{
			Minecraft.getMinecraft().thePlayer.motionY += Fly.flyHackSpeed;
		}
		if(Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed)
		{
			Minecraft.getMinecraft().thePlayer.motionY -= Fly.flyHackSpeed;
		}
		} else {
		Minecraft.getMinecraft().thePlayer.noClip = false;
		}
	}
	
	public void onDisable()
	{
		Minecraft.getMinecraft().thePlayer.noClip = false;
		Minecraft.getMinecraft().thePlayer.setPositionAndRotation(oldX, oldY, oldZ, Minecraft.getMinecraft().thePlayer.rotationYaw, Minecraft.getMinecraft().thePlayer.rotationPitch);
		Minecraft.getMinecraft().theWorld.removeEntityFromWorld(-69);
		fakePlayer = null;
	}
}


