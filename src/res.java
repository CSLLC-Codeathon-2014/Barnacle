import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;
import org.lwjgl.input.Mouse;
import java.io.InputStream;

public class res extends BasicGameState{

	private int state;
	TrueTypeFont font;

	public res(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		//set font
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("game_over.ttf");
	 
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(84f); // set font size
			font = new TrueTypeFont(awtFont, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("1600x900 fullscreen", gc.getWidth()/4, gc.getHeight()/30*3);
		g.drawString("1280x720 fullscreen", gc.getWidth()/4, gc.getHeight()/30*12);
		g.drawString("1280x720 windowed", gc.getWidth()/4, gc.getHeight()/30*22);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
	     int posY = Mouse.getY();
	     
	     //Escape button below
	     if((posY<gc.getHeight()/3))
	     {
	         if(Mouse.isButtonDown(0)){
	        	 Barnacle.appgc.setDisplayMode(1280, 720, false);
	        	 sbg.enterState(Barnacle.opening1);
	         }
	      }
	     else if((posY<gc.getHeight()/3*2))
	     {
	         if(Mouse.isButtonDown(0)){
	        	 Barnacle.appgc.setDisplayMode(1280, 720, true);
	        	 sbg.enterState(Barnacle.opening1);
	         }
	      }
	     else if((posY>gc.getHeight()/3*2))
	     {
	         if(Mouse.isButtonDown(0)){
	        	 Barnacle.appgc.setDisplayMode(1600, 900, true);
	        	 sbg.enterState(Barnacle.opening1);
	         }
	      }
	     
	        Input input = gc.getInput();
			if(input.isKeyDown(Input.KEY_ESCAPE)){
				System.exit(0);
			}
	}
	
	@Override
	public int getID() {
		return this.state;
	}
}