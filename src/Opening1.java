import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Opening1 extends BasicGameState{

	private int state;
	Image playNow;
	Image exitGame;
	

	public Opening1(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		playNow = new Image("playNow.png");
	    exitGame = new Image("exitGame.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		playNow.draw(gc.getWidth()/2 - 100, gc.getHeight()/2 - 25);
	    exitGame.draw(gc.getWidth()-300, gc.getHeight()-100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		 int posX = Mouse.getX();
	     int posY = Mouse.getY();
	     
	     //
	     //starting the game
	     if((posX>((gc.getWidth()/2)-100) && posX<((gc.getWidth()/2)+100)) && (posY>((gc.getHeight()/2)-25) && posY<((gc.getHeight()/2)+25)))
	     {
	         if(Mouse.isButtonDown(0)){
	            sbg.enterState(Barnacle.map1);
	         }
	     }
	     
	     if((posX>((gc.getWidth()/2)-100) && posX<((gc.getWidth()/2)+100)) && (posY>((gc.getHeight()/4)-25) && posY<((gc.getHeight()/4)+25)))
	     {
	         if(Mouse.isButtonDown(0)){
	            sbg.enterState(Barnacle.story1);
	         }
	     }
	     //exitting the program
	     if((posX>(gc.getWidth()-300) && posX<(gc.getWidth()-100) && (posY>(50) && posY<(100))))
	     {
	         if(Mouse.isButtonDown(0)){
	        	 System.exit(0);
	         }
	      }
	     //
	     //
	     
	        Input input = gc.getInput();
			if(input.isKeyDown(Input.KEY_SPACE)){
				System.out.println("Printed space!");
			}
	}
	
	@Override
	public int getID() {
		return this.state;
	}
}