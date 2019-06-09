package com.arthur.breakoutudemy.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.arthur.breakoutudemy.framework.*;
import com.arthur.breakoutudemy.window.Handler;

public class Paddle extends GameObject{

	
	private int width = 62, height = 10;
	Handler handler;
	
	public Paddle(float x, float y, Handler handler, ObjectID id) {
		super(x, y, id);
		this.handler = handler;

	}

	
	public void move() {
		
		if (handler.getState() == State.paused) {
			//velX and velY could be set to 0, 
			//but they may have to be redefined as per previous values
		}
		else {
			
			//handler will move if state is alive or dead
			
			x +=velX;
			
			//determine if the paddle reaches the left or right bounds
			if (x < 0) {
				velX = 0;
				x = 0;
			}else if (x > 740) { //800 - this.width + boardSpace
				velX = 0;
				x = 740; //800 - this.width + boardSpace
			}
		}
	}

	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, width, height);
		
		/*collision visual
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.blue);
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());*/
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, width, height);
	}

	
	public Rectangle getBoundsTop() {
		
		return new Rectangle((int) ((int) x + (width/2) - ((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}

	
	public Rectangle getBoundsBottom() {
		
		return null;
	}

	
	public Rectangle getBoundsLeft() {
		
		return new Rectangle((int)x, (int)y, (int)15, (int)height);
	}

	
	public Rectangle getBoundsRight() {
		
		return new Rectangle((int) ((int) x + width - 15), (int)y, (int)15, (int)height);
	}

}
