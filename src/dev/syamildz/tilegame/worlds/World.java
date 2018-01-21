package dev.syamildz.tilegame.worlds;

import java.awt.Graphics;

import dev.syamildz.tilegame.Game;
import dev.syamildz.tilegame.Handler;
import dev.syamildz.tilegame.entities.EntityManager;
import dev.syamildz.tilegame.entities.creatures.Player;
import dev.syamildz.tilegame.entities.statics.Tree;
import dev.syamildz.tilegame.tiles.Tile;
import dev.syamildz.tilegame.utils.Util;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	// Entity
	private EntityManager entityManager;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		// add entities
		entityManager.addEntity(new Tree(handler, 200, 100));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) (Math.max(0, (handler.getGameCamera().getxOffset() / Tile.TILEWIDTH)));
		int xEnd = (int) (Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH) + 1);
		int yStart = (int) (Math.max(0,  (handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT)));
		int yEnd = (int) (Math.min(height,  (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT) + 1);
		
		for(int y = yStart; y < yEnd; y++) { 
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		// Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		if(t == null)
			return Tile.dirtTile;
		
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Util.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);
		spawnX = Util.parseInt(tokens[2]);
		spawnY = Util.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++) {
			for(int x = 0;x< width;x++) {
				tiles[x][y] = Util.parseInt(tokens[(x + y * width) + 4]);
			}
		}
				
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
}
