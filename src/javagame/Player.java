package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Player extends Character{

	
	
	Animation player;
	int health = 100;
	
	
	public void displayHealth(Graphics g)
	{
	     g.drawString(String.valueOf(health), 1090, 20);
	}
	
}
