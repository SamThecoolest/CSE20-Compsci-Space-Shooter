package spaceShooter;

import java.awt.Point;

public class Bullet {
	Point bulletPos = new Point(0, 0);
	double bulletSpeedRandom;
	
	boolean createNew = false;
	
	boolean bulletMove = true;
	
	public Bullet(int x, int y, boolean setFalse) {
		bulletPos.x = x;
		bulletPos.y = y;
		bulletMove = setFalse;
	}
	
	public Bullet(int x, int y) {
		bulletSpeedRandom = Math.random() + 1;
		bulletPos.x = x;
		bulletPos.y = y;
	}
	
	boolean newBulletCheck() {
		return createNew;
	}
	
	void newBullet() {
		createNew = true;
	}
	
	void printPos() {
		System.out.println(bulletPos);
	}
	
	void bulletMoveX() {
		if(bulletMove) 
			bulletPos.x += 1;
	}
	
	int Bx(){
		return (int)bulletPos.getX();
	}
	int By() {
		return (int)bulletPos.getY();
	}
	
}
