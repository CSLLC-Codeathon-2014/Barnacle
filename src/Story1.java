import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Story1 extends BasicGameState {
	private int state;
	int i; 

	public Story1(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_SPACE)){
			
		}
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