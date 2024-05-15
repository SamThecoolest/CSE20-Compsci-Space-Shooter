package spaceShooter;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;



public class Main{
	
	public static void main(String[] args) {
		JFrame application = new JFrame();

		DrawPanel panel = new DrawPanel();
		
		CustomKeyListener keyIn = new CustomKeyListener();
		
		Collisions col = new Collisions();

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.getContentPane().setBackground(Color.yellow);
		application.setSize (1900, 1080);
		application.setVisible(true);
//		application.setResizable(false);
		application.isFocusable();
		
		application.addKeyListener(keyIn);
		
		panel.setBackground(Color.black);
		
		ArrayList<Star> star = new ArrayList<Star>();
		
		ArrayList<Bullet> bullet = new ArrayList<Bullet>();
		
//		bullet.add(new Bullet(90, 1080/2, false));
		
		Enemy[] ships;
		Player player = new Player();
		
		panel.intPlayer(player);
		
		
		ships = new Enemy[12150];
    	for(int i = 0; i < ships.length; i++) {
    		ships[i] = new Enemy(); 
    		panel.intShips(ships);
    		col.intShips(ships);
    	}
    
		int frameCount = 0;
		
		panel.intStars();
		
		while(true) {
			frameCount++;
			col.runCollisionCheck();
			player.updatePlayerPos();
			updateBullets(bullet, panel, keyIn, col);
			for(int i = 0; i < ships.length; i++) {
				ships[i].ShipYMovement(i);
				ships[i].shipXMovement();
			}
			for(int i = 0; i < bullet.size(); i++) {
				bullet.get(i).bulletMoveX();
			}
			
			keyIn.updateFrame(frameCount);
			panel.updateScore(col.scoreOut());
			panel.repaint();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	static void updateBullets(ArrayList<Bullet> bullet, DrawPanel panel, CustomKeyListener keyIn, Collisions col) {
		panel.intBullet(bullet);
		keyIn.intBullet(bullet);
		col.intBullets(bullet);
		
	}
}
