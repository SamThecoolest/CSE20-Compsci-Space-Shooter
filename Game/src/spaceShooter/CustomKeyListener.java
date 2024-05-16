package spaceShooter;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CustomKeyListener implements KeyListener{
	int keyPressed;
	
	public void keyTyped(KeyEvent e) {
    }
	
    public void keyPressed(KeyEvent e) {
    	keyPressed = e.getKeyCode();
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public int keyOut() {
    	System.out.println(keyPressed);
    	return keyPressed;
    }

}
