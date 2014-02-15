import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Map1 extends BasicGameState {
	private int state;
	Image land;
	Image chicken;
	Image fire;
	int chickX=450;
	int chickY=400;
	int VelX=0;
	int VelY=0;
	int fireX = -20;
	int fireY = -20;
	Boolean X=false;
	Velocity player1;
	Velocity proj1;
	
	public Map1(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		land = new Image("bg.png");
		chicken= new Image("chickun.png");
		fire= new Image("fire.png");
		player1 = new Velocity(chickX, chickY, VelX, VelY);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		land.draw(0, 0, gc.getWidth(), gc.getHeight());
		chicken.draw(chickX, chickY, gc.getWidth()/9, gc.getHeight()/8);
		fire.draw(fireX, fireY, 25, 25);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		player1.CalcPos(gc);
		chickX=player1.posX();
		chickY=player1.posY();
		if(input.isKeyDown(Input.KEY_I)){
			X=true;
			fireX=chickX;
			fireY=chickY;
			proj1 = new Velocity(fireX, fireY, 20, -10);
		}
		if(X==true){
		proj1.CalcProj();
		fireX=proj1.posX();
		fireY=proj1.posY();
		}
	}

	@Override
	public int getID() {
		return this.state;
	}

}
