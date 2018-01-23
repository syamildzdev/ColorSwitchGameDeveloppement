package dev.syamildz.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.syamildz.tilegame.display.Display;
import dev.syamildz.tilegame.gfx.Assets;
import dev.syamildz.tilegame.gfx.GameCamera;
import dev.syamildz.tilegame.gfx.ImageLoader;
import dev.syamildz.tilegame.gfx.SpriteSheet;
import dev.syamildz.tilegame.input.KeyManager;
import dev.syamildz.tilegame.input.MouseManager;
import dev.syamildz.tilegame.states.GameState;
import dev.syamildz.tilegame.states.MenuState;
import dev.syamildz.tilegame.states.State;

public class Game implements Runnable{
	
	private Display display;
	private Thread thread;
	public String title;
	private int width, height;
	public boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	public State gameState; // set to public for easier access reason
	public State menuState;
	
	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	// Camera 
	private GameCamera gameCamera;
	
	// Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	public void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	}
	
	public void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// clear graphics
		g.clearRect(0, 0, width, height);
		
		// draw here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		// end drawing
		// g.drawImage(Assets.player, 80, 80, null);
		// display the image
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Ticks and frame :" + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
