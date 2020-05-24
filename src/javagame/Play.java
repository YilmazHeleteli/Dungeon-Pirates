package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;



public class Play extends BasicGameState{
	
	public String mouse = "";
	text Text = new text();
	Image healthUI;
	
	NPC NPC1 = new NPC();
	NPC NPC2 = new NPC();
	
	Player player = new Player();
	
	Image background; 
	private Music music;
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		background = new Image("res/MainTown/tavern.png");
		music = new Music("res/MainTown/drunk.wav");
		healthUI = new Image("res/UI/health.png");
	
		//music.play();
		//music.loop();
		
		player.xpos = 500;
		player.ypos = 400;
		player.sprite = new Image("res/Player/idle.png");
		player.idle = player.getAnimation(player.sprite, 10, 1, 300, 167, 144, 80);

		NPC1.sprite = new Image("res/MainTown/NPC1/idle.png");
		NPC1.xpos = 320;
		NPC1.ypos = 398;
		NPC1.idle = NPC1.getAnimation(NPC1.sprite, 10, 1, 150, 90, 144, 100);
		NPC1.has_quest = true;
		
		NPC2.sprite = new Image("res/MainTown/NPC2/idle.png");
		NPC2.xpos = 800;
		NPC2.ypos = 260;
		NPC2.idle = NPC2.getAnimation(NPC2.sprite, 7, 1, 150, 125, 144, 100);
		NPC2.has_quest = false;
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		background.draw(0,0);
		healthUI.draw(0,0);
		player.displayHealth(g);
		g.drawString(mouse, 50, 50);
		Text.blankText();
		player.idleAnimation();
		
		NPC1.idleAnimation();
		NPC1.displayHasQuest();
		
		NPC2.idleAnimation();
		NPC2.displayHasQuest();
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "X: " + xpos + " Y: " + ypos;
		player.idle.update(delta);
		NPC1.idle.update(delta);
		NPC2.idle.update(delta);
		
		
	}
	
	public int getID() {
		return 1;
	}
}
