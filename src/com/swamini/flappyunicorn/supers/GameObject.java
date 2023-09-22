package com.swamini.flappyunicorn.supers;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	protected float velX = 3;
	protected float velY;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public Rectangle getHeadBounds() {
		Rectangle rect1 = new Rectangle((x + (width / 2)), y + 4, width / 2, height - 4);
		return rect1;
	}
	
	public Rectangle getBodyBounds() {
		Rectangle rect2 = new Rectangle(x + 2, y + (height / 2), width, height / 2);
		return rect2;
	}
	
	/*public Rectangle getHeadBounds(int uniW, int uniH) {
		Rectangle rect1 = new Rectangle((x + (uniW / 2)), y + 4, uniW / 2, uniH - 4);
		return rect1;
	}
	
	public Rectangle getBodyBounds(int uniW, int uniH) {
		Rectangle rect2 = new Rectangle(x + 2, y + (uniH / 2), uniW, uniH / 2);
		return rect2;
	}*/

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
}
