package javagame;

import org.newdawn.slick.*;

public class Player extends Character{

	Animation player;
	char direction = 'r';
	int health = 100;

	
	
	
	boolean movingR;
	boolean movingL;
	boolean movingU;
	boolean movingD;
	
	Image idleRight;
	Image idleLeft;
	Image walkingRight;
	Image walkingLeft;
	Image runningRight;
	Image runningLeft;
	
	public void init() throws SlickException
	{
		
		idleRight = new Image("res/Player/idleRight.png");
		idleLeft = new Image("res/Player/idleLeft.png");
		sprite = idleRight;
		currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
		walkingRight = new Image("res/Player/walkRight.png");
		walkingLeft = new Image("res/Player/walkLeft.png");
	
		
	}
	
	
	public void move(GameContainer gc) throws SlickException
	{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_D))
		{
			direction = 'r';
			if(movingR != true && direction == 'r')
			{
				sprite = walkingRight;
			    currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
			    movingR = true;
			}
			
			xpos = xpos + 0.2f;
		}
		else
		{
			movingR = false;
		}
		if(input.isKeyDown(Input.KEY_A))
		{
			direction = 'l';
			if(movingL != true && direction == 'l')
			{
				sprite = walkingLeft;
			    currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
			    movingL = true;
			}
			
			xpos = xpos - 0.2f;
		}
		else
		{
			movingL = false;
		}
		
		if(input.isKeyDown(Input.KEY_D) && input.isKeyDown(Input.KEY_A))
		{
			movingR = false;
			movingL = false;
		}
		
		if(input.isKeyDown(Input.KEY_W))
		{
			if(movingU != true)
			{
				if(direction == 'l')	
				{
					sprite = walkingLeft;
				    currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
				    movingU = true;
				}
				else
				{
					sprite = walkingRight;
				    currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
				    movingU = true;
				}
			}
			
			ypos = ypos - 0.2f;
		}
		else
		{
			movingU = false;
		}
		if(input.isKeyDown(Input.KEY_S))
		{
			if(movingD != true)
			{
				if(direction == 'l')	
				{
					sprite = walkingLeft;
				    currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
				    movingD = true;
				}
				else
				{
					sprite = walkingRight;
				    currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
				    movingD = true;
				}
			}
			
			ypos = ypos + 0.2f;
		}
		else
		{
			movingD = false;
		}
		
		if(input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_S))
		{
			movingU = false;
			movingD = false;
		}
		
		if(movingR == false && movingL == false && movingU == false && movingD == false)
		{
			if(direction == 'r')
			{
				if(sprite!=idleRight)
				{
					sprite = idleRight;
				    currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
				}
			}
			else 
			{
				if(sprite!=idleLeft)
				{
					sprite = idleLeft;
				    currentAnimation = getAnimation(sprite, 10, 1, 300, 167, 144, 80);
				}
			}
			
		}
		
		
}
	
	
	
	public void displayHealth(Graphics g)
	{
	     g.drawString(String.valueOf(health), 1090, 20);
	}
	
}
