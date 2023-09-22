package com.swamini.flappyunicorn.handlers;

import java.util.Random;

import com.swamini.flappyunicorn.enums.TubeType;
import com.swamini.flappyunicorn.gameobjects.Tube;
import com.swamini.flappyunicorn.main.Game;

public class TubeHandler {

	private static Random random = new Random();
	
	public static int groundSize = 168;
	public static int area = Game.HEIGHT; //- groundSize;
	public static int spacing = 120;
	public static int minSize = 40;
	public static int maxSize = area - spacing - minSize; //maxSize //608
	public static int delay = 1;
	public static int now;
	
	public static void spawnTube() {
		int heightTop = random.nextInt(area - spacing - minSize) + 1;
		//int topTubeY = -400 + new Random().nextInt(441);
		
		while(heightTop < minSize) {
			heightTop = random.nextInt(maxSize) + 1;
		}
		//heightTop = maxSize;
		
		int heightBottom = area - spacing - heightTop;
		int test = heightTop + spacing;
		int test2 = heightBottom - spacing - heightTop;
		int test3 = heightTop + (maxSize - heightTop);
		int test4 = 0 - (maxSize - heightTop);
		int test5 = heightTop - area;
		int test6 = test - spacing - heightTop;
		int test7 = -heightTop;
		int test8 = -728 ;
		//System.out.println(test2);
		//Tube tubeTop = new Tube(500, test8, 72, maxSize, TubeType.TOP); 
		//Tube tubeBottom = new Tube(500, test, 72, maxSize, TubeType.BOTTOM);
		
		//new
		Tube tubeTop = new Tube(500, test5, 72, area, TubeType.TOP);
		Tube tubeBottom = new Tube(500, test, 72, area, TubeType.BOTTOM);
		
		//orignal
		//Tube tubeTop = new Tube(500, 0, 78, heightTop, TubeType.TOP); 
		//Tube tubeBottom = new Tube(500, heightTop + spacing, 78, 608, TubeType.BOTTOM);
		//attempt1
		//Tube tubeTop = new Tube(500, topTubeY, 77, maxSize, TubeType.TOP); 
		//Tube tubeBottom = new Tube(500, topTubeY + maxSize + spacing, 77, maxSize, TubeType.BOTTOM); 
		
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
}
