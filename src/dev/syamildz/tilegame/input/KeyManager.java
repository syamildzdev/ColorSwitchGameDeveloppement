package dev.syamildz.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean highKick, twoSideAtk, uppercut, roundKick;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		// Moves
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		// Actions
		highKick = keys[KeyEvent.VK_A];
		twoSideAtk = keys[KeyEvent.VK_Z];
		uppercut = keys[KeyEvent.VK_E];
		roundKick = keys[KeyEvent.VK_R];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
