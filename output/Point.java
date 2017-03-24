package pl.codeme.output;

import pl.codeme.exception.InvalidCharException;

public class Point {

	private char content;
	
	public Point(char content) throws InvalidCharException{
	//	this.content = content;
		set(content); //bo ³atwiejsza walidacja
	}

	public char get() {
		return content;
	}

	public void set(char content) throws InvalidCharException {
		if(content == '\n' || content == '\r' || content == '\t')
			throw new InvalidCharException();
		this.content = content;
	}
	
	
}
