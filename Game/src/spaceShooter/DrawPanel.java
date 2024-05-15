package spaceShooter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	Enemy[] ships;
	Player player;
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	
	ArrayList<Star> star = new ArrayList<Star>();

	static Integer score;
	
	public void intPlayer(Player player) {
		this.player = player;
	}
	
	public void intShips(Enemy[] ships) {
		this.ships = new Enemy[ships.length];
		this.ships = ships;
	}
	
	public void intBullet(ArrayList<Bullet> bullet) {
		this.bullet = bullet;
	}
	
	public void intStars() {
		for(int i = 0; i < 500; i++) {
			star.add(new Star());
		}
	}
	
	
    public void paintComponent (Graphics g){
    	System.out.println(star.size());
        super.paintComponent(g);
        paintStars(star, g);
        paintPlayer(g);
        paintBullets(bullet, g);
        paintShips(ships, g);
        g.setColor(Color.green);
        g.drawString(score.toString(), 20, 20);
//        g.drawLine(90, 0, 90, 1080);
     }  
    
    void paintPlayer(Graphics g) {
    	g.setColor(player.pc());
    	
    	g.drawRoundRect(player.ppx(), player.ppy()-5, 40, 20, 12, 30);
    	g.drawRect(player.ppx()+40, player.ppy()+2, 20, 4);
    	
//    	g.drawOval(player.ppx(), player.ppy() , 40, 40);
//    	g.drawRect(player.ppx(), player.ppy(), 20, 10);
    }
    
    void paintShips(Enemy[] ships, Graphics g) {
    	for(int x = 0; x < ships.length; x++) {
    		Integer b = x;
    		randomShip(x, ships);
    		g.setColor(ships[x].getEnemyColor());
    		g.fillOval(ships[x].getEnemyPosition().x, ships[x].getEnemyPosition().y, ships[x].getEnemySize().width, ships[x].getEnemySize().height);
    		g.setColor(Color.white);
    		g.drawString(b.toString(), ships[x].getEnemyPosition().x, ships[x].getEnemyPosition().y);
//    		System.out.println("\n");
    	}
    	
    }
    
    void paintStars(ArrayList<Star> star, Graphics g) {
    	for(int i = 0; i < star.size(); i++) {
    		g.setColor(Color.white);
    		g.fillOval(star.get(i).starX(), star.get(i).starY(), star.get(i).starSize(), star.get(i).starSize());
			if(star.get(i).starX() < 0) {
				star.get(i).randomizeStarPos(2);
				star.get(i).starPoint.x = 1900;
			}
			star.get(i).moveStar();
		}
    }
    
    void paintBullets(ArrayList<Bullet> bullet, Graphics g) {
    	if(!bullet.isEmpty()) {
    		for(int x = 0; x < bullet.size(); x++) {
    			g.setColor(Color.red);
    			g.fillOval(bullet.get(x).Bx(), bullet.get(x).By(), 10, 5);
    			//    		System.out.println(bullet.get(x).Bx());
    			if(bullet.get(x).Bx() >= 1900) {
//    				System.out.println(bullet.size());
    				bullet.remove(x);
    				System.out.println(bullet.size());
    			}
    		}
    	}
    }
    
    public void updateScore(int score) {
    	this.score = score;
    }
    
    void randomShip(int x, Enemy[] ships) {
    	ships[x].randomizeShip();
    	
    	
//    	System.out.println("randomized " + x + " ship");
//    	System.out.println(ships[x].getEnemyPosition());
//    	System.out.println(ships[x].getEnemyColor());
    	
    	ships[x].shipMoveAllowed();
    }
}