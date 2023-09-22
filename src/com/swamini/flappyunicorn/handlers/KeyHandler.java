package com.swamini.flappyunicorn.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.swamini.flappyunicorn.main.Game;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int chosenKey = e.getKeyCode();
		if(e.getKeyCode() == chosenKey) {
			Game.bird.setVelY(-5);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (Game.gameover) {
				Game.startButton.pressed = true;
				ObjectHandler.list.clear();
				ObjectHandler.addObject(Game.bird);
				Game.gameover = false;
				Game.score = 0;
				Game.startButton.pressed = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
