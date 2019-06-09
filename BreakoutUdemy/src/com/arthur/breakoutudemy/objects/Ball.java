package com.arthur.breakoutudemy.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.arthur.breakoutudemy.framework.*;
import com.arthur.breakoutudemy.window.Handler;

public class Ball extends GameObject{

	private int width = 20, height = 20;
	private GameObject paddleTemp;
	Handler handler;
	
	public Ball(float x, float y, Handler handler, ObjectID id) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ObjectID.Paddle){
				paddleTemp = tempObject;
			}
		}
		
		velY = velX = Movement.STARTVEL.vel;
	}

	public void move() {
		
		if (handler.getState() == State.dead) {
			velX = paddleTemp.getVelX();
			x+=velX;
		}
		else if (handler.getState() == State.paused) {
			//handler state is paused
			//nothing will happen, ball will freeze
		}
		else if(handler.getState() == State.alive){
			
			if(handler.object.size() <=2) {
				resetBall(); //this should be in a resetLevel state or resetLevel function
			}
			else {
				// handler state is alive
				
				x +=velX;
				y +=velY;
				
				//collision against wall
				if (x <= 0) {
					velX = Movement.RUNVEL.vel;
				}else if(x >= 800 - width) {
					velX = -Movement.RUNVEL.vel;
				}
				if (y<= 0) {
					velY = Movement.RUNVEL.vel;
				}
				//collision against brick or paddle
				Collision();
				//falling below the paddle or board
				resetBall();
			}
		}
		

	}
	
	private void Collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ObjectID.Paddle) {
				
				if(getBounds().intersects(tempObject.getBoundsRight())) {
					velY = -Movement.RUNVEL.vel;
					velX = Movement.RUNVEL.vel;
				}
				else if(getBounds().intersects(tempObject.getBoundsLeft())) {
					velY = -Movement.RUNVEL.vel;
					velX = -Movement.RUNVEL.vel;
				}
				else if(getBounds().intersects(tempObject.getBoundsTop())) {
					velY = -Movement.RUNVEL.vel;
				}
			}
			else if(tempObject.getID() == ObjectID.Brick) {
				
				if(getBounds().intersects(tempObject.getBoundsBottom())) {
					velY = Movement.RUNVEL.vel;
				}
				else if(getBounds().intersects(tempObject.getBoundsTop())) {
					velY = -Movement.RUNVEL.vel;
				}
			}
		}
	}
	
	public void resetBall() {
		if (y > 600 || handler.object.size() <= 2) {
			
			handler.setState(State.dead);
			
			velX = 0;
			velY = 0;
			
			x = paddleTemp.getX() + width;
			y = paddleTemp.getY() - height;
		}
	}

	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillOval((int)x,  (int)y, width, height);
		
		/*collision visual
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.blue);
		g2d.draw(getBounds());*/
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, width, height);
	}

	public Rectangle getBoundsTop() {
		
		return null;
	}

	public Rectangle getBoundsBottom() {
		
		return null;
	}

	public Rectangle getBoundsLeft() {
		
		return null;
	}

	public Rectangle getBoundsRight() {
		
		return null;
	}

}
