import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class StartMenu extends BasicGameState{
	
	private int state;
    MenuControl MenuManager;
    MenuClick Click;
    InputGetter get = new InputGetter();
	
	public StartMenu(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		MenuManager = new MenuControl();
		MenuManager.initLevel();
		MenuManager.initMain();
		Click = new MenuClick();
}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException{
		if(MenuManager.getGameType()==0)
			MenuManager.menuSelect(gc,sbg,g);
		else if(MenuManager.getGameType()==1)
			MenuManager.levelSelect(gc,sbg,g);
		get.getKey();
		get.getChar();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		if(MenuManager.getGameType()==0)
			MenuManager.menuUpdate(gc, sbg, delta);
		else if(MenuManager.getGameType()==1)
			MenuManager.levelUpdate(gc, sbg, delta);
	}

	public void mousePressed(int button, int x, int y){
		if(MenuManager.getGameType()==0)
			Click.MainClick(button, x, y);
		else if(MenuManager.getGameType()==1)
			Click.LevelClick(button, x, y);
	}
	
	@Override
	public int getID(){
		return this.state;
	}
}