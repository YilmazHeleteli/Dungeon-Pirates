package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.ShapeRenderer;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;



public class Play extends BasicGameState{
	
	public String mouse = "";
	public String playerPos = "";
	text text = new text();

	
	float test;
	float test2;
	
	Door exit = new Door(464, 546, 535, 490, "Exit The Jolly Sailor");
	NPC Katrina = new NPC();
	NPC Dave = new NPC();
	
	Player player = new Player(500, 457);
	UI ui = new UI();
	
	Image background;
	Image inventory;
	private float musicPos;
	
	public Play(int state) {
		
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		background = new Image("res/MainTown/tavern.png");
		
		
		test = 0;
		ui.music = new Music("res/MainTown/drunk.wav");
		ui.music.loop();

		player.init();
		
		Katrina.name = "Katrina";
		Katrina.sprite = new Image("res/MainTown/NPC1/idle.png");
	    Katrina.xpos = 247;
	    Katrina.ypos = 218;
		Katrina.currentAnimation = Katrina.getAnimation(Katrina.sprite, 10, 1, 150, 90, 144, 100);
		Katrina.has_quest = true;
		Katrina.setInteract(90, 0, -100);
		
		
		Dave.sprite = new Image("res/MainTown/NPC2/idle.png");
		Dave.xpos = 800;
		Dave.ypos = 260;
		Dave.currentAnimation = Dave.getAnimation(Dave.sprite, 7, 1, 150, 125, 144, 100);
		Dave.has_quest = false;
		
		ui.init(gc, sbg);
		
		
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		background.draw(0, -150);
		g.drawString(Float.toString(musicPos), 500, 50);
		g.drawString(String.valueOf(playerPos), 50, 80);

		ui.render(ui, player, g);
		
		g.drawString(mouse, 50, 50);
				
		Katrina.render(Katrina, text, g);
	    Dave.render(Dave, text, g);
		player.Animation(player.xpos,player.ypos);
		exit.renderDoor(g, exit, text);

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
		collision();

		mouse = "X: " + xpos + " Y: " + ypos;
		playerPos = "X: " + player.xpos + " Y: " + player.ypos;	
		player.load(gc, sbg, delta);
		Katrina.load(gc, sbg, delta, player);
		Dave.load(gc, sbg, delta, player);
		ui.load(gc, sbg, delta);
		exit.load(gc, sbg, 2, player, ui);
		
	}
	
	public int getID() {
		return 1;
	}
}
