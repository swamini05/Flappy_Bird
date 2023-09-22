 package com.swamini.flappyunicorn.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.swamini.flappyunicorn.loaders.GraphicsLoader;
import com.swamini.flappyunicorn.main.Game;

public class Backg {

	private BufferedImage backimage;
	private int xbg1, xbg2;
	
	private float velXBG;
	
	public Backg() {
		xbg1 = 0;
		//xbg2 = Game.WIDTH;
		xbg2 = 958;
		
		velXBG = 1.5f;
		
		backimage = GraphicsLoader.loadGraphics("background1.png");
	}
	
	public void tick() {
		
		xbg1 -= (int) Math.round(velXBG);
		xbg2 -= (int) Math.round(velXBG);
		
		if(xbg1 + 958 < 0) {
			xbg1 = 958;
		}
		
		if(xbg2 + 958 < 0) {
			xbg2 = 958;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(backimage, xbg1, 0, null);
		g.drawImage(backimage, xbg2, 0, null);
	}
}
