package dev.syamildz.tilegame.tiles;

import java.awt.image.BufferedImage;

import dev.syamildz.tilegame.gfx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.rock, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
