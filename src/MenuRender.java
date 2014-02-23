import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MenuRender extends MenuUpdate{
	
	static int posX = Mouse.getX();
    static int posY = Mouse.getY();
	
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
	
	public int getMenuType(){
		return Screen;
	}
}