import org.lwjgl.input.Keyboard;

public class InputGetter {
	
	int lastInput;
	char lastChar;
	
	public InputGetter(){
	lastInput=0;
	lastChar='a';
	}
	
	public int getKey(){
	if(Keyboard.next())
		lastInput = Keyboard.getEventKey();
	return lastInput;
	}
	
	public char getChar(){
		lastChar = Keyboard.getEventCharacter();
		return lastChar;
	}

}
