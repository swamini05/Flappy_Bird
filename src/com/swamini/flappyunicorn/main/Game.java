package com.swamini.flappyunicorn.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.ServerSocket;

import com.swamini.flappyunicorn.gameobjects.Backg;
import com.swamini.flappyunicorn.gameobjects.Bird;
import com.swamini.flappyunicorn.gameobjects.Ground;
import com.swamini.flappyunicorn.handlers.KeyHandler;
import com.swamini.flappyunicorn.handlers.MouseHandler;
import com.swamini.flappyunicorn.handlers.ObjectHandler;
import com.swamini.flappyunicorn.handlers.TubeHandler;
import com.swamini.flappyunicorn.loaders.GraphicsLoader;
import com.swamini.flappyunicorn.supers.Button;
import com.swamini.flappyunicorn.supers.GameObject;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

	public static final int HEIGHT = 768;
	public static final int WIDTH = 432;
	
	public boolean running;
	public static boolean gameover;

	public static BufferedImage img_gameover;
	//backg-public static BufferedImage background;
	public static Backg backg;
	public static Ground ground;
	public static Bird bird;

	public static Button startButton;
	
	public static int score;
	
	Thread thread;
	ServerSocket serverSocket;

	public static void main(String[] args) {
		new Window(WIDTH, HEIGHT, "Flappy Unicorn", new Game());
	}

	public synchronized void start() {
		running = true;
		thread = new Thread();
		thread.start();
		run();
	}

	public void init() {
		addKeyListener(new KeyHandler());
		addMouseListener(new MouseHandler());

		img_gameover = GraphicsLoader.loadGraphics("gameover.png");
		//backg-background = GraphicsLoader.loadGraphics("background_space.jpg");
		backg = new Backg();
		ground = new Ground();

		bird = new Bird(50, 50, 51, 49);
		
		startButton = new Button(Game.WIDTH / 2 - 156 / 2, 200, 156, 87, GraphicsLoader.loadGraphics("playbutton.png"));
	}

	public void tick() {
		if (!gameover) {
			ObjectHandler.tick();
			//ground.tick();
			backg.tick();
		}
	} 

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		//backg-g.drawImage(background, 0, 0, null);
		backg.render(g);
		//ground.render(g);
		
		ObjectHandler.render(g);

		if(gameover) {
			g.drawImage(img_gameover, Game.WIDTH / 2 - 288 / 2, 130, null);
			Game.startButton.render(g);
		}
		
		/* 
		//code for static score font size
		g.setFont(new Font("French Script MT", Font.BOLD, 55));
		g.setColor(new Color(255, 0, 170));
		

		String s = Integer.toString(score);
		int textWidth = g.getFontMetrics().stringWidth(s);*/
		
		int ovalDiameter = 45;
		int scoreY;
		g.setColor(new Color(255, 0, 170));
		g.fillOval((Game.WIDTH / 2 - 45/2), 36, ovalDiameter, ovalDiameter);
		
		if(score<10) {
			scoreY = 72;
			g.setFont(new Font("French Script MT", Font.BOLD, 55));
			//g.fillRoundRect((Game.WIDTH / 2 - 40/2), (70/2), 40, 45, 20, 20);
		}
		else if(score>99) {
			scoreY = 67;
			g.setFont(new Font("French Script MT", Font.BOLD, 32));
			//g.fillRoundRect((Game.WIDTH / 2 - 100/2), (70/2), 100, 45, 20, 20);;
		}
		else {
			scoreY = 69;
			g.setFont(new Font("French Script MT", Font.BOLD, 42));
			//g.fillRoundRect((Game.WIDTH / 2 - 70/2), (70/2), 70, 45, 20, 20);
		}
		
		g.setColor(new Color(255, 215, 0));
		String s = Integer.toString(score);
		int textWidth = g.getFontMetrics().stringWidth(s);
		
		g.drawString(s, Game.WIDTH / 2 - textWidth / 2, scoreY);
		
		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		init();
		this.requestFocus();

		long pastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000.0 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - pastTime) / ns;
			pastTime = now;

			while (delta > 0) {
				tick();
				updates++;

				render();
				frames++;

				delta--;
			}
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("fps: " + frames + "\t   tickrate: " + updates);
				TubeHandler.tick();
				updates = 0;
				frames = 0;
			}
		}
	}
}
