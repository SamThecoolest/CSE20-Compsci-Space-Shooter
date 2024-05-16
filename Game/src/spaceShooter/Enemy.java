package spaceShooter;

import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Enemy {
	
	Color enemyColor;
	Dimension enemySize = new Dimension();
	Point enemyPosition = new Point();
	
	Random rand = new Random();
	
	boolean reachedTarget = true;
	int nextY;
	int currentY;
	int newTarget;
	int newTargetDiff;
	int moveAmount;
	
	int ySpeed = 3;
	int xSpeed = 5;
	
	boolean moveAllowed = false;
	
	int frame;
	
	int forward;
	
	Enemy() {
		
	}
	
	public void speedUp(int score) {
		if(score >= 300) {
			ySpeed = 1;
			xSpeed = 2;
		}else if(score >= 200) {
			ySpeed = 1;
			xSpeed = 3;
		}else if (score >= 50){
			ySpeed = 2;
			xSpeed = 4;
		}
	}
	
	public Enemy(Color setColor, int width, int height, int x, int y) {
		 enemyColor = setColor;
		 enemySize.setSize(width, height);
		 enemyPosition.setLocation(x, y);
	}
	
	public Color getEnemyColor() {
		return enemyColor;
	}

	public void setEnemyColor(Color enemyColor) {
		this.enemyColor = enemyColor;
	}

	public Dimension getEnemySize() {
		return enemySize;
	}

	public void setEnemySize(Dimension enemySize) {
		this.enemySize = enemySize;
	}

	public Point getEnemyPosition() {
		return enemyPosition;
	}

	public void setEnemyPosition(Point enemyPosition) {
		this.enemyPosition = enemyPosition;
	}

	public void randomizeShip() {
    	if(enemyColor == null) {
    		enemySize = new Dimension(40, 40);
    		enemyColor = new Color((int)(Math.random() * 0x1000000));
    		this.enemyPosition = new Point(1950,  rand.nextInt(900)+10);
    	}
	}
	
	public void shipMoveAllowed() {
		moveAllowed = true;
	}
	
	public void ShipYMovement(int x) {
		if(moveAllowed) {
			if(reachedTarget) {
				newTarget = rand.nextInt(900)+10;
				this.currentY = (int) this.enemyPosition.getY();
//				System.out.println(enemyPosition.getY());

				newTargetDiff = newTarget - currentY;

//				System.out.println("s");
				reachedTarget = false;
			} else if((reachedTarget == false)) {
				if(frame%ySpeed == 0) {
					if(newTargetDiff != 0) {
						forward = newTargetDiff/Math.abs(newTargetDiff);

						if (forward == 0) {
							forward = 1;
						}
						moveAmount = forward;
						currentY += moveAmount;
						//				System.out.println(newTarget + " " + currentY + " " + newTargetDiff);
						//				System.out.println(moveAmount);
					}
					if(currentY == newTarget) {
						reachedTarget = true;
					}
				}
			}
			enemyPosition.y = currentY;
		}
	}
	
	public void shipXMovement() {
		if(moveAllowed) {
			frame++;
			if(frame%xSpeed == 0) {
				enemyPosition.x -= 1;
				if (enemyPosition.x <= -50) {
					enemyPosition.x = 1950;
					enemyColor = null;
				}
			}
		}
	}
	
	void printInfo() {
		System.out.println(enemyColor);
	}
}
