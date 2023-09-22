package com.swamini.flappyunicorn.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.swamini.flappyunicorn.handlers.ObjectHandler;
import com.swamini.flappyunicorn.loaders.GraphicsLoader;
import com.swamini.flappyunicorn.main.Game;
import com.swamini.flappyunicorn.supers.Animation;
import com.swamini.flappyunicorn.supers.GameObject;

public class Bird extends GameObject {

	Animation animation;
	
	public float gravity;
	public float maxSpeed;
	public int currentUniW;
	public int currentUniH;
	
	public Bird(int x, int y, int width, int height) {
		super(x, y, width,  height);
		
		gravity = 0.3f;
		maxSpeed = 12f;
		
		BufferedImage[] images = new BufferedImage[8];
		
		for(int i = 0; i < images.length; i++) {
			images[i] = GraphicsLoader.loadGraphics("uni" + i + ".png");
			//currentUniW = images[i].getWidth();
			//currentUniH = images[i].getHeight();
		}
		
		animation = new Animation(this, 70, true, images);
		animation.start();
		
		ObjectHandler.addObject(this);
	}

	@Override
	public void tick() {
		
		velY += gravity;
		y += velY;
		
		if(velY > maxSpeed) {
			velY = maxSpeed;
		}
		
		if(y + height > Game.HEIGHT) {
			y = Game.HEIGHT - height;
			setVelY(0);
		}
		
		if(y < 0) {
			y = 0;
			setVelY(0);
			
		}
		

		GameObject temp = null;
		
		for(int i = 0; i < ObjectHandler.list.size(); i++) {
			temp = ObjectHandler.list.get(i);
			
			/*if(temp instanceof Tube) {
				if(this.getBounds().intersects(temp.getBounds())) {
					Game.gameover = true;
				}*/
				//getbounds1 and 2, 1 rect-ht,1 rect-wd, if statement is or for both getbounds 
			if(temp instanceof Tube) {
				//if(this.getHeadBounds(currentUniW, currentUniH).intersects(temp.getBounds()) || this.getBodyBounds(currentUniW, currentUniH).intersects(temp.getBounds())) {
				if(this.getHeadBounds().intersects(temp.getBounds()) || this.getBodyBounds().intersects(temp.getBounds())) {
					Game.gameover = true;
				}
			}
		}
		
		animation.tick();
	}

	@Override
	public void render(Graphics g) {
		animation.render(g);
    }
}
