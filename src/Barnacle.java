import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Barnacle extends StateBasedGame{
	public static final String gamename = "Barnacle!";
	public static final int opening1 = 0;
	public static final int map = 1;
	public static final int mapAI = 6;
	
	public Barnacle(String gamename)
	{
		super(gamename);
		this.addState(new Opening1(opening1));
		this.addState(new Map(map));
		this.addState(new AiMap(mapAI));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
	      this.getState(opening1).init(gc, this);
	      this.getState(map).init(gc, this);
	      this.getState(mapAI).init(gc, this);
	      this.enterState(opening1);
	   }

	public static void main(String[] args)
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new Barnacle(gamename));
			//These set the display mode! the boolean value sets fullscreen.
			//appgc.setDisplayMode(1280, 720, false);
			appgc.setDisplayMode(1600, 900, true);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}
		catch (SlickException ex)
		{
			ex.printStackTrace();
		}
	}
}