import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Map2 extends BasicGameState {

	private int state;

	public Map2(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}

	@Override
	public int getID() {
		return this.state;
	}

}
