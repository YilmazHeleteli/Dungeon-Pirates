package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class NPC extends Character{
	
	Quest quest;
	boolean has_quest;
	boolean showquest = false;
	boolean is_vendor;
	Image choose_interaction;

	public void displayHasQuest() throws SlickException
	{
		if(has_quest == true)
		{
			Image Q = new Image("res/UI/questmark.png");
			Q.draw(xpos + 60, ypos - 73);
		}
		
	}
	
}
