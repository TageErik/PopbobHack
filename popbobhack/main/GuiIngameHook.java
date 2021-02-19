package popbobhack.main;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import java.util.ArrayList;

import net.minecraft.src.EntityThrowable;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.Minecraft;
import net.minecraft.src.ScaledResolution;
import popbobhack.mods.PlayerCoords;

public class GuiIngameHook extends GuiIngame{

	public GuiIngameHook(Minecraft par1Minecraft) {
		super(par1Minecraft);
		// TODO Auto-generated constructor stub
	}
	public static boolean playerCoordsWindowOpen = false;
    public void renderGameOverlay(float par1, boolean par2, int par3, int par4)
    {
    	super.renderGameOverlay(par1, par2, par3, par4);
        ScaledResolution var5 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
        FontRenderer var8 = this.mc.fontRenderer;
        this.mc.entityRenderer.setupOverlayRendering();
        GL11.glEnable(GL11.GL_BLEND);
        
        int count = 0;
        if(!mc.gameSettings.showDebugInfo) {
        for(popbobhack.mods.Module m: PopbobHack.getModules()) {
        	if(m.isToggled() && m.getName() != "NickName" && m.getName() != "PlayerCoords") {
        		mc.fontRenderer.drawString(m.getName(), 2, 2 + (count*10), 0x00ff00);
        		count++;
        	}
        }
        }
        if(!mc.gameSettings.showDebugInfo) {
       if(PopbobHack.getModules().get(20).isToggled()) {
    	   int count2 = 0;
    	   for(int i2 = 0; i2 < PlayerCoords.PlayerInfoString.size(); i2++) {
    	
    	 mc.fontRenderer.drawString(PlayerCoords.PlayerInfoString.get(i2), 200, 2 + (count2*10), 0x00ff00);
    	 count2++;
    	   }
    	   mc.fontRenderer.drawString(EntityThrowable.landingPosition, 200, 2 + (count2*10), 0x00ff00); 
    	   
       }
        }
    }
}
