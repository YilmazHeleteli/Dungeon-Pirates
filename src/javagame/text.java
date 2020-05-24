package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class text {
	
	protected int x = 50;
	protected int y = 0;

	public void blankText() throws SlickException
	{
		Image I = new Image("res/UI/textempty.png");
		I.draw(x, y);
	}
	public void talk(Graphics g)
	{
		final String talk = "Press E to talk";
		g.drawString(talk, 460,700);
	}
	
}
