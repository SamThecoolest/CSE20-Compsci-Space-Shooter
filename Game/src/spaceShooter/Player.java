package spaceShooter;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;



public class Player{
	Point playerPos = new Point(30 , MouseInfo.getPointerInfo().getLocation().y);
	Color playerColor = Color.yellow;
	
	public Player() {
		
	}

	int ppx() {
		return (int) playerPos.getX();
	}
	
	int ppy() {
		return (int) playerPos.getY();
	}
	
	Color pc() {
		return playerColor;
	}
	
	void updatePlayerPos() {
		playerPos.y = MouseInfo.getPointerInfo().getLocation().y;
	}


}
