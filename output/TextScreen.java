package pl.codeme.output;

import pl.codeme.exception.InvalidCharException;
import pl.codeme.exception.OutOfScreenException;

public class TextScreen extends Screen {

	public TextScreen(int width, int height) {
		super(width, height);
		
	}
	
	public void textScreen(int x, int y, String text) throws OutOfScreenException, InvalidCharException{
		if(y >= super.height || x >= super.width - text.length()) 
			throw new OutOfScreenException();
		for(int i  = 0; i < text.length(); i++){
			super.screen[x+i][y].set(text.toCharArray()[i]);
		}
	}
}
