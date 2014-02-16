import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Opening1 extends BasicGameState{

	private int state;
	Image exitGame;
	Image MainMenu;
	TrueTypeFont font;
	

	public Opening1(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	    exitGame = new Image("exitGame.png");
	    MainMenu = new Image("MainMenu.png");
		Font awtFont = new Font("", Font.PLAIN, 36);
		font = new TrueTypeFont(awtFont, true);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setFont(font); 
		g.setColor(Color.red);
		MainMenu.draw(0,0,gc.getWidth(), gc.getHeight());
		g.drawString("Training Mode", 1320, 400);
	    exitGame.draw(gc.getWidth()-300, gc.getHeight()-100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		 int posX = Mouse.getX();
	     int posY = Mouse.getY();
	     
	     if((posX>(gc.getWidth()-300) && posX<(gc.getWidth()-100) && (posY>(50) && posY<(100))))
	     {
	         if(Mouse.isButtonDown(0)){
	        	 System.exit(0);
	         }
	      }
	     
	     //
	     //starting the game
	     if((posX<((gc.getWidth()/5)*1)))
	     {
	         if(Mouse.isButtonDown(0)){
	            sbg.enterState(Barnacle.map4);
	         }
	     }
	     if((posX>((gc.getWidth()/5)*1) && posX<((gc.getWidth()/5)*2)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	            sbg.enterState(Barnacle.map3);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*2) && posX<((gc.getWidth()/5)*3)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	            sbg.enterState(Barnacle.map1);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*3) && posX<((gc.getWidth()/5)*4)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	            sbg.enterState(Barnacle.map2);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*4)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	            sbg.enterState(Barnacle.map5);
	    	         }
	    	     }
	     
	     if((posX>((gc.getWidth()/2)-100) && posX<((gc.getWidth()/2)+100)) && (posY>((gc.getHeight()/4)-25) && posY<((gc.getHeight()/4)+25)))
	     {
	         if(Mouse.isButtonDown(0)){
	            sbg.enterState(Barnacle.map2);
	         }
	     }
	     //exitting the program
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