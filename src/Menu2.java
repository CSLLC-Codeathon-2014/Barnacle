import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu2 extends BasicGameState{

	private int state;

	public Menu2(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame bar)
			throws SlickException {
	}

	@Override
	public void render(GameContainer gc, StateBasedGame bar, Graphics g)
			throws SlickException {
	}

	@Override
	public void update(GameContainer gc, StateBasedGame bar, int delta)
			throws SlickException {	
	}

	@Override
	public int getID() {
		return this.state;
	}

}
