package dev.syamildz.tilegame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.syamildz.tilegame.Handler;
import dev.syamildz.tilegame.gfx.Assets;
import dev.syamildz.tilegame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT); // 128
		
		bounds.x = 20;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 40;
		bounds.height = (int) (height - height / 1.5f); // 128 - 
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player_walk[2], (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
		g.setColor(Color.red);
		//g.fillRect((int) x,(int) y, width, height);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		//	(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,  bounds.height );
			
	}

}
