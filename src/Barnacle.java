import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Barnacle extends StateBasedGame{
	public static final String gamename = "Barnacle!";
	public static final int res = 0;
	public static final int startMenu = 1;
	public static final int map = 2;

	static AppGameContainer appgc;
	
	public Barnacle(String gamename)
	{
		super(gamename);
		this.addState(new res(res));
		this.addState(new StartMenu(startMenu));
		this.addState(new Map(map));;
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
	      this.getState(res).init(gc, this);
	      this.getState(startMenu).init(gc, this);
	      this.getState(map).init(gc, this);
	      this.enterState(res);
	   }
	
	public static void main(String[] args)
	{
		
		try
		{
			appgc = new AppGameContainer(new Barnacle(gamename));
			appgc.setDisplayMode(600, 300, false);
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}
		catch (SlickException ex)
		{
			ex.printStackTrace();
		}
	}
}
