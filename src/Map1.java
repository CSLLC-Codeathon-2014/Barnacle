import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Map1 extends BasicGameState {
	private int state;
	/*private boolean playCollider1 = false;
	private boolean playCollider2 = false;
	private boolean projCollider1 = false;*/
	Image land;
	Image chicken1;
	Image chicken2;
	Image fire;
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
	
	public Map1(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		land = new Image("bg.png");
		chicken1= new Image("chickun.png");
		chicken2= new Image("chickun.png");
		fire= new Image("fire.png");
		player1 = new Velocity(play1X, play1Y, Vel1X, Vel1Y);
		player2 = new Velocity(play2X, play2Y, Vel2X, Vel2Y);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		land.draw(0, 0, gc.getWidth(), gc.getHeight());
		chicken1.draw(play1X, play1Y, gc.getWidth()/9, gc.getHeight()/8);
		chicken2.draw(play2X, play2Y, gc.getWidth()/9, gc.getHeight()/8);
		fire.draw(fire1X, fire1Y);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		
		//
		//PLAYER 1
		player1.CalcPosPlay1(gc);
		play1X=player1.posX();
		play1Y=player1.posY();
		if(input.isKeyDown(Input.KEY_T)){
			bool1=true;
			fire1X=play1X;
			fire1Y=play1Y;
			proj1 = new Velocity(fire1X+80, fire1Y, 20, -5);
		}
		
		if(bool1==true){
		proj1.CalcProj();
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
		if(input.isKeyDown(Input.KEY_P)){
			bool2=true;
			fire2X=play2X;
			fire2Y=play2Y;
			System.out.println("fire1Y part 1 is " + fire1Y);
			System.out.println("play1Y is " + play1Y);
			proj2 = new Velocity(fire2X+80, fire2Y, -20, -5);
		}
		
		if(bool2==true){
		proj2.CalcProj();
		fire2X=proj2.posX();
		fire2Y=proj2.posY();
		}
		//END OF PLAYER 2
		//
	}

	@Override
	public int getID() {
		return this.state;
	}

}
