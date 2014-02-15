import org.newdawn.slick.*;

public class Velocity {
	int posx;
	int posy;
	int chickX;
	int chickY;
	int VelX;
	int VelY;
	public Velocity(int chickX2, int chickY2, int velX2,int velY2) 
	{
	 chickX=chickX2;
	 chickX=chickY2;
	 VelX=velX2;
	 VelY=velY2;
	}
	public void CalcPos(GameContainer gc){
		Input input = gc.getInput();
		if(chickY>=520 && chickY<635 && chickX>350 && chickX<1250){
			chickY=520;
			VelY=0;
		}
		if(chickY>610 && chickX<600 && chickX>200){
			chickX=200;
		}
		if(chickY>610 && chickX>600 && chickX<1250){
			chickX=1250;
		}
		if(input.isKeyDown(Input.KEY_SPACE)){
			if(VelY<5)
			VelY=20;
		}
		VelY--;
		if(VelY>20)
		VelY=20;
		if(VelY<-20)
			VelY=-20;
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
		
		chickY=chickY-VelY;
		chickX=chickX+VelX;
	}
	
	public void CalcProj(){
		if(chickY>=520 && chickY<635 && chickX>350 && chickX<1250){
			chickY=520;
			VelY=0;
		}
		if(chickY>610 && chickX<600 && chickX>200){
			chickX=200;
		}
		if(chickY>610 && chickX>600 && chickX<1250){
			chickX=1250;
		}
		chickY=chickY-VelY;
		chickX=chickX+VelX;
		
		if(chickX>1600){
			chickX=-40;
			VelX=0;
			VelY=0;
		}
	}
	
	public int posX(){
		return chickX;
	}
	public int posY(){
		return chickY;
	}
	
}