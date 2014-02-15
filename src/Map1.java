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

	public Map1(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		land = new Image("bg.png");
		chicken= new Image("chickun.png");
		fire= new Image("chickun.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		land.draw(0, 0, gc.getWidth(), gc.getHeight());
		chicken.draw(chickX, chickY, gc.getWidth()/9, gc.getHeight()/8);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if(chickY>=520 && chickY<635 && chickX>350 && chickX<1250){
			chickY=520;
			VelY=0;
		}
		if(chickY>610 && chickX<600 && chickX>200){
			chickX=200;
		}
		if(chickY>610 && chickX>600 && chickX<1250){
			chickX=1250;
		}
		if(input.isKeyDown(Input.KEY_SPACE)){
			if(VelY<5)
			VelY=20;
		}
		VelY--;
		if(VelY>20)
		VelY=20;
		if(VelY<-20)
			VelY=-20;
		
		if(input.isKeyDown(Input.KEY_A)){
		if(VelX>1)
			VelX=1;
		VelX-=2;
		}
		if(input.isKeyDown(Input.KEY_D)){
			if(VelX<-1)
				VelX=-1;
			VelX+=2;
		}
		
		if(VelX<-20)
			VelX=-20;
			if(VelX>20)
				VelX=20;
		if(VelX>0)
		VelX--;
		if(VelX<0)
		VelX++;
		
		chickY=chickY-VelY;
		chickX=chickX+VelX;
	}

	@Override
	public int getID() {
		return this.state;
	}

}
