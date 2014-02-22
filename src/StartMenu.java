import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class StartMenu extends BasicGameState{
	
	private int state;
    MenuControl MenuManager;
	
	public StartMenu(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		MenuManager = new MenuControl();
		MenuManager.initLevel();
		MenuManager.initMain();
}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException{
		if(MenuManager.getGameType()==0)
			MenuManager.menuSelect(gc,sbg,g);
		else if(MenuManager.getGameType()==1)
			MenuManager.levelSelect(gc,sbg,g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		if(MenuManager.getGameType()==0)
			MenuManager.menuUpdate(gc, sbg, delta);
		else if(MenuManager.getGameType()==1)
			MenuManager.levelUpdate(gc, sbg, delta);
		InputGetter get = new InputGetter();
		if(Keyboard.next()){
		System.out.println("The last key (int) pressed was " + get.getKey());
		System.out.println("The last key(char) pressed was " + get.getChar());
		}
	}
	
	@Override
	public int getID(){
		return this.state;
	}
}