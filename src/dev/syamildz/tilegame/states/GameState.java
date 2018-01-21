package dev.syamildz.tilegame.states;

import java.awt.Graphics;

import dev.syamildz.tilegame.Game;
import dev.syamildz.tilegame.Handler;
import dev.syamildz.tilegame.entities.creatures.Player;
import dev.syamildz.tilegame.entities.statics.Tree;
import dev.syamildz.tilegame.gfx.Assets;
import dev.syamildz.tilegame.tiles.Tile;
import dev.syamildz.tilegame.worlds.World;

public class GameState extends State{
	
	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "resources/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
