 package com.swamini.flappyunicorn.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.swamini.flappyunicorn.loaders.GraphicsLoader;
import com.swamini.flappyunicorn.main.Game;

public class Ground {

	private BufferedImage image;
	private int x1, x2;
	
	private float velXG;
	
	public Ground() {
		x1 = 0;
		x2 = Game.WIDTH;
		
		velXG = 3;
		
		image = GraphicsLoader.loadGraphics("ground.png");
	}
	
	public void tick() {
		
		x1 -= velXG;
		x2 -= velXG;
		
		if(x1 + Game.WIDTH < 0) {
			x1 = Game.WIDTH;
		}
		
		if(x2 + Game.WIDTH < 0) {
			x2 = Game.WIDTH;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x1, Game.HEIGHT - 168, null);
		g.drawImage(image, x2, Game.HEIGHT - 168, null);
	}
}
