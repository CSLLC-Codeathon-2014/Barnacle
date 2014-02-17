import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.*;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;

public class Velocity {
	int posX;
	int posY;
	int VelX;
	int VelY;
    private Audio jump;
	public Velocity(int posX2, int posY2, int velX2,int velY2) 
	{
	 posX=posX2;
	 posY=posY2;
	 VelX=velX2;
	 VelY=velY2;
	}
	
	public void CalcPosPlay1(GameContainer gc){
		Input input = gc.getInput();
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
		if(posX>gc.getWidth()-(gc.getWidth()/8)){
			posX=(gc.getWidth()-(gc.getWidth()/8));
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
		
		//jumping
		if(input.isKeyDown(Input.KEY_SPACE)){
			if(VelY<5 && VelY>-25){
			VelY=20;
			
			try {
		        jump = AudioLoader.getAudio("OGG", new FileInputStream("src/jump1.ogg"));
		        } catch (IOException e) {
		        e.printStackTrace();
		    }
			jump.playAsSoundEffect(1.0f, 1.0f, false);
			
			}
		}
		VelY--;
		if(VelY>20)
		VelY=20;
		if(VelY<-20)
			VelY-=2;
		if(VelY<-40)
			VelY=-40;
			
		if(input.isKeyDown(Input.KEY_A)){
		if(VelX>1)
			VelX=1;
		VelX-=2;
		}
		if(input.isKeyDown(Input.KEY_D)){
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
	public void CalcPosPlay2(GameContainer gc){
		Input input2 = gc.getInput();
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
		if(posX<0){
			posX=0;
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
		
		if(input2.isKeyDown(Input.KEY_NUMPAD8)){
			if(VelY<5 && VelY>-25){
			VelY=20;
			
			try {
		        jump = AudioLoader.getAudio("OGG", new FileInputStream("src/jump2.ogg"));
		        } catch (IOException e) {
		        e.printStackTrace();
		    }
			jump.playAsSoundEffect(1.0f, 1.0f, false);
			
			}
		}
		VelY--;
		if(VelY>20)
		VelY=20;
		if(VelY<-20)
			VelY+=2;
		if(VelY<-30)
			VelY=-40;
		if(input2.isKeyDown(Input.KEY_NUMPAD4)){
		if(VelX>1)
			VelX=1;
		VelX-=2;
		}
		if(input2.isKeyDown(Input.KEY_NUMPAD6)){
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
	
	public void CalcProj(){
		posY=posY-VelY;
		posX=posX+VelX;
	}
	
	public int posX(){
		return posX;
	}
	
	public int posY(){
		return posY;
	}
}