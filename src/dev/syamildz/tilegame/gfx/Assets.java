package dev.syamildz.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 64, height = 64;
	private static final int widthAnim = 64, heightAnim = 64;

	public static BufferedImage ground, dirt, rock, bushes, tree, small_tree;
	public static BufferedImage[] player_walk, player_highkick, player_twosideatk, player_uppercut, player_roundkick;
	public static BufferedImage[] btn_start;
	
	public static void init() {
		SpriteSheet worldSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/tiles2.png")); 
		SpriteSheet animSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/catAnim.png")); 
		SpriteSheet uiSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/ui.jpg"));
		
		bushes = worldSheet.crop(0, 0, width, height);
		dirt = worldSheet.crop(width, 0, width, height);
		ground = worldSheet.crop(width * 2, 0, width, height);
		rock = worldSheet.crop(0, height, width, height);
		tree = worldSheet.crop(width, height, width, 90);
		small_tree = worldSheet.crop(width * 2, height, width, height); // ok
		
		btn_start = new BufferedImage[2];
		// 190.50
		btn_start[0] = uiSheet.crop(0, 0, 190, 50);
		btn_start[1] = uiSheet.crop(0, 60, 190, 50);
		
		player_walk = new BufferedImage[8];
		player_highkick = new BufferedImage[6];
		player_twosideatk = new BufferedImage[8];
		player_uppercut = new BufferedImage[6];
		player_roundkick = new BufferedImage[8];
		
		player_walk[0] = animSheet.crop(0, heightAnim, widthAnim, heightAnim);
		player_walk[1] = animSheet.crop(widthAnim, heightAnim, widthAnim, heightAnim);
		player_walk[2] = animSheet.crop(widthAnim * 2, heightAnim, widthAnim, heightAnim);
		player_walk[3] = animSheet.crop(widthAnim * 3, heightAnim, widthAnim, heightAnim);
		player_walk[4] = animSheet.crop(widthAnim * 4, heightAnim, widthAnim, heightAnim);
		player_walk[5] = animSheet.crop(widthAnim * 5, heightAnim, widthAnim, heightAnim);
		player_walk[6] = animSheet.crop(widthAnim * 6, heightAnim, widthAnim, heightAnim);
		player_walk[7] = animSheet.crop(widthAnim * 7, heightAnim, widthAnim, heightAnim);
		
		player_highkick[0] = animSheet.crop(0, heightAnim * 11, widthAnim, heightAnim);
		player_highkick[1] = animSheet.crop(widthAnim, heightAnim * 11, widthAnim, heightAnim);
		player_highkick[2] = animSheet.crop(widthAnim * 2, heightAnim * 11, widthAnim, heightAnim);
		player_highkick[3] = animSheet.crop(widthAnim * 3, heightAnim * 11, widthAnim, heightAnim);
		player_highkick[4] = animSheet.crop(widthAnim * 4, heightAnim * 11, widthAnim, heightAnim);
		player_highkick[5] = animSheet.crop(widthAnim * 5, heightAnim * 11, widthAnim, heightAnim);
		
		player_twosideatk[0] = animSheet.crop(0, heightAnim * 13, widthAnim, heightAnim);
		player_twosideatk[1] = animSheet.crop(widthAnim, heightAnim * 13, widthAnim, heightAnim);
		player_twosideatk[2] = animSheet.crop(widthAnim * 2, heightAnim * 13, widthAnim, heightAnim);
		player_twosideatk[3] = animSheet.crop(widthAnim * 3, heightAnim * 13, widthAnim, heightAnim);
		player_twosideatk[4] = animSheet.crop(widthAnim * 4, heightAnim * 13, widthAnim, heightAnim);
		player_twosideatk[5] = animSheet.crop(widthAnim * 5, heightAnim * 13, widthAnim, heightAnim);
		player_twosideatk[6] = animSheet.crop(widthAnim * 6, heightAnim * 13, widthAnim, heightAnim);
		player_twosideatk[7] = animSheet.crop(widthAnim * 7, heightAnim * 13, widthAnim, heightAnim);
		
		player_uppercut[0] = animSheet.crop(0, heightAnim * 15, widthAnim, heightAnim);
		player_uppercut[1] = animSheet.crop(widthAnim, heightAnim * 15, widthAnim, heightAnim);
		player_uppercut[2] = animSheet.crop(widthAnim * 2, heightAnim * 15, widthAnim, heightAnim);
		player_uppercut[3] = animSheet.crop(widthAnim * 3, heightAnim * 15, widthAnim, heightAnim);
		player_uppercut[4] = animSheet.crop(widthAnim * 4, heightAnim * 15, widthAnim, heightAnim);
		player_uppercut[5] = animSheet.crop(widthAnim * 5, heightAnim * 15, widthAnim, heightAnim);
		
		player_roundkick[0] = animSheet.crop(0, heightAnim * 12, widthAnim, heightAnim);
		player_roundkick[1] = animSheet.crop(widthAnim, heightAnim * 12, widthAnim, heightAnim);
		player_roundkick[2] = animSheet.crop(widthAnim * 2, heightAnim * 12, widthAnim, heightAnim);
		player_roundkick[3] = animSheet.crop(widthAnim * 3, heightAnim * 12, widthAnim, heightAnim);
		player_roundkick[4] = animSheet.crop(widthAnim * 4, heightAnim * 12, widthAnim, heightAnim);
		player_roundkick[5] = animSheet.crop(widthAnim * 5, heightAnim * 12, widthAnim, heightAnim);
		player_roundkick[6] = animSheet.crop(widthAnim * 6, heightAnim * 12, widthAnim, heightAnim);
		player_roundkick[7] = animSheet.crop(widthAnim * 7, heightAnim * 12, widthAnim, heightAnim);
		
		
	}
	
}
