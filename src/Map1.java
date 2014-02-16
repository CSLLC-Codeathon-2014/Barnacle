import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;
import org.lwjgl.Sys;

public class Map1 extends BasicGameState {
	private int state;
	Image land;
	Image chicken1;
	Image chicken2;
	Image fire1;
	Image fire2;
	int play1X=450;
	int play1Y=400;
	int Vel1X=0;
	int Vel1Y=0;
	int play2X=900;
	int play2Y=400;
	int Vel2X=0;
	int Vel2Y=0;
	int fire1X = 2000;
	int fire1Y = 2000;
	int fire2X = 2000;
	int fire2Y = 2000;
	Boolean bool1=false;
	Boolean bool2=false;
	Velocity player1;
	Velocity proj1;
	Velocity player2;
	Velocity proj2;
	Circle projCircle1 = null;
	Circle projCircle2 = null;
	int playerhit1=0;
	int playerhit2=0;
	boolean CanBeHit1 =true;
	boolean CanBeHit2 =true;
	int OldTime;
	int newTime;
	
	
	
	public Map1(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		land = new Image("bg.png");
		chicken1= new Image("chickun1.png");
		chicken2= new Image("chickun2.png");
		fire1= new Image("fure.png");
		fire2= new Image("fure.png");
		player1 = new Velocity(play1X, play1Y, Vel1X, Vel1Y);
		player2 = new Velocity(play2X, play2Y, Vel2X, Vel2Y);
	}
	

	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		land.draw(0, 0, gc.getWidth(), gc.getHeight());
		chicken1.draw(play1X, play1Y, gc.getWidth()/9, gc.getHeight()/8);
		chicken2.draw(play2X, play2Y, gc.getWidth()/9, gc.getHeight()/8);
		fire1.draw(fire1X, fire1Y);
		fire2.draw(fire2X, fire2Y);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		projCircle1= new Circle(fire1X, fire1Y, 25);
		projCircle2= new Circle(fire2X, fire2Y, 25);
		
		//
		//PLAYER 1
		player1.CalcPosPlay1(gc);
		play1X=player1.posX();
		play1Y=player1.posY();
		if(input.isKeyDown(Input.KEY_T)){
			bool1=true;
			fire1X=play1X;
			fire1Y=play1Y;
			projCircle1= new Circle(fire1X, fire1Y, 25);
			proj1 = new Velocity(fire1X+80, fire1Y, 20, -5);
		}
		
		if(bool1==true){
		proj1.CalcProj();
		projCircle1= new Circle(fire1X, fire1Y, 25);
		fire1X=proj1.posX();
		fire1Y=proj1.posY();
		}
		//END OF PLAYER 1
		//
		
		//
		//PLAYER 2
		player2.CalcPosPlay2(gc);
		play2X=player2.posX();
		play2Y=player2.posY();
		if(input.isKeyDown(Input.KEY_ENTER)){
			bool2=true;
			fire2X=play2X;
			fire2Y=play2Y;
			projCircle2= new Circle(fire2X, fire2Y, 25);
			proj2 = new Velocity(fire2X+80, fire2Y, -20, -5);
		}
		
		if(bool2==true){
		proj2.CalcProj();
		fire2X=proj2.posX();
		fire2Y=proj2.posY();
		}
		//END OF PLAYER 2
		//
		if(projCircle1.contains(play2X+50, play2Y+50)){
			if(CanBeHit2==true){
			playerhit1++;
			System.out.println("hit");
			CanBeHit2=false;
			}
			else{
				
			}
		}
		if(projCircle2.contains(play1X+50, play1Y+50)){
			playerhit2++;
			System.out.println("hit");
		}	
		if(playerhit1>9){
			System.out.println("Player 1 wins!");
		}
		if(playerhit2>9){
			System.out.println("Player 2 wins!");
		}
	}

	@Override
	public int getID() {
		return this.state;
	}

}
