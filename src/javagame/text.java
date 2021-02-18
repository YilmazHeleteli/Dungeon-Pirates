package javagame;

import org.newdawn.slick.*;


public class text {
	
	protected int x = 50;
	protected int y = 0;

	public void blankText() throws SlickException
	{
		Image I = new Image("res/UI/textempty.png");
		I.draw(x, y);
	}
	public void talk(Graphics g, String target)
	{
		final String talk = "Press E to talk to " + target;
		g.drawString(talk, 460,700);
	}
	public void enterDoor(Graphics g, String text)
	{
		final String enter = "Press E to " + text;
		g.drawString(enter, 460, 700);
	}
	
}
