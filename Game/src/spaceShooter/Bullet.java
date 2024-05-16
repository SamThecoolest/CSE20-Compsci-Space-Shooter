package spaceShooter;

import java.awt.Color;
import java.awt.Point;

public class Bullet {
	Point bulletPos = new Point(0, 0);
	Color bulletColor;
	double bulletSpeedRandom;
	
	boolean createNew = false;

	boolean playerFired;
	
	public Bullet(int x, int y, boolean playerFired) {
		bulletPos.x = x;
		bulletPos.y = y;
		this.playerFired = playerFired;
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
		if(playerFired) {
			bulletColor = Color.green;
			bulletPos.x += 3;
		}else if (!playerFired) {
			bulletColor = Color.red;
			bulletPos.x -= 2;
		}
	}
		
	
	int Bx(){
		return (int)bulletPos.getX();
	}
	int By() {
		return (int)bulletPos.getY();
	}
	
}
