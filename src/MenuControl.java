import java.awt.Font;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MenuControl {
	
	Image menu;
	int state;
	TrueTypeFont font;
    Audio wowEffect;
    boolean wowtime;
    Audio cageEffect;
    boolean cagetime;
    boolean IsThereAI = true;
	Image exitGame;
	Image title;
	static Audio theme;
	boolean playTheme = true;
	int Screen = 0;
	 int posX = Mouse.getX();
    int posY = Mouse.getY();
    
	public void initMain() throws SlickException{
		exitGame = new Image("images/exitGame.png");
	    title = new Image("images/title.png");
		
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
	        theme = AudioLoader.getAudio("OGG", new FileInputStream("src/music/menu.ogg"));
	     } catch (IOException e){
	        e.printStackTrace();
	    }	
	}
	
	public void menuSelect(GameContainer gc, StateBasedGame sbg, Graphics g){
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("Singleplayer", gc.getWidth()/100*8, gc.getHeight()/3*2);
		g.drawString("Multiplayer", gc.getWidth()/100*30, gc.getHeight()/3*2);
		g.drawString("Story Mode", gc.getWidth()/100*55, gc.getHeight()/3*2);
		g.drawString("Options", gc.getWidth()/100*82, gc.getHeight()/3*2);
	    title.draw(gc.getWidth()/6, gc.getHeight()/4, gc.getWidth()/3*2, gc.getHeight()/4);
	    exitGame.draw(gc.getWidth()-(gc.getWidth()/11*2), gc.getHeight()-(gc.getHeight()/8));
	}
	
	public void menuUpdate(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		posX = Mouse.getX();
	    posY = Mouse.getY();
		if(playTheme ==true){
			theme.playAsSoundEffect(1.0f, 1.0f, false);
			playTheme=false;
			Mouse.setGrabbed(false);
			}
			else{}
	     
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
	        	IsThereAI = true;
	        	Screen=1;
				Mouse.setGrabbed(false);
	         }
	     }
	     else if((posX<(gc.getWidth()/2)  && posY<gc.getHeight()/2))
	     {
	         if(Mouse.isButtonDown(0)){
		        	IsThereAI = false;
		        	Screen=1;
					Mouse.setGrabbed(false);
	         }
	     }
			
			//Escape does nothing right now, just here if I decide it has a use.
			if(input.isKeyDown(Input.KEY_ESCAPE)){
				Screen=0;
				Mouse.setGrabbed(false);
			}
	}
	
	public void initLevel() throws SlickException{
		menu = new Image("images/menu.png");
		wowtime=true;
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("game_over.ttf");
	 
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(84f); // set font size
			font = new TrueTypeFont(awtFont, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	
	public void levelSelect(GameContainer gc, StateBasedGame sbg, Graphics g){
		g.setFont(font);
		g.setColor(Color.red);
		menu.draw(0,0,gc.getWidth(), gc.getHeight());
		g.drawString(posX + " " + posY, gc.getWidth()/35, gc.getHeight()/11*10);
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

	public void levelUpdate(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		posX = Mouse.getX();
	    posY = Mouse.getY();
	     
	     if(IsThereAI){
	    	 if((posX<((gc.getWidth()/5))))
	    	 {
	    		 if (Mouse.isButtonDown(0)){
	    			 Map.mapControl=0;
	    			 Map.mapinit();
	    			 Map.IsThisAI=true;
	    			 theme.stop();
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }

	    	 if((posX>((gc.getWidth()/5)*1) && posX<((gc.getWidth()/5)*2)))
	    	 {
	    		 if (Mouse.isButtonDown(0)){
	    			 Map.mapControl=1;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }

	    	 if((posX>((gc.getWidth()/5)*2) && posX<((gc.getWidth()/5)*3)))
	    	 {
	    		 if (Mouse.isButtonDown(0)){ 
	    			 Map.mapControl=2;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }

	    	 if((posX>((gc.getWidth()/5)*3) && posX<((gc.getWidth()/5)*4)))
	    	 {
	    		 if (Mouse.isButtonDown(0)){
	    			 System.out.println("Before the change it is: " + Map.mapControl);
	    			 Map.mapControl=3;
	    			 System.out.println("After the change it is: " + Map.mapControl);
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }

	    	 if((posX>((gc.getWidth()/5)*4)))
	    	 {
	    		 if(Mouse.isButtonDown(0)){
	    			 Map.mapControl=4;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }
	     }
	     
	     //
	     //Set up for the Multiplayer maps
	     else{
	     if((posX<((gc.getWidth()/5)*1)))
	     {
	         if(Mouse.isButtonDown(0)){
	        	 Map.mapControl=0;
	        	 Map.mapinit();
	        	 theme.stop();
	        	 Map.IsThisAI=false;
	            sbg.enterState(Barnacle.map);
	         }
	     }
	     if((posX>((gc.getWidth()/5)*1) && posX<((gc.getWidth()/5)*2)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	        	Map.mapControl=1;
	   	        	 	Map.mapinit();
	   	        	 	theme.stop();
	   	        	 	Map.IsThisAI=false;
	    	            sbg.enterState(Barnacle.map);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*2) && posX<((gc.getWidth()/5)*3)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	        	 Map.mapControl=2;
	    	        	 Map.mapinit();
		   	        	 theme.stop();
			        	 Map.IsThisAI=false;
	    	            sbg.enterState(Barnacle.map);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*3) && posX<((gc.getWidth()/5)*4)))
	    	     {
	    	         if(Mouse.isButtonDown(0)){
	    	        	 Map.mapControl=3;
	    	        	 Map.mapinit();
		   	        	 theme.stop();
			        	 Map.IsThisAI=false;
	    	            sbg.enterState(Barnacle.map);
	    	         }
	    	     }
	     if((posX>((gc.getWidth()/5)*4))){
	    	         if(Mouse.isButtonDown(0)){
	    	        	 Map.mapControl=4;
	    	        	 Map.mapinit();
		   	        	 theme.stop();
			        	 Map.IsThisAI=false;
	    	            sbg.enterState(Barnacle.map);
	    	         }
	    	     }
	     }
	     
	     
	        
	        //sets if player 1 is Doge
			if(input.isKeyDown(Input.KEY_D)){
				Map.dogepossible=true;
				Map.dogepossible=true;
				Map.secondinit();
				Map.secondinit();
				if(wowtime==true){
				wowEffect.playAsSoundEffect(1.0f, 1.0f, false);
				wowtime=false;
				}
			}
			
			//sets if player 2 is Cage
			if(input.isKeyDown(Input.KEY_NUMPAD9)){
				Map.cagepossible=true;
				Map.cagepossible=true;
				Map.secondinit();
				Map.secondinit();
				if(cagetime==true){
				cageEffect.playAsSoundEffect(1.0f, 1.0f, false);
				cagetime=false;
				}
				else{}
			}
			
			//Escape does nothing right now, just here if I decide it has a use.
			if(input.isKeyDown(Input.KEY_ESCAPE)){
				Screen = 0;
			}
	}

	public int getGameType(){
		return Screen;
	}
}