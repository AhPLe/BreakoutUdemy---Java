package com.arthur.breakoutudemy.framework;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x, y;
	protected float velX = 0, velY = 0;
	protected int boardSpace = 2;
	protected ObjectID id;
	
	public static void main() {
		
	}
	
	public GameObject(float x, float y, ObjectID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void move();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public abstract Rectangle getBoundsTop();
	public abstract Rectangle getBoundsBottom();
	public abstract Rectangle getBoundsLeft();
	public abstract Rectangle getBoundsRight();
	
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	public float getVelX() {
		return this.velX;
	}
	public float getVelY() {
		return this.velY;
	}
	
	public ObjectID getID() {
		return this.id;
	}
}
