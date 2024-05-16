package spaceShooter;

import java.awt.MouseInfo;
import java.util.ArrayList;

public class Shooting {
	CustomKeyListener keyBoard = new CustomKeyListener();
	
	
	int storeFrame;
	int currentFrame;
	int frameDif;
	
	int frameMax = 300;
	
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	
	public void intBullet(ArrayList<Bullet> bullet) {
		this.bullet = bullet;
	}
	
	public ArrayList<Bullet> updateArray(){
		return bullet;
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
    
    public void shoot() {
    	if((keyBoard.keyOut() == 32) && (checkIfCanShoot() >= frameMax)) {
    		bullet.add(new Bullet(90, MouseInfo.getPointerInfo().getLocation().y,true));
    	}
    }
	

}
