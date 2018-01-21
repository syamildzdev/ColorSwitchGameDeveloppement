package dev.syamildz.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.syamildz.tilegame.Game;
import dev.syamildz.tilegame.Handler;
import dev.syamildz.tilegame.gfx.Animation;
import dev.syamildz.tilegame.gfx.Assets;

public class Player extends Creature {
	
	// Animation
	private Animation animWalk, animHighKick, animTwoSideAtk, animUppercut, animRoundKick;
	
	// Action
	protected int action;
	
	public Player(Handler handler, float x, float y) {
		// scale your creature size
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 45;
		bounds.y = 70;
		bounds.width = 30;
		bounds.height = 37;
		action = 0;
		
		// Animation
		animWalk = new Animation(100, Assets.player_walk);
		animHighKick = new Animation(35, Assets.player_highkick);
		animTwoSideAtk = new Animation(20, Assets.player_twosideatk);
		animUppercut = new Animation(35, Assets.player_uppercut);
		animRoundKick = new Animation(20, Assets.player_roundkick);
	}
	
	@Override
	public void tick() {
		// Animation
		animWalk.tick();
		animHighKick.tick();
		animTwoSideAtk.tick();
		animUppercut.tick();
		animRoundKick.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		action = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().highKick)
			action = 1;
		if(handler.getKeyManager().twoSideAtk)
			action = 2;
		if(handler.getKeyManager().uppercut)
			action = 3;		
		if(handler.getKeyManager().roundKick)
			action = 4;
	}
	
	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.player, (int) (x), (int) (y), width, height, null);
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width * 2, height * 2, null);
		g.setColor(Color.blue);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	private boolean actionWhileMoving() {
		if( (action != 0) && ((xMove > 0) || (yMove > 0) || (xMove < 0) || (yMove < 0)) )
			return true;
		else
			return false;
	}
	
	private Animation getCurrentAnimation() {
		switch(action) {
		case 1 : return animHighKick;
		case 2 : return animTwoSideAtk;
		case 3 : return animUppercut;
		case 4 : return animRoundKick;
		default : return animWalk;
		}	
	}
	
	private BufferedImage getCurrentAnimationFrame() {		
		Animation anim;
		anim = getCurrentAnimation();
		if(actionWhileMoving()) {
			return anim.getCurrentFrame();
		}
		
		return anim.getCurrentFrame();
	}

}
