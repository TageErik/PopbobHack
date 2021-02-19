package popbobhack.utils;

import net.minecraft.src.Minecraft;

public class NodeInfo {
	
	private int time = 0;
	private double f_cost;
	private NodeInfo Parent;
	private float Yaw;
	private float Pitch;
	private double posX;
	private double posY;
	private double posZ;
	private double lastposX;
	private double lastposZ;
	public float getYaw() {
		return Yaw;
	}
	public void setYaw(float yaw) {
		Yaw = yaw;
	}
	public float getPitch() {
		return Pitch;
	}
	public void setPitch(float pitch) {
		Pitch = pitch;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosZ() {
		return posZ;
	}
	public void setPosZ(double posZ) {
		this.posZ = posZ;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public double getLastposX() {
		return lastposX;
	}
	public void setLastposX(double lastposX) {
		this.lastposX = lastposX;
	}
	public NodeInfo getParent() {
		return Parent;
	}
	public void setParent(NodeInfo parent) {
		Parent = parent;
	}
	public double getLastposZ() {
		return lastposZ;
	}
	public void setLastposZ(double lastposZ) {
		this.lastposZ = lastposZ;
	}
	public double getF_cost() {
		return f_cost;
	}
	public void setF_cost(double f_cost) {
		this.f_cost = f_cost;
	}
		
}
