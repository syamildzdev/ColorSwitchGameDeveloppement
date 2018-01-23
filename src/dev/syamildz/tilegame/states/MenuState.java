package dev.syamildz.tilegame.states;

import java.awt.Graphics;

import dev.syamildz.tilegame.Game;
import dev.syamildz.tilegame.Handler;
import dev.syamildz.tilegame.gfx.Assets;
import dev.syamildz.tilegame.ui.ClickListener;
import dev.syamildz.tilegame.ui.UIImageButton;
import dev.syamildz.tilegame.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200,200, 190, 50, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
			
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
	
	
	
}
