import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class StartMenu extends BasicGameState{
	
	private int state;
    MenuRender MenuManager;
    InputGetter get = new InputGetter();
    int width;
    int height;
    boolean setWidth= true;
	
	public StartMenu(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		MenuManager = new MenuRender();
		MenuManager.initLevel();
		MenuManager.initMain();
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException{
		if(setWidth){
			width=gc.getWidth();
			height=gc.getHeight();
			MenuManager.initClick(sbg, width, height);
			setWidth=false;
		}
		if(MenuManager.getMenuType()==0)
			MenuManager.menuSelect(gc,sbg,g);
		else if(MenuManager.getMenuType()==1)
			MenuManager.levelSelect(gc,sbg,g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		if(MenuManager.getMenuType()==0)
			MenuManager.menuUpdate(gc, sbg, delta);
		else if(MenuManager.getMenuType()==1)
			MenuManager.levelUpdate(gc, sbg, delta);
	}
	
	public void mouseClicked(int button, int x, int y, int clickCount){
		if(MenuManager.getMenuType()==0)
			MenuManager.MainClick(button, x, y);
		else if(MenuManager.getMenuType()==1){
			try {
				MenuManager.LevelClick(button, x, y);
			} 
			catch (SlickException e){e.printStackTrace();}
		}
	}
	
	@Override
	public int getID(){
		return this.state;
	}
}