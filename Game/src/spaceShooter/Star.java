package spaceShooter;

import java.awt.Point;
import java.util.Random;

public class Star {
	Random randX = new Random();
	Random randY = new Random();
	
	double starBaseSpeed = 1;
	
	Point starPoint = new Point();
	
	int size = 2;
	
	public Star() {
		randomizeStarPos(3);
		if(Math.round(Math.random()) == 0) {
			size = 4;
			starBaseSpeed = 2;
		}
	}
	
	public int starX() {
		return (int)starPoint.getX();
	}
	public int starY() {
		return (int)starPoint.getY();
	}
	
	public void randomizeStarPos(int x) {
		if(x == 1) {
			starPoint.x = randX.nextInt(1900);
		}
		if(x == 2) {
			starPoint.y = randY.nextInt(1080);
		}
		if(x == 3)	{
			starPoint.x = randX.nextInt(1900);
			starPoint.y = randY.nextInt(1080);
		}
	}
	
	public int starSize() {
		return size;
	}
	
	public void moveStar() {
		starPoint.x -= (int)(starBaseSpeed);
	}
}
