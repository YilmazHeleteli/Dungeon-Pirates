package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.StateBasedGame;

public class NPC extends Character{
	
	Quest quest;
	String name;
	boolean has_quest;
	boolean showquest = false;
	boolean is_vendor;
	boolean insideInteract;
	Circle interactZone = new Circle(xpos, ypos, 0);
	Image choose_interaction;

	public void displayHasQuest() throws SlickException
	{
		if(has_quest == true)
		{
			Image Q = new Image("res/UI/questmark.png");
			Q.draw(xpos + 60, ypos - 73);
		}
		
	}
	
	protected void setInteract(float r, float ox, float oy)
	{
		interactZone.setLocation(xpos + ox, ypos + oy);
		interactZone.setRadius(r);
	}

	protected void checkInteract(float x, float y, GameContainer gc)
	{
		float circleX = (float) Math.pow(x - xpos, 2);	
		float circleY = (float) Math.pow(y - ypos, 2);
				
		double radiusSquared = (float) Math.pow(interactZone.getRadius(), 2);
		
		if((circleX + circleY) < radiusSquared)
		{
			insideInteract = true;
			Input input = gc.getInput();
			if(input.isKeyPressed(Input.KEY_E))
			{
				interact();
			}
		}
		else
		{
			insideInteract = false;
		}
		
	}
	
	protected void load (GameContainer gc, StateBasedGame sbg, int delta, Player player) throws SlickException
	{
		checkInteract(player.xpos, player.ypos, gc);
		currentAnimation.update(delta);
	}
	
	protected void render(NPC npc, text text, Graphics g) throws SlickException
	{
		Animation(npc.xpos, npc.ypos);
		displayHasQuest();
		if(insideInteract == true)
		{
			text.blankText();
			text.talk(g, npc.name);
		}

	}
	
	protected void interact()
	{
		
	}
	
}
