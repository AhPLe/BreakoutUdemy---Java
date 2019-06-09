package com.arthur.breakoutudemy.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.arthur.breakoutudemy.window.Handler;

public class KeyInput extends KeyAdapter{
	
	//private static int paddleSpeed = Movement.PADDLEVEL.vel; //now unnecessary
	Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println("pressed"); //System.out.print("pressed" + String.valueOf(key));
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ObjectID.Paddle) {
				if(key == KeyEvent.VK_LEFT) {
					
					tempObject.setVelX(-Movement.PADDLEVEL.vel);
				}
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(Movement.PADDLEVEL.vel);
				}
			}
			else if(tempObject.getID() == ObjectID.Ball) {
				if(key == KeyEvent.VK_SPACE) {
					if (handler.getState() == State.dead) {
						handler.setState(State.alive);
						
						tempObject.setVelY(Movement.RUNVEL.vel);
						tempObject.setVelX(-Movement.RUNVEL.vel);
					}
					else {
						
					}
				}
			}
		}
		if(key == KeyEvent.VK_P) {
			if (handler.getState() == State.alive) {
				handler.setState(State.paused);
			}
			else if (handler.getState() == State.paused) {
				handler.setState(State.alive);
			}
		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println("released");
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ObjectID.Paddle) {
				if(key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
				}
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
				}
			}
		}		
	}
}
