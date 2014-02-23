import org.lwjgl.input.Keyboard;

public class InputGetter {
	
	int lastInput;
	int currInput;
	char lastChar;
	char currChar;
	
	public InputGetter(){
	currInput=0;
	lastInput=0;
	lastChar='a';
	currChar='a';
	}
	
	public int getKey(){
		currInput = Keyboard.getEventKey();
		if(currInput!=lastInput)
			System.out.println(currInput);
		lastInput=currInput;
		return currInput;
	}
	
	public char getChar(){
		currChar = Keyboard.getEventCharacter();
		if(currChar!=lastChar)
			System.out.println(currChar);
		lastChar=currChar;
		return lastChar;
	}

}
