package spaceShooter;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CustomKeyListener implements KeyListener{
	
	int storeFrame;
	int currentFrame;
	int frameDif;
	
	int frameMax = 1;
	
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	
	public void intBullet(ArrayList<Bullet> bullet) {
		this.bullet = bullet;
	}
	
	public ArrayList<Bullet> updateArray(){
		return bullet;
	}
	
	public void keyTyped(KeyEvent e) {
    }
	
    public void keyPressed(KeyEvent e) {
    	if((e.getKeyCode() == 32) && (checkIfCanShoot() >= frameMax)) {
    		bullet.add(new Bullet(90, MouseInfo.getPointerInfo().getLocation().y));
    	}
    }
    
    public void keyReleased(KeyEvent e) {
    }

    public void updateFrame(int frame) {
//    	System.out.println("frame: " + frame + " 'currentframe:' " + currentFrame + " stored frame: " + storeFrame + " frame dif: " + (currentFrame-storeFrame));
    	currentFrame = frame;
    }
    private int checkIfCanShoot() {
		frameDif = currentFrame - storeFrame;
		if(frameDif >= frameMax)
		storeFrame = currentFrame;
		return frameDif;
	}
}
