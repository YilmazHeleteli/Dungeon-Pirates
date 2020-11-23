package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;


public class Play extends BasicGameState{
	
	public String mouse = "";
	public String playerPos = "";
	text text = new text();
	Image healthUI;
	
	Door exit = new Door();
	NPC NPC1 = new NPC();
	NPC NPC2 = new NPC();
	
	Player player = new Player();
	
	Image background; 
	private Music drunk;
	
	public Play(int state) {
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		background = new Image("res/MainTown/tavern.png");
		
		healthUI = new Image("res/UI/health.png");
		
		drunk = new Music("res/MainTown/drunk.wav");
		//music.loop();
		
		player.init();
		player.xpos = 500;
		player.ypos = 457;
		
		NPC1.sprite = new Image("res/MainTown/NPC1/idle.png");
	    NPC1.xpos = 247;
	    NPC1.ypos = 218;
		NPC1.currentAnimation = NPC1.getAnimation(NPC1.sprite, 10, 1, 150, 90, 144, 100);
		NPC1.has_quest = true;
		
		NPC2.sprite = new Image("res/MainTown/NPC2/idle.png");
		NPC2.xpos = 800;
		NPC2.ypos = 260;
		NPC2.currentAnimation = NPC2.getAnimation(NPC2.sprite, 7, 1, 150, 125, 144, 100);
		NPC2.has_quest = false;
		
		exit.text = "exit The Jolly Sailor";
		exit.x1 = 464;
		exit.x2 = 546;
		exit.y1 = 534;
		exit.y2 = 490;
		drunk.play();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		background.draw(0, -150);
		g.drawString(String.valueOf(playerPos), 50, 80);
		healthUI.draw(0,0);
		player.displayHealth(g);
		g.drawString(mouse, 50, 50);
		text.blankText();		
		NPC1.Animation(NPC1.xpos, NPC1.ypos);
		NPC1.displayHasQuest();
	    NPC2.Animation(NPC2.xpos, NPC2.ypos);
		
		player.Animation(player.xpos,player.ypos);
		
		if(exit.inside == true)
		{
			text.enterDoor(g, exit.text);
		}
		
	}
	
	public void collision()
	{
		if(player.xpos < 160)
		{
			player.xpos++;
		}
		if(player.xpos > 804)
		{
			player.xpos--;
		}
		if(player.ypos > 534)
		{
			player.ypos--;
		}
		if(player.ypos < 62)
		{
			player.ypos++;
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
	
		
		Input input = gc.getInput();
		mouse = "X: " + xpos + " Y: " + ypos;
		playerPos = "X: " + player.xpos + " Y: " + player.ypos;	
		NPC1.currentAnimation.update(delta);
		NPC2.currentAnimation.update(delta);
		player.move(gc);
		player.currentAnimation.update(delta);
		collision();
		
		exit.checkInside(player.xpos, player.ypos);
		exit.enter(gc, sbg, 2);
	}
	
	public int getID() {
		return 1;
	}
}
