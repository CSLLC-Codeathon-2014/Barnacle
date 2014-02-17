import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;

public class VelocityAI {
	int posX;
	int posY;
	int VelX;
	int VelY;
    private Audio jump;
    boolean inputSpace=false;
    int direction=0;
    final int none=0;
    final int left =1;
    final int right=2;
    long AiTimer=0;
    boolean shootTime2=false;
    boolean shootTime=false;
    
	public VelocityAI(int posX2, int posY2, int velX2,int velY2) 
	{
	 posX=posX2;
	 posY=posY2;
	 VelX=velX2;
	 VelY=velY2;
	}
	
	public void AiInput(){
		AiTimer++;
		if(AiTimer%10==0){
			if(randInt(0, 50)>35)
			inputSpace=true;
		}
		if(AiTimer%120==0){
			direction=1;
		}
		else if(AiTimer%80==0){
			direction=2;
		}
		else if(AiTimer%40==0){
			direction= 0;
		}
		if(shootTime2){
			shootTime=true;
			shootTime2=false;
		}
		else
			shootTime=false;
	}
	
	public void LocationChecker(int loc1,int loc2){
		if(((loc2-loc1)>-10) && ((loc2-loc1)<20)){
			shootTime2=true;
		}
	}
	
	public void CalcPosAI(GameContainer gc){
		if (direction<0 || direction>2){
			direction=0;
			System.out.println("Your AI is messing up! direction is " + direction);
		}
		//colliding with walls and floors
		//top of rock
		if(posY>=(gc.getHeight()/36*21) && posY<(gc.getHeight()/18*12) && posX>(gc.getWidth()/7) && posX<(gc.getWidth()/16*12)){
			posY=(gc.getHeight()/36*21);
			VelY=0;
		}
		//left side of rock
		if(posY>(gc.getHeight()/36*21) && posX<(gc.getWidth()/7) && posX>(gc.getWidth()/8)){
			posX=(gc.getWidth()/8);
		}
		//right side of rock
		if(posY>(gc.getHeight()/36*21) && posX>(gc.getWidth()/16*11) && posX<(gc.getWidth()/16*12)){
			posX=(gc.getWidth()/16*12);
		}
		//right wall
		if(posX>gc.getWidth()-(gc.getWidth()/16)){
			posX=(gc.getWidth()-(gc.getWidth()/16));
		}
		//left wall
		if(posX<-50){
			posX=-50;
		}
		//ground
		if(posY>(gc.getHeight()-50)){
			posY=(gc.getHeight()-50);
			VelY=0;
		}
		//cieling
		if(posY<-20){
			posY=-20;
		}
		//end of the boundaries
		

				
		if(inputSpace){
			if(VelY<5 && VelY>-25){
			VelY=20;
			
			try {
		        jump = AudioLoader.getAudio("OGG", new FileInputStream("src/jump2.ogg"));
		        } catch (IOException e) {
		        e.printStackTrace();
		    }
			jump.playAsSoundEffect(1.0f, 1.0f, false);
			
			}
			inputSpace=false;
		}
		VelY--;
		if(VelY>20)
		VelY=20;
		if(VelY<-20)
			VelY-=2;
		if(VelY<-40)
			VelY=-40;
		if(direction==left){
		if(VelX>1)
			VelX=1;
		VelX-=2;
		}
		if(direction==right){
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
		
		posY=posY-VelY;
		posX=posX+VelX;
	}
	
	public int posX(){
		return posX;
	}
	
	public int posY(){
		return posY;
	}

	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}