package javagame;

import org.newdawn.slick.*;

public class Character {
	
	Image sprite;
	Animation currentAnimation;
	float xpos;
	float ypos;
	
	
	
	public Animation getAnimation(Image i, int spritesX, int spritesY, int spriteWidth, int spriteHeight, int frames, int duration)
	{
		Animation a = new Animation(false);
		int c = 0;
		for(int y = 0; y < spritesY; y++) {
			
			for(int x = 0; x < spritesX; x++)
			{
				if(c < frames) a.addFrame(i.getSubImage(x*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight), duration);
			}
			c++;
		}
		
		return a;
	}
	
	public void Animation(float xpos, float ypos)
	{
		currentAnimation.draw(xpos, ypos);
	}
	

}
