package com.arthur.breakoutudemy.framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.arthur.breakoutudemy.window.Board;

public class Menu {
	
	private final int buttonEdgeX = Board.WIDTH/3 + 75;
	private final int buttonEdgeY = 150;
	private final int buttonWidth = 100;
	private final int buttonHeight = 50;
	private final int buttonSpace = 100;
	public Rectangle startButton = new Rectangle(buttonEdgeX, buttonEdgeY, buttonWidth, buttonHeight);
	public Rectangle quitButton = new Rectangle(buttonEdgeX, buttonEdgeY + buttonSpace, buttonWidth, buttonHeight);
	
	
	public void render(Graphics g) {
		
		Font font = new Font("arial", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Breakout!",  Board.WIDTH/3,  100);
		
		Graphics2D g2d = (Graphics2D) g;
		Font font2 = new Font("arial", Font.BOLD, 30);
		g.setFont(font2);
		
		final int stringHor = (int)(Board.WIDTH/3) + 97;
		final int stringVer = 185;
		final int stringVerSpace = 100;
		
		g.drawString("play",  stringHor, stringVer);
		g.drawString("quit",  stringHor, stringVer + stringVerSpace);
		
		g2d.draw(startButton);
		g2d.draw(quitButton);
		
	}
}
