package com.arthur.breakoutudemy.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.arthur.breakoutudemy.framework.GameObject;
import com.arthur.breakoutudemy.framework.Level;
import com.arthur.breakoutudemy.framework.ObjectID;
import com.arthur.breakoutudemy.window.Handler;

public class Brick extends GameObject{
	
	private int width = 90, height = 15;
	Handler handler;
	
	public Brick(float x, float y, Handler handler, ObjectID id) {
		super(x, y, id);
		this.handler = handler;
	}

	
	public void move() {
		
		//collision with the ball
		Collision();
	}

	private void Collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ObjectID.Ball) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
				else if(getBoundsBottom().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
			}
		}
	}
	
	public void render(Graphics g) {
		if (handler.getLevel() == Level.level1) {
			g.setColor(Color.red);
		}
		else {
			g.setColor(Color.yellow);
		}
		
		g.fillRect((int)x, (int)y, width, height);
		
		/*collision visual
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.blue);
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsBottom());*/
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, width, height);
	}

	
	public Rectangle getBoundsTop() {
		
		return new Rectangle((int) x - 1, (int) y, (int) width, (int) height/2);
	}

	
	public Rectangle getBoundsBottom() {
		
		return new Rectangle((int) x - 1, (int)((int) y + (height/2)), (int) width, (int) height/2);
	}

	
	public Rectangle getBoundsLeft() {
		
		return null;
	}

	
	public Rectangle getBoundsRight() {
		
		return null;
	}

}
