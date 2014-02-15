import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Barnacle extends StateBasedGame{
	public static final String gamename = "Barnacle!";
	public static final int opening1 = 0;
	public static final int menu1 = 1;
	public static final int menu2 = 2;
	public static final int map1 = 3;
	public static final int map2 = 4;
	public static final int story1 = 5;
	public static final int story2 = 6;
	
	public Barnacle(String gamename)
	{
		super(gamename);
		this.addState(new Opening1(opening1));
		this.addState(new Menu1(menu1));
		this.addState(new Menu2(menu2));
		this.addState(new Map1(map1));
		this.addState(new Map2(map2));
		this.addState(new Story1(story1));
		this.addState(new Story2(story2));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
	      this.getState(opening1).init(gc, this);
	      this.getState(menu1).init(gc, this);
	      this.getState(menu2).init(gc, this);
	      this.getState(map1).init(gc, this);
	      this.getState(map2).init(gc, this);
	      this.getState(story1).init(gc, this);
	      this.getState(story2).init(gc, this);
	      this.enterState(opening1);
	   }

	public static void main(String[] args)
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new Barnacle(gamename));
			appgc.setDisplayMode(1280, 720, false);
			//appgc.setDisplayMode(1600, 900, true);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}
		catch (SlickException ex)
		{
			ex.printStackTrace();
		}
	}
}