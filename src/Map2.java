import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.geom.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;


public class Map2 extends BasicGameState {
	private int state;
	Image land;
	static Image chicken1;
	static Image chicken2;
	Image fire1;
	Image fire2;
	Image hud;
	static Image hit1;
	static Image hit2;
	Image wnner;
	Image win1;
	Image win2;
	int win1x=2000;
	int win1y=2000;
	int win2x=2000;
	int win2y=2000;
	int winx=2000;
	int winy=2000;
	int play1X=450;
	int play1Y=400;
	int Vel1X=0;
	int Vel1Y=0;
	int play2X=900;
	int play2Y=400;
	int Vel2X=0;
	int Vel2Y=0;
	int fire1X = 2000;
	int fire1Y = 2000;
	int fire2X = 2000;
	int fire2Y = 2000;
	Boolean bool1=false;
	Boolean bool2=false;
	Velocity player1;
	Velocity proj1;
	Velocity player2;
	Velocity proj2;
	Circle projCircle1 = null;
	Circle projCircle2 = null;
	int playerhit1=0;
	int playerhit2=0;
	boolean CanBeHit1 =true;
	boolean CanBeHit2 =true;
	public String player1Score = "0";
	public String player2Score = "0";
	public String winner = "";
	TrueTypeFont font;
	static boolean dogepossible;
	static boolean cagepossible;
    private Audio music;
	static boolean musicCheck=true;
    private Audio wow;
    private Audio shoot;
	static boolean shootCheck=true;
    private Audio shoot2;
	static boolean shootCheck2=true;
    private Audio hit;
	static boolean hitCheck=true;
	int hitx1=2000;
	int hitx2=2000;
	int hity1=2000;
	int hity2=2000;
	int tiex =2000;
	int tiey =2000;
	
	public Map2(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		land = new Image("paradise.png");
		chicken1= new Image("chickun1.png");
	    chicken2= new Image("chickun2.png");
		fire1= new Image("fure.png");
		fire2= new Image("fure.png");
		hit1= new Image("boom.png");
		hit2= new Image("boom.png");
		hud= new Image("hud.png");
		wnner= new Image("wnner.png");
		win1= new Image("1win.png");
		win2= new Image("2win.png");
		player1 = new Velocity(play1X, play1Y, Vel1X, Vel1Y);
		player2 = new Velocity(play2X, play2Y, Vel2X, Vel2Y);
		
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("game_over.ttf");
	 
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(84f); // set font size
			font = new TrueTypeFont(awtFont, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		try {
	        shoot = AudioLoader.getAudio("OGG", new FileInputStream("src/fire.ogg"));
        } catch (IOException e) {e.printStackTrace();}
		try {
	        shoot2 = AudioLoader.getAudio("OGG", new FileInputStream("src/fire.ogg"));
        } catch (IOException e) {e.printStackTrace();}
		try {
	        hit = AudioLoader.getAudio("OGG", new FileInputStream("src/hit.ogg"));
        } catch (IOException e) {e.printStackTrace();}
	}
	
	public static void secondinit() 
			throws SlickException{
		if(dogepossible==true) 
		    chicken1= new Image("doge.png");
		else if (dogepossible==false)
		    chicken1= new Image("chickun1.png");
		if(cagepossible==true)
		    chicken2= new Image("cage.png");
		else if (cagepossible==false)
		    chicken2= new Image("chickun2.png");
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setFont(font); 
		g.setColor(Color.cyan);
		land.draw(0, 0, gc.getWidth(), gc.getHeight());
		if(dogepossible)
		chicken1.draw(play1X, play1Y, gc.getWidth()/18, gc.getHeight()/8);
		else
		chicken1.draw(play1X, play1Y, gc.getWidth()/9, gc.getHeight()/8);
		chicken2.draw(play2X, play2Y, gc.getWidth()/18, gc.getHeight()/8);
		if(CanBeHit2==true)
		fire1.draw(fire1X, fire1Y);
		if(CanBeHit1==true)
		fire2.draw(fire2X, fire2Y);
		hit1.draw(hitx1,hity1);
		hit2.draw(hitx2,hity2);
		g.drawString("" + playerhit1, 620, 720);
		g.drawString("" + playerhit2, 915, 720);
		g.drawString("You both tied!", tiex, tiey);
		win1.draw(win1x, win1y);
		win2.draw(win2x,win2y);
		wnner.draw(winx, winy);
		hud.draw(0,0,gc.getWidth(), gc.getHeight());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if(musicCheck){
			try {
		        music = AudioLoader.getAudio("OGG", new FileInputStream("src/icu.ogg"));
		        } catch (IOException e) {
		        e.printStackTrace();
		    }
			music.playAsSoundEffect(1.0f, 1.0f, false);
			musicCheck=false;
			}
			else{}
		//attempt to create sound for shooting
		
		Input input = gc.getInput();
		projCircle1= new Circle(fire1X+25, fire1Y+25, 40);
		projCircle2= new Circle(fire2X+25, fire2Y+25, 40);
		
		//
		//PLAYER 1
		player1.CalcPosPlay1(gc);
		play1X=player1.posX();
		play1Y=player1.posY();
		if(input.isKeyDown(Input.KEY_T)){
			shootCheck=true;
			bool1=true; 
			fire1X=play1X+90;
			fire1Y=play1Y;
			projCircle1= new Circle(fire1X, fire1Y, 40);
			proj1 = new Velocity(fire1X, fire1Y, 20, -2);
		}
		
		if(bool1==true && !(input.isKeyDown(Input.KEY_T))){
			if(shootCheck==true){
					shoot.playAsSoundEffect(1.0f, 1.0f, false);
				shootCheck=false;
			}
		proj1.CalcProj();
		projCircle1= new Circle(fire1X, fire1Y, 40);
		fire1X=proj1.posX();
		fire1Y=proj1.posY();
		}
		//END OF PLAYER 1
		//
		
		//
		//PLAYER 2
		player2.CalcPosPlay2(gc);
		play2X=player2.posX();
		play2Y=player2.posY();
		if(input.isKeyDown(Input.KEY_NUMPAD0)){
			bool2=true;
			fire2X=play2X+10;
			fire2Y=play2Y;
			projCircle2= new Circle(fire2X, fire2Y, 40);
			proj2 = new Velocity(fire2X, fire2Y, -20, -2);
			shootCheck2=true;
		}
		
		if(bool2==true && !(input.isKeyDown(Input.KEY_NUMPAD0))){
			if(shootCheck2==true){	
				shoot2.playAsSoundEffect(1.0f, 1.0f, false);
				shootCheck2=false;
			}
			proj2.CalcProj();
			projCircle2= new Circle(fire2X+25, fire2Y+25, 40);
			fire2X=proj2.posX();
			fire2Y=proj2.posY();
		}
		//END OF PLAYER 2
		//
		
		//player 1 collision detector
		if(projCircle1.contains(play2X+20, play2Y+30) && CanBeHit2==true){
			playerhit1++;
			player2.VelY=-40;
			CanBeHit2=false;
			hit.playAsSoundEffect(1.0f, 1.0f, false);
			hitx1=fire1X;
			hity1=fire1Y;
		}
		
		if(!(projCircle1.contains(play2X+20, play2Y+30) && CanBeHit2==false)){
			hitx1=2000;
			hity1=2000;
			CanBeHit2=true;
		}
		
		//player 2 collision detector
		if(projCircle2.contains(play1X+100, play1Y+30) && CanBeHit1==true){
			playerhit2++;
			player1.VelY=-40;
			CanBeHit1=false;
			hit.playAsSoundEffect(1.0f, 1.0f, false);
			hitx2=fire2X;
			hity2=fire2Y;
		}
		
		if(!(projCircle2.contains(play1X+100, play1Y+30) && CanBeHit1==false)){
			hitx2=2000;
			hity2=2000;
			CanBeHit1=true;
		}
		
		//check for win
		if((playerhit1)>9 && winx==2000){
			if(playerhit2>9 && winx==2000){
				win2x=675;
				win2y=700;
				tiex=675;
				tiey=100;
			}
			winx=675;
			winy=300;
			win1x=675;
			win1y=650;
			if(dogepossible){
				try {
			        wow = AudioLoader.getAudio("OGG", new FileInputStream("src/wow.ogg"));
			        } catch (IOException e) {
			        e.printStackTrace();
			    }
				wow.playAsSoundEffect(1.0f, 1.0f, false);
			}
		}
		else if(playerhit2>9 && winx==2000){
			winner = "Player 2 wins!";
			winx=675;
			winy=300;
			win2x=675;
			win2y=650;
		}
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			music.stop();
			musicCheck=true;
			playerhit1=0;
			playerhit2=0;
			winner="";
			hitx1=2000;
			hitx2=2000;
			hity1=2000;
			hity2=2000;
			tiex =2000;
			tiey =2000;
			winx=2000;
			winy=2000;
			win1x=2000;
			win1y=2000;
			win2x=2000;
			win2y=2000;
			play1X=450;
			play1Y=400;
			Vel1X=0;
			Vel1Y=0;
			play2X=900;
			play2Y=400;
			Vel2X=0;
			Vel2Y=0;
			fire1X = 2000;
			fire1Y = 2000;
			fire2X = 2000;
			fire2Y = 2000;
			bool1=false;
			bool2=false;
			sbg.enterState(Barnacle.opening1);
		}
	}

	@Override
	public int getID() {
		return this.state;
	}
}