import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Map1 extends BasicGameState {
	Image land;
	private int state;

	public Map1(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		land = new Image("bg.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		land.draw(0, 0, gc.getWidth(), gc.getHeight());
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
