package com.arthur.breakoutudemy.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import com.arthur.breakoutudemy.objects.*;
import com.arthur.breakoutudemy.framework.Menu;
import com.arthur.breakoutudemy.framework.MouseInput;

import javax.swing.JPanel;

import com.arthur.breakoutudemy.framework.GameObject;
import com.arthur.breakoutudemy.framework.KeyInput;
import com.arthur.breakoutudemy.framework.Level;
import com.arthur.breakoutudemy.framework.ObjectID;

public class Board extends JPanel implements Runnable{
	
	private boolean running = false;
	private Thread thread;
	public static int WIDTH, HEIGHT;
	Handler handler;
	Menu menu;
	
	public Board() {
		
	}
	
	private void init() {
		setFocusable(true);
		WIDTH = getWidth();
		HEIGHT = getHeight();
		handler = new Handler();
		handler.addObject(new Paddle(100, 570, handler, ObjectID.Paddle));
		handler.addObject(new Ball(120, 548, handler, ObjectID.Ball));
		handler.createLevel();
		
		menu = new Menu();
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler));
	}
	
	public synchronized void start() {
		if (running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start(); //starts thread to implement run method of game
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,  0,  getWidth(), getHeight());
		
		if (handler.getLevel() == Level.menu) {
			menu.render(g);
		}
		else {
		
			//this is the code to create our objects
			handler.render(g);
		}
		g.dispose();
	}
	
	public void run() {
		init();
		
		while(running) {
			//implement game in this loop
			//game loop
			
			move();
			
			repaint();

			try {
				thread.sleep(23);
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	private void move() {
		
		if (handler.getLevel() == Level.menu) {
			//do nothing
		}
		else {
			if (handler.object.size() <= 2 && handler.getLevel() == Level.level1) {
				//this should be in a resetLevel state or resetLevel function
				//this should also iterate over levels instead of continually calling each individually
				//whether in a hash map, level linked list, or other function
				handler.setLevel(Level.level2);
				
				for(int i = 0; i < handler.object.size(); i++) {
					GameObject tempObject = handler.object.get(i);
					
					if(tempObject.getID() == ObjectID.Ball) {
						Ball ball = (Ball)tempObject;
						ball.resetBall();
					}
				}
				
				handler.createLevel2();
			}
		handler.move();
		}
	}
}
