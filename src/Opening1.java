import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;
import org.lwjgl.input.Mouse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;

public class Opening1 extends BasicGameState{

	private int state;
	Image exitGame;
	Image title;
	Image menu;
	TrueTypeFont font;
    private Audio wowEffect;
    private boolean wowtime;
    private Audio cageEffect;
    private boolean cagetime;

	public Opening1(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	    exitGame = new Image("exitGame.png");
	    menu = new Image("menu.png");
	    title = new Image("title.png");
//		Font awtFont = new Font("Old English Text MT", Font.BOLD, 36);
//		font = new TrueTypeFont(awtFont, true);
		wowtime=true;
		
		//set font
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("game_over.ttf");
	 
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(84f); // set font size
			font = new TrueTypeFont(awtFont, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//
		//
		//
		//audio related stuff:
		 try {
		        wowEffect = AudioLoader.getAudio("OGG", new FileInputStream("src/wow.ogg"));
		     } catch (IOException e){
		        e.printStackTrace();
		    }
		try {
			cageEffect = AudioLoader.getAudio("OGG", new FileInputStream("src/wow.ogg"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setFont(font); 
		g.setColor(Color.red);
		menu.draw(0,0,gc.getWidth(), gc.getHeight());
		g.drawString("Toxic", gc.getWidth()/34, gc.getHeight()/11);
		g.drawString("     Wasteland", gc.getWidth()/34, gc.getHeight()/11+50);
		g.drawString("Paradise", gc.getWidth()/4, gc.getHeight()/8);
		g.drawString("Lava Pit", gc.getWidth()/2-65, gc.getHeight()/8);
		g.drawString("Ice Cavern", gc.getWidth()-565, gc.getHeight()/8);
		g.drawString("Training Mode", 1340, gc.getHeight()/8);
		
	    exitGame.draw(gc.getWidth()-300, gc.getHeight()-100);
	    title.draw(gc.getWidth()/6, gc.getHeight()/4);
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
	            sbg.enterState(Barnacle.map1);
	         }
	     }
	     if((posX>((gc.getWidth()/5)*1) && posX<((gc.getWidth()/5)*2)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	            sbg.enterState(Barnacle.map2);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*2) && posX<((gc.getWidth()/5)*3)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	            sbg.enterState(Barnacle.map3);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*3) && posX<((gc.getWidth()/5)*4)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	            sbg.enterState(Barnacle.map4);
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
			if(input.isKeyDown(Input.KEY_D)){
				Map1.dogepossible=true;
				Map1.secondinit();
				Map2.dogepossible=true;
				Map2.secondinit();
				Map3.dogepossible=true;
				Map3.secondinit();
				Map4.dogepossible=true;
				Map4.secondinit();
				Map5.dogepossible=true;
				Map5.secondinit();
				if(wowtime==true){
				wowEffect.playAsSoundEffect(1.0f, 1.0f, false);
				wowtime=false;
				}
				else{}
			}
			
			//sets Cage
			if(input.isKeyDown(Input.KEY_NUMPAD9)){
				Map1.cagepossible=true;
				Map1.secondinit();
				Map2.cagepossible=true;
				Map2.secondinit();
				Map3.cagepossible=true;
				Map3.secondinit();
				Map4.cagepossible=true;
				Map4.secondinit();
				Map5.cagepossible=true;
				Map5.secondinit();
				if(cagetime==true){
				cageEffect.playAsSoundEffect(1.0f, 1.0f, false);
				cagetime=false;
				}
				else{}
			}
			
			if(input.isKeyDown(Input.KEY_ESCAPE)){
				sbg.enterState(Barnacle.opening1);
			}
	}
	
	@Override
	public int getID() {
		return this.state;
	}
}