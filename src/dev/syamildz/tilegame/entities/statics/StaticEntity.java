package dev.syamildz.tilegame.entities.statics;

import dev.syamildz.tilegame.Handler;
import dev.syamildz.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
