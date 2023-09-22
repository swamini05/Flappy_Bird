package com.swamini.flappyunicorn.main;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	public Window(int width, int height, String title, Game game) {
		
		try {
			game.serverSocket = new ServerSocket(9999);
		} 
		catch (IOException e) {
			System.out.println("Game instance running!");
			System.exit(0);
		}
		
		setTitle(title);
		pack();
		setSize(width + getInsets().left + getInsets().right, height + getInsets().top + getInsets().bottom);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
		add(game);
		game.start();
	}
}
