package com.arthur.breakoutudemy.window;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
	
	private Dimension dimension;
	private static final int w = 800;
	private static final int h = 600;
	private static final String name = "BreakoutUdemy";
	
	public Window(int w, int h, String title, Board board) {
		this.dimension = new Dimension(w, h);
		board.setPreferredSize(dimension);
		board.setMaximumSize(dimension);
		board.setMinimumSize(dimension);
		
		JFrame frame = new JFrame(title);
		frame.add(board);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		board.start();
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		Window window = new Window(w, h, name, board);
	}
}
