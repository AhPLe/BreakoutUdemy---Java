package com.arthur.breakoutudemy.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.arthur.breakoutudemy.framework.GameObject;
import com.arthur.breakoutudemy.framework.ObjectID;
import com.arthur.breakoutudemy.framework.State;
import com.arthur.breakoutudemy.framework.Level;
import com.arthur.breakoutudemy.objects.*;

public class Handler {
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private GameObject tempObject;
	private State state;
	private Level level;
	
	public Handler() {
		state = State.dead;
		level = Level.menu;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}
	
	public void setLevel (Level level) {
		this.level = level;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void move() {
		for(int i = 0; i<object.size(); i++) {
			tempObject = object.get(i);
			tempObject.move();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void createLevel() {
		
		int xposStart = 50;
		int xpos = xposStart;
		final int  spacer = 100;
		int ypos = 100;
		
		for (int j = 0; j<3; j++) {
			xpos = xposStart;
			
			for (int x = 0; x<7; x++) {
				addObject(new Brick(xpos, ypos, this, ObjectID.Brick));
				xpos += spacer;
			}
			ypos +=20;
		}
		
	}
	
	public void createLevel2() {
		
		final int  spacerX = 100;
		final int spacerY = 20;
		int xposStart = 50;
		int yposStart = 100;
		int xpos = xposStart;
		int ypos = yposStart;
		
		
		for (int x = 0; x < 7; x++) {
			addObject(new Brick(xpos, ypos, this, ObjectID.Brick));
			xpos += spacerX;
		}
		
		xpos = xposStart;
		ypos = yposStart + spacerY;

		for (int x = 0; x < 10; x++) {
			addObject(new Brick(xpos, ypos, this, ObjectID.Brick));
			ypos += spacerY;
		}
		
		xpos = xposStart + 600;
		ypos = yposStart + spacerY;

		for (int x = 0; x < 10; x++) {
			addObject(new Brick(xpos, ypos, this, ObjectID.Brick));
			ypos += spacerY;
		}
		
		xpos = xposStart;
		ypos = 300;
		
		for (int x = 0; x < 7; x++) {
			addObject(new Brick(xpos, ypos, this, ObjectID.Brick));
			xpos += spacerX;
		}
		
		xpos = 200;
		ypos = yposStart + 2*spacerY;
		
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 5; y++) {
				addObject(new Brick(xpos, ypos, this, ObjectID.Brick));
				ypos += spacerY;
			}
			ypos = yposStart + 2*spacerY;
			xpos += 150;
		}
		
	}
}
