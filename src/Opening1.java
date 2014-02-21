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
	Image menu;
	TrueTypeFont font;
    private Audio wowEffect;
    private boolean wowtime;
    private Audio cageEffect;
    private boolean cagetime;
    static boolean IsThereAI = true;

	public Opening1(int state) {
		 this.state = state;
	}
	
	public static void isThereAI(boolean wellIsThere){
		IsThereAI = wellIsThere;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	    menu = new Image("images/menu.png");
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
		//sets sound for both doge and cage, but cage has no sound yet so set to wow
		 try {
		        wowEffect = AudioLoader.getAudio("OGG", new FileInputStream("src/music/wow.ogg"));
		     } catch (IOException e){
		        e.printStackTrace();
		    }
		try {
			cageEffect = AudioLoader.getAudio("OGG", new FileInputStream("src/music/wow.ogg"));
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
		if(IsThereAI)
			g.drawString("Singleplayer", gc.getWidth()/2-65, gc.getHeight()-(gc.getHeight()/8));
		else
			g.drawString("Multiplayer", gc.getWidth()/2-65, gc.getHeight()-(gc.getHeight()/8));
		g.drawString("Ice Cavern", gc.getWidth()-(gc.getWidth()/28*10), gc.getHeight()/8);
		g.drawString("Training Mode", gc.getWidth()-(gc.getWidth()/11*2), gc.getHeight()/8);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		 Input input = gc.getInput();
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
	     //if(IsThereAI){
	     if((posX<((gc.getWidth()/5)*1)))
	     {
	    	 if (input.isMousePressed(0)){
	        	 AiMap.mapControl=0;
	        	 AiMap.mapinit();
	        	 StartMenu.theme.stop();
	            sbg.enterState(Barnacle.mapAI);
	         }
	     }
	     if((posX>((gc.getWidth()/5)*1) && posX<((gc.getWidth()/5)*2)))
	    	     {
	    	 if (input.isMousePressed(0)){
	    	        	AiMap.mapControl=1;
	    	        	AiMap.mapinit();
	   	        	 	StartMenu.theme.stop();
	    	            sbg.enterState(Barnacle.mapAI);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*2) && posX<((gc.getWidth()/5)*3)))
	     {
	    	 if (input.isMousePressed(0)){ 
	        	 AiMap.mapControl=2;
	        	 AiMap.mapinit();
	        	 StartMenu.theme.stop();
	            sbg.enterState(Barnacle.mapAI);
	         }
	     }
	     if((posX>((gc.getWidth()/5)*3) && posX<((gc.getWidth()/5)*4)))
	    	     {
	    	 if (input.isMousePressed(0)){
	    	     		System.out.println("Before the change it is: " + AiMap.mapControl);
	    	        	 AiMap.mapControl=3;
		    	     	System.out.println("After the change it is: " + AiMap.mapControl);
	    	        	 AiMap.mapinit();
		   	        	 StartMenu.theme.stop();
	    	            sbg.enterState(Barnacle.mapAI);	    	        
	    	            }
	    	     }
	   
	     if((posX>((gc.getWidth()/5)*4)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	        	 AiMap.mapControl=4;
	    	        	 AiMap.mapinit();
		   	        	 StartMenu.theme.stop();
	    	            sbg.enterState(Barnacle.mapAI);
	    	         }
	    	     }
	     //}
	     
	     //
	     //Set up for the Multiplayer maps
	     //else{
	     /*
	     if((posX<((gc.getWidth()/5)*1)))
	     {
	         if(Mouse.isButtonDown(0)){
	        	 Map.mapControl=0;
	        	 Map.mapinit();
	        	 StartMenu.theme.stop();
	            sbg.enterState(Barnacle.map);
	         }
	     }
	     if((posX>((gc.getWidth()/5)*1) && posX<((gc.getWidth()/5)*2)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	        	Map.mapControl=1;
	   	        	 	Map.mapinit();
	   	        	 	StartMenu.theme.stop();
	    	            sbg.enterState(Barnacle.map);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*2) && posX<((gc.getWidth()/5)*3)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	        	 Map.mapControl=2;
	    	        	 Map.mapinit();
		   	        	 StartMenu.theme.stop();
	    	            sbg.enterState(Barnacle.map);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*3) && posX<((gc.getWidth()/5)*4)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	        	 Map.mapControl=3;
	    	        	 Map.mapinit();
		   	        	 StartMenu.theme.stop();
	    	            sbg.enterState(Barnacle.map);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*4)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	        	 Map.mapControl=4;
	    	        	 Map.mapinit();
		   	        	 StartMenu.theme.stop();
	    	            sbg.enterState(Barnacle.map);
	    	         }
	    	     }
	     //}
	      * 
	      * 
	      * 
	      * */
	     
	     
	        
	        //sets if player 1 is Doge
			if(input.isKeyDown(Input.KEY_D)){
				Map.dogepossible=true;
				AiMap.dogepossible=true;
				Map.secondinit();
				AiMap.secondinit();
				if(wowtime==true){
				wowEffect.playAsSoundEffect(1.0f, 1.0f, false);
				wowtime=false;
				}
				else{}
			}
			
			//sets if player 2 is Cage
			if(input.isKeyDown(Input.KEY_NUMPAD9)){
				Map.cagepossible=true;
				AiMap.cagepossible=true;
				Map.secondinit();
				AiMap.secondinit();
				if(cagetime==true){
				cageEffect.playAsSoundEffect(1.0f, 1.0f, false);
				cagetime=false;
				}
				else{}
			}
			
			//Escape does nothing right now, just here if I decide it has a use.
			if(input.isKeyDown(Input.KEY_ESCAPE)){
				sbg.enterState(Barnacle.startMenu);
			}
	}
	
	@Override
	public int getID() {
		return this.state;
	}
}