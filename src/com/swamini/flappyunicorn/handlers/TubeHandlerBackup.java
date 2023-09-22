/*package com.swamini.flappyunicorn.handlers;

import java.util.Random;

import com.swamini.flappyunicorn.enums.TubeType;
import com.swamini.flappyunicorn.gameobjects.Tube;
import com.swamini.flappyunicorn.main.Game;

public class TubeHandlerBackup {

	private static Random random = new Random();
	
	public static int groundSize = 168;
	public static int area = Game.HEIGHT - groundSize;
	public static int spacing = 120;
	public static int minSize = 40;
	public static int maxSize = area - spacing - minSize;
	public static int delay = 1;
	public static int now;
	
	public static void spawnTube() {
		int heightTop = random.nextInt(maxSize) + 1;
		
		while(heightTop < minSize) {
			heightTop = random.nextInt(maxSize) + 1;
		}
		
		int heightBottom = area - spacing - heightTop;
		
		Tube tubeTop = new Tube(500, 0, 78, heightTop, TubeType.TOP); 
		Tube tubeBottom = new Tube(500, heightTop + spacing, 78, heightBottom, TubeType.BOTTOM); 
		
		ObjectHandler.addObject(tubeTop);
		ObjectHandler.addObject(tubeBottom);
	}
	
	public static void tick() {
		if(now < delay) {
			now ++;
		} else {
			spawnTube();
			now = 0;
		}
	}
}*/
