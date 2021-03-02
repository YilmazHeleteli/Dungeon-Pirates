package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.ShapeRenderer;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;



public class Play extends BasicGameState{
	
	public String mouse = "";
	public String playerPos = "";
	text text = new text();
	Image healthUI;
	
	String test;
	
	Door exit = new Door();
	NPC Katrina = new NPC();
	NPC NPC2 = new NPC();
	
	Player player = new Player();
	UI ui = new UI();
	
	Image background;
	Image inventory;
	private Music drunk;
	
	public Play(int state) {
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		test = "test";
		
		background = new Image("res/MainTown/tavern.png");
		
		healthUI = new Image("res/UI/health.png");
		
		drunk = new Music("res/MainTown/drunk.wav");
		//music.loop();
		
		player.init();
		player.xpos = 500;
		player.ypos = 457;
		
		Katrina.name = "Katrina";
		Katrina.sprite = new Image("res/MainTown/NPC1/idle.png");
	    Katrina.xpos = 247;
	    Katrina.ypos = 218;
		Katrina.currentAnimation = Katrina.getAnimation(Katrina.sprite, 10, 1, 150, 90, 144, 100);
		Katrina.has_quest = true;
		Katrina.setInteract(90, 0, -100);
		
		
	
		
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
		
		ui.init(gc, sbg);
		
		
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		background.draw(0, -150);
		g.drawString(test, 500, 50);
		g.drawString(String.valueOf(playerPos), 50, 80);
		healthUI.draw(0,0);
		player.displayHealth(g);
		g.drawString(mouse, 50, 50);
		text.blankText();		
		Katrina.Animation(Katrina.xpos, Katrina.ypos);
		Katrina.displayHasQuest();
		g.draw(Katrina.interactZone);

	    NPC2.Animation(NPC2.xpos, NPC2.ypos);
	
		player.Animation(player.xpos,player.ypos);
		
		if(ui.invOpen == true)
		{
			ui.openInventory(gc, sbg, g);
		}

		if(exit.inside == true)
		{
			text.enterDoor(g, exit.text);
		}
		if(Katrina.insideInteract == true)
		{
			text.talk(g, Katrina.name);
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
		Katrina.currentAnimation.update(delta);
		NPC2.currentAnimation.update(delta);
		player.move(gc);
		player.currentAnimation.update(delta);
		collision();
		
		Katrina.checkInteract(player.xpos, player.ypos, gc);
		
	    ui.inventory(gc, sbg);
		exit.checkInside(player.xpos, player.ypos);
		exit.enter(gc, sbg, 2);
	}
	
	public int getID() {
		return 1;
	}
}
