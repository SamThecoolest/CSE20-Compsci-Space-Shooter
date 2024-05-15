package spaceShooter;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Collisions {
	Enemy[] ships;
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	
	Random rand = new Random();
	
	static Integer score = 0;
	
	public void intShips(Enemy[] ships) {
		this.ships = ships;
	}
	public void intBullets(ArrayList<Bullet> bullet) {
		this.bullet = bullet;
	}
	
	public Integer scoreOut() {
		return score;
	}
	
	public void runCollisionCheck() {
		for(int p = 0; p < bullet.size(); p++) {
			for(int o = 0; o < ships.length; o++) {
				int tx = bullet.get(p).Bx();
				int ty = bullet.get(p).By();
				
				int x = (int)ships[o].getEnemyPosition().getX();
				int y = (int)ships[o].getEnemyPosition().getY();
				
				double distance = Math.sqrt((Math.pow((tx-x), 2)) + (Math.pow((ty-y),2)));
//				System.out.println("bullet: " + p + " ship: " + o + " distance: " + distance);
				if (distance <= 40) {
//					System.out.println("hit ship: " + o);
//					bullet.remove(p);
					
					Point newEnemyPos = new Point(1960, rand.nextInt(1080)+1);
					ships[o].setEnemyPosition(newEnemyPos);
					ships[o].randomizeShip();
					score++;
					break;
				}
			}
		}
	}

//	double distance = Math.sqrt(Math.pow((tx-x), 2) + Math.pow((ty-y),2));


}
//d=sqr((tx-x)^2+(ty-y)^2)