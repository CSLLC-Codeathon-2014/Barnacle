import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;
import org.lwjgl.input.Mouse;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import org.newdawn.slick.openal.AudioLoader;

public class StartMenu extends BasicGameState{

    static Audio theme;
	boolean playTheme = true;
    

	private int state;
	Image exitGame;
	Image title;
	TrueTypeFont font;
	public StartMenu(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	    exitGame = new Image("images/exitGame.png");
	    title = new Image("title.png");
		
		//set font
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("game_over.ttf");
	 
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(84f); // set font size
			font = new TrueTypeFont(awtFont, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
	        theme = AudioLoader.getAudio("OGG", new FileInputStream("src/menu.ogg"));
	     } catch (IOException e){
	        e.printStackTrace();
	    }
}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("Singleplayer", gc.getWidth()/100*8, gc.getHeight()/3*2);
		g.drawString("Multiplayer", gc.getWidth()/100*30, gc.getHeight()/3*2);
		g.drawString("Story Mode", gc.getWidth()/100*55, gc.getHeight()/3*2);
		g.drawString("Options", gc.getWidth()/100*82, gc.getHeight()/3*2);
	    title.draw(gc.getWidth()/6, gc.getHeight()/4, gc.getWidth()/3*2, gc.getHeight()/4);
	    exitGame.draw(gc.getWidth()-(gc.getWidth()/11*2), gc.getHeight()-(gc.getHeight()/8));
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		if(playTheme ==true){
			theme.playAsSoundEffect(1.0f, 1.0f, false);
			playTheme=false;
			}
			else{}
		 int posX = Mouse.getX();
	     int posY = Mouse.getY();
	     
	     //Escape button below
	     if((posX>(gc.getWidth()-350) && posX<(gc.getWidth()-80) && (posY>(40) && posY<(110))))
	     {
	         if(Mouse.isButtonDown(0)){
	        	 System.exit(0);
	         }
	      }
	     
	     //
	     //starting the game
	     //This first section is for AI singleplayer.
	     if((posX<(gc.getWidth()/4)  && posY<gc.getHeight()/2))
	     {
	         if(Mouse.isButtonDown(0)){
	        	Opening1.isThereAI(true);
	            sbg.enterState(Barnacle.opening1);
	         }
	     }
	     else if((posX<(gc.getWidth()/2)  && posY<gc.getHeight()/2))
	     {
	         if(Mouse.isButtonDown(0)){
		        	Opening1.isThereAI(false);
	            sbg.enterState(Barnacle.opening1);
	         }
	     }
	     
	     
	        Input input = gc.getInput();
			
			//Escape does nothing right now, just here if I decide it has a use.
			if(input.isKeyDown(Input.KEY_ESCAPE)){
				//sbg.enterState(Barnacle.opening1);
			}
	}
	
	@Override
	public int getID() {
		return this.state;
	}
}