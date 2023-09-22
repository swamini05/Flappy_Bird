package com.swamini.flappyunicorn.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.swamini.flappyunicorn.enums.TubeType;
import com.swamini.flappyunicorn.handlers.ObjectHandler;
import com.swamini.flappyunicorn.loaders.GraphicsLoader;
import com.swamini.flappyunicorn.main.Game;
import com.swamini.flappyunicorn.supers.GameObject;

public class Tube extends GameObject {

	TubeType type;

	BufferedImage tubeBlock;
	BufferedImage tube;

	public Tube(int x, int y, int width, int height, TubeType type) {
		super(x, y, width, height);

		this.type = type;
		velX = 3;

		tube = GraphicsLoader.loadGraphics("pop4_smol.png");

		if (type == TubeType.BOTTOM) {
			tubeBlock = GraphicsLoader.loadGraphics("tubebottomdown.png");
		} else if (type == TubeType.TOP) {
			tubeBlock = GraphicsLoader.loadGraphics("tubebottomtop.png");
		}
	}

	@Override
	public void tick() {
		velX = 3;
		x -= velX;

		if (x + width < 0) {
			ObjectHandler.removeObject(this);

			if (type == TubeType.BOTTOM) {
				Game.score += 1;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if (type == TubeType.BOTTOM) {
			g.drawImage(tube, x, y, 77, height, null);
			//g.drawImage(tubeBlock, x - 3, y, null);
		} else if (type == TubeType.TOP) {
			g.drawImage(tube, x, y, 77, height, null);
			//g.drawImage(tubeBlock, x - 3, y + height - 36, null);
		}
	}
}
