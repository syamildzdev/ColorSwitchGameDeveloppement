package dev.syamildz.tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import dev.syamildz.tilegame.Handler;
import dev.syamildz.tilegame.entities.creatures.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity e1, Entity e2) {
			if(e1.getY() + e1.getHeight() < e2.getY() + e2.getHeight())
				return -1;
			return 1;
		}
		
	};
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		entities.add(player);
	}
	
	public void tick() {
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
		entities.sort(renderSorter);
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}

	// Getters & Setters
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
