import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;


public class MenuCommands {
	
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
	boolean clickable=false;
    
    public void initMain() throws SlickException{
		exitGame = new Image("resources/images/exitGame.png");
	    title = new Image("resources/images/title.png");
		
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
	        theme = AudioLoader.getAudio("OGG", new FileInputStream("resources/music/menu.ogg"));
	     } catch (IOException e){
	        e.printStackTrace();
	    }	
	}
    
    public void initLevel() throws SlickException{
		menu = new Image("resources/images/menu.png");
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
		        wowEffect = AudioLoader.getAudio("OGG", new FileInputStream("resources/music/wow.ogg"));
		     } catch (IOException e){
		        e.printStackTrace();
		    }
		try {
			cageEffect = AudioLoader.getAudio("OGG", new FileInputStream("resources/music/wow.ogg"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

}
