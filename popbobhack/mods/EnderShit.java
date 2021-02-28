package popbobhack.mods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityEnderPearl;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;
import popbobhack.main.Category;

public class EnderShit extends Module{

	public EnderShit() {
		super("EnderShit", 0, Category.MOVEMENT);
		
	}
	protected Random rand;
	private double lastTickPosX;
	private double lastTickPosY;
	private double lastTickPosZ;
	private int throwableShake;
	public static double posX;
	public static double posY;
	public static double posZ;
	public static float rotationYaw;
	public static float rotationPitch;
	public static double motionX;
	public static double motionY;
	public static double motionZ;
	public static float prevRotationYaw;
	public static float prevRotationPitch;
	public static float ticksInGround;
	public World worldObj;
	public Entity entity;
	private int ticksInAir;
	private boolean inGround;
	public AxisAlignedBB boundingBox;
	private int inTile;
	private int xTile;
	private int yTile;
	private int zTile;
	private boolean inWater;
	private float width;
	private float height;
	private boolean isDead;
	private float yOffset;
	private float ySize;
	private int timetaken;
	private double distance;
	private double velocity;
	private float yawPearl;
	private float pitchPearl;
	private double BestVelocity;
	private float BestPitch;
	private boolean enderpress;
	private int timeOfBest;
	private float timerBetweenPearlThrows;
	private double lastposX;
	private double lastposY;
	private double lastposZ;
	private double bestposX;
	private double bestposY;
	private double bestposZ;
	
	public static int Destinationx = 0;
	public static int Destinationz = 0;
	boolean followPath = false;
	int iteratorshit = 0;
	public static float timerAdd = 1;
	public static int pathLength = 10;
	
	
	public void onUpdate() {
		if(isToggled()) {
			/*if(followPath) {
				mc.gameSettings.keyBindUseItem.pressed = false;
				timerBetweenPearlThrows+=timerAdd;
				if(timerBetweenPearlThrows > Path.get(iteratorshit).getTime()) {
				mc.thePlayer.rotationYaw = Path.get(iteratorshit).getYaw();
				mc.thePlayer.rotationPitch = Path.get(iteratorshit).getPitch();
				mc.gameSettings.keyBindUseItem.pressed = true;
				timerBetweenPearlThrows = 0;
				iteratorshit++;
				}
				if(iteratorshit >= Path.size()) {
					mc.gameSettings.keyBindUseItem.pressed = false;
					followPath = false;
				}
				
			}*/
			timerBetweenPearlThrows++;
			mc.gameSettings.keyBindUseItem.pressed = false;
			yawPearl = mc.thePlayer.rotationYaw;
			lastposX = mc.thePlayer.posX;
			lastposY = mc.thePlayer.posY;
			lastposZ = mc.thePlayer.posZ;
			if(timerBetweenPearlThrows > timeOfBest) {
			mc.gameSettings.keyBindUseItem.pressed = true;
			FindBestPitch();
			mc.thePlayer.rotationPitch = BestPitch;
			}
		}
	}
	
	public void onDisable() {
		mc.gameSettings.keyBindUseItem.pressed = false;
	}
	
	public void onEnable() {
		if(isToggled()) {
			timeOfBest = 0;

		/*posX = mc.thePlayer.posX;
		posY = mc.thePlayer.posY;
		posZ = mc.thePlayer.posZ;
		
		
		NodeInfo NodeInfo = new NodeInfo();
		NodeInfo.setPosX(mc.thePlayer.posX);
		NodeInfo.setPosY(mc.thePlayer.posY);
		NodeInfo.setPosZ(mc.thePlayer.posZ);
		NodeInfo.setLastposX(mc.thePlayer.posX);
		NodeInfo.setLastposZ(mc.thePlayer.posZ);
		NodeInfo.setF_cost(49507439);
		Open.clear();
		Open.add(NodeInfo);
		
		//finds the best node
		for(int popbob = 0; popbob < pathLength; popbob++) {
		double lowestf_cost = Math.pow(10, 10);
		NodeInfo nodewithlowestf_cost = null;
		for(int i = 0; i < Open.size(); i++) {
			if(Open.get(i).getF_cost() < lowestf_cost) {
				lowestf_cost = Open.get(i).getF_cost();
				nodewithlowestf_cost = Open.get(i);
			}
		}
		
		
		current = nodewithlowestf_cost;
		mc.getLogAgent().logInfo(String.valueOf(current.getF_cost()));
		for(int i = 0; i < Open.size(); i++) {
		}
		Open.remove(current);
		Closed.add(current);
		
		//todo : if(pos approxiamtely equal to desination)
		//return
		if(Math.abs(posX-Destinationx) < 2 && Math.abs(posZ-Destinationz) < 2) {
			
		}
		
		//check if neighbor is in closed done!
		for(int i2 = -180; i2 < 180; i2+=10) {
		for(int i = 0; i < Closed.size(); i++) {
			if(Closed.get(i).getYaw() == yawPearl && Closed.get(i).getPitch() == pitchPearl && Closed.get(i).getPosX() == lastposX && Closed.get(i).getPosZ() == lastposZ) {
				i2+=10;
			}
		}
		//System.out.println(i2);
		
		//check if launch rotation and pos exists
		boolean isinOpen = false;
		NodeInfo Opengeti = null;
		for(int i = 0; i < Open.size(); i++) {
			if(Open.get(i).getYaw() == yawPearl && Open.get(i).getPitch() == pitchPearl && Open.get(i).getPosX() == lastposX && Open.get(i).getPosZ() == lastposZ) {
				isinOpen = true;
				Opengeti = Open.get(i);
			}
		}
		if(isinOpen == false) {
			//System.out.println("hejsan");
			yawPearl = i2;
			lastposX = current.getPosX();
			lastposY = current.getPosY();
			lastposZ = current.getPosZ();
			//System.out.println(current.getPosX());
			//System.out.println(current.getPosY());
			//System.out.println(current.getPosZ());
		    //System.out.println(posY);
			FindBestPitch();
			NodeInfo NewNode = new NodeInfo();
			//System.out.println(NodeInfo);
			NewNode.setPosX(bestposX);
			NewNode.setPosY(Math.round(bestposY*100)/100 + 2.62);
			NewNode.setPosZ(bestposZ);
			NewNode.setYaw(yawPearl);
			NewNode.setPitch(BestPitch);
			NewNode.setParent(current);
			NewNode.setTime(timeOfBest + NewNode.getParent().getTime());
			//System.out.println(NewNode.getParent());
			NewNode.setLastposX(NewNode.getParent().getPosX());
			NewNode.setLastposZ(NewNode.getParent().getPosZ());
			NewNode.setF_cost(1/(Math.abs((Math.sqrt(Math.pow(mc.thePlayer.posX-Destinationx,2) + Math.pow(mc.thePlayer.posZ-Destinationz,2)) - Math.sqrt(Math.pow(NewNode.getPosX()-Destinationx,2) + Math.pow(NewNode.getPosZ()-Destinationz,2)))/NewNode.getTime())));
			//todo : if neighbor is not in OPEN
			Open.add(NewNode);
		} else {
			//System.out.println("hejsan");
			yawPearl = i2;
			lastposX = current.getPosX();
			lastposY = current.getPosY();
			lastposZ = current.getPosZ();
			FindBestPitch();
			NodeInfo NewNode = new NodeInfo();
			//System.out.println("hejsan");
			NewNode.setParent(current);
			NewNode.setTime(timeOfBest + NewNode.getParent().getTime());
			if(Opengeti.getTime() + Opengeti.getParent().getTime() < NewNode.getTime() + NewNode.getParent().getTime()) {
				Opengeti.setPosX(bestposX);
				Opengeti.setPosY(Math.round(bestposY*100)/100 + 2.62);
				Opengeti.setPosZ(bestposZ);
				Opengeti.setYaw(yawPearl);
				Opengeti.setPitch(BestPitch);
				Opengeti.setParent(current);
				Opengeti.setTime(timeOfBest + Opengeti.getParent().getTime());
				Opengeti.setLastposX(Opengeti.getParent().getPosX());
				Opengeti.setLastposZ(Opengeti.getParent().getPosZ());
				NewNode.setF_cost(1/(Math.abs((Math.sqrt(Math.pow(mc.thePlayer.posX-Destinationx,2) + Math.pow(mc.thePlayer.posZ-Destinationz,2)) - Math.sqrt(Math.pow(Opengeti.getPosX()-Destinationx,2) + Math.pow(Opengeti.getPosZ()-Destinationz,2)))/NewNode.getTime())));	
			}
		}
		
		
		}
		}
		//mc.getLogAgent().logInfo(String.valueOf(current.getPosX() + " " + current.getPosY() + " " + current.getPosZ()));
		//System.out.println(String.valueOf(current.getPosX() + " " + current.getPosY() + " " + current.getPosZ()));
		//System.out.println(String.valueOf(current.getF_cost()));
		//System.out.println(String.valueOf(current.getTime() + current.getParent().getTime()));
		while(current.getParent() != null) {
			Path.add(current);
			current = current.getParent();
		}
		Open.clear();
		Closed.clear();
		timerBetweenPearlThrows = 0;
		iteratorshit = 0;
		followPath = true;
		*/
		}
	}
	
public void FindBestPitch() {
	BestVelocity = 0;
	for(int i = -90; i <= 90; i++) {
	pitchPearl = i;
	SendEnderPearl(yawPearl, pitchPearl);
	if(velocity >= BestVelocity) {
		BestVelocity = velocity;
		BestPitch = pitchPearl;
		timeOfBest = timetaken;
		bestposX = posX;
		bestposY = posY;
		bestposZ = posZ;
	}
	}
}
	
public void SendEnderPearl(float yaw, float pitch) {
	FakeEnderPearl(yaw, pitch);
	//mc.thePlayer.addChatMessage("x : " + String.valueOf(posX) + " y : " + String.valueOf(posY) + " z : " + String.valueOf(posZ));
	distance = Math.abs(mc.thePlayer.posX - posX) + Math.abs(mc.thePlayer.posZ - posZ);	
	velocity = distance/(double)timetaken;
	//mc.thePlayer.addChatMessage(String.valueOf(velocity));
}
	
public void FakeEnderPearl(float yaw, float pitch) {
	this.boundingBox = AxisAlignedBB.getBoundingBox(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	this.rand = new Random();
	this.worldObj = mc.theWorld;
	posX = lastposX;
	posY = lastposY + (double)mc.thePlayer.getEyeHeight();
	posZ = lastposZ;
	this.yOffset = 0.0F;
	this.ySize = 0.0F;
	this.width = 0.25F;
    this.height = 0.25F;
	rotationYaw = yaw;
	rotationPitch = pitch;
	posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
    posY -= 0.10000000149011612D;
    posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
    //System.out.println(posY);
    float yOffset = 0.0F;
    float var3 = 0.4F;
    motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * var3);
    motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * var3);
    motionY = (double)(-MathHelper.sin((this.rotationPitch + 0) / 180.0F * (float)Math.PI) * var3);
    
    float var9 = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
    motionX /= (double)var9;
    motionY /= (double)var9;
    motionZ /= (double)var9;
    /*motionX += this.rand.nextGaussian() * 0.007499999832361937D * (double)1.0F;
    motionY += this.rand.nextGaussian() * 0.007499999832361937D * (double)1.0F;
    motionZ += this.rand.nextGaussian() * 0.007499999832361937D * (double)1.0F;*/
    motionX *= (double)1.5F;
    motionY *= (double)1.5F;
    motionZ *= (double)1.5F;
    /*this.motionX = motionX;
    this.motionY = motionY;
    this.motionZ = motionZ;*/
    float var10 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
    this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
    this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(motionY, (double)var10) * 180.0D / Math.PI);
    this.ticksInGround = 0;
    isDead = false;
    EpicShitUpdate();
}
	
	


public void EpicShitUpdate() {
	timetaken = 0;
	//System.out.println("epic");
	while(isDead == false) {
	timetaken++;
	this.lastTickPosX = this.posX;
    this.lastTickPosY = this.posY;
    this.lastTickPosZ = this.posZ;
    super.onUpdate();

    if (this.throwableShake > 0)
    {
        --this.throwableShake;
    }

    if (this.inGround)
    {
        int var1 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);

        if (var1 == this.inTile)
        {
            ++this.ticksInGround;

            if (this.ticksInGround == 1200)
            {
                this.setDead();
            }

            return;
        }

        this.inGround = false;
        this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
        this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
        this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
        this.ticksInGround = 0;
        this.ticksInAir = 0;
    }
    else
    {
        ++this.ticksInAir;
    }

    Vec3 var16 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
    Vec3 var2 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
    MovingObjectPosition var3 = this.worldObj.clip(var16, var2);
    var16 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
    var2 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
    if (var3 != null)
    {
        var2 = this.worldObj.getWorldVec3Pool().getVecFromPool(var3.hitVec.xCoord, var3.hitVec.yCoord, var3.hitVec.zCoord);
    }

    if (!this.worldObj.isRemote)
    {
        Entity var4 = null;
        List var5 = this.worldObj.getEntitiesWithinAABBExcludingEntity(entity, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
        double var6 = 0.0D;
        EntityLivingBase var8 = this.getThrower();

        for (int var9 = 0; var9 < var5.size(); ++var9)
        {
            Entity var10 = (Entity)var5.get(var9);

            if (var10.canBeCollidedWith() && (var10 != var8 || this.ticksInAir >= 5))
            {
                float var11 = 0.3F;
                AxisAlignedBB var12 = var10.boundingBox.expand((double)var11, (double)var11, (double)var11);
                MovingObjectPosition var13 = var12.calculateIntercept(var16, var2);

                if (var13 != null)
                {
                    double var14 = var16.distanceTo(var13.hitVec);

                    if (var14 < var6 || var6 == 0.0D)
                    {
                        var4 = var10;
                        var6 = var14;
                    }
                }
            }
        }

        if (var4 != null)
        {
            var3 = new MovingObjectPosition(var4);
        }
    }

    if (var3 != null)
    {
        if (var3.typeOfHit == EnumMovingObjectType.TILE && this.worldObj.getBlockId(var3.blockX, var3.blockY, var3.blockZ) == Block.portal.blockID)
        {
            this.setInPortal();
        }
        else
        {
            this.onImpact(var3);
        }
    }


    this.posX += this.motionX;
    this.posY += this.motionY;
    this.posZ += this.motionZ;
    float var17 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
    this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

    for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)var17) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
    {
        ;
    }

    while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
    {
        this.prevRotationPitch += 360.0F;
    }

    while (this.rotationYaw - this.prevRotationYaw < -180.0F)
    {
        this.prevRotationYaw -= 360.0F;
    }

    while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
    {
        this.prevRotationYaw += 360.0F;
    }

    this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
    this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
    float var18 = 0.99F;
    float var19 = this.getGravityVelocity();

    if (this.isInWater())
    {
        for (int var7 = 0; var7 < 4; ++var7)
        {
            float var20 = 0.25F;
            //this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)var20, this.posY - this.motionY * (double)var20, this.posZ - this.motionZ * (double)var20, this.motionX, this.motionY, this.motionZ);
        }

        var18 = 0.8F;
    }

    this.motionX *= (double)var18;
    this.motionY *= (double)var18;
    this.motionZ *= (double)var18;
    this.motionY -= (double)var19;
    this.setPosition(this.posX, this.posY, this.posZ);
	}
    //mc.thePlayer.addChatMessage("x : " + String.valueOf(posX) + " y : " + String.valueOf(posY) + " z : " + String.valueOf(posZ));
}




private void setPosition(double posX2, double posY2, double posZ2) {
	this.posX = posX2;
    this.posY = posY2;
    this.posZ = posZ2;
    float var7 = this.width / 2.0F;
    float var8 = this.height;
    this.boundingBox.setBounds(posX2 - (double)var7, posY2 - (double)this.yOffset + (double)this.ySize, posZ2 - (double)var7, posX2 + (double)var7, posY2 - (double)this.yOffset + (double)this.ySize + (double)var8, posX2 + (double)var7);
	
}




private boolean isInWater() {
	if (this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.4000000059604645D, 0.0D).contract(0.001D, 0.001D, 0.001D), Material.water, entity))
    {
        if (!this.inWater)
        	//!this.firstUpdate
        {
            float var1 = MathHelper.sqrt_double(this.motionX * this.motionX * 0.20000000298023224D + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224D) * 0.2F;

            if (var1 > 1.0F)
            {
                var1 = 1.0F;
            }

            //this.playSound("liquid.splash", var1, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
            float var2 = (float)MathHelper.floor_double(this.boundingBox.minY);
            int var3;
            float var4;
            float var5;

            for (var3 = 0; (float)var3 < 1.0F + this.width * 20.0F; ++var3)
            {
                var4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
                var5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
                this.worldObj.spawnParticle("bubble", this.posX + (double)var4, (double)(var2 + 1.0F), this.posZ + (double)var5, this.motionX, this.motionY - (double)(this.rand.nextFloat() * 0.2F), this.motionZ);
            }

            for (var3 = 0; (float)var3 < 1.0F + this.width * 20.0F; ++var3)
            {
                var4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
                var5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
                //this.worldObj.spawnParticle("splash", this.posX + (double)var4, (double)(var2 + 1.0F), this.posZ + (double)var5, this.motionX, this.motionY, this.motionZ);
            }
        }


        this.inWater = true;
    }
    else
    {
        this.inWater = false;
    }

    return this.inWater;
}




private float getGravityVelocity() {
	return 0.03F;
}




private void setInPortal() {
	// TODO Auto-generated method stub
	
}




private void onImpact(MovingObjectPosition var3) {
	setDead();
	
}




private EntityLivingBase getThrower() {
	return mc.thePlayer;
}




private void setDead() {
	isDead = true;	
}




 	
	
	
	
	
	
	
	
	
	
	
	
}