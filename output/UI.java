package pl.codeme.output;

import java.util.HashMap;

import pl.codeme.exception.InvalidCharException;
import pl.codeme.exception.OutOfScreenException;

public class UI {

	public static void main(String[] args) {
		UI ui = new UI();
		
		Screen screen = new Screen(25,20);
	//	UglyScreen uScreen = new UglyScreen(10,10);
		//	ui.printUglyScreen(uScreen);
		
		try {
		//	screen.drawPoint(0, 2, 'A')
		//	screen.drawDiagonalLine(15, 15, 0, 0, 'x');
		//	screen.drawDiagonal(15, 8 , 4, 2, 'x');
		//	screen.drawDiagonal(5, 10, 0, 0, 'o');
		//	screen.drawDiagonal(10, 0, 1, 5, 'm');
		//	screen.drawDiagonal(1, 1, 11, 5, 'e');  // ok
		//	screen.drawDiagonal(1, 5, 11, 1, 'e'); // ok
		//	screen.drawDiagonal(5, 1, 1, 12, 'e'); // ok
		//	screen.drawDiagonal(4, 11, 1, 2, 'e'); // ok
			screen.drawDiagonal(1, 1, 9, 9, 'e');
		}catch(OutOfScreenException ex){
			System.out.println("Rysujesz poza ekranem");
		}
		catch(InvalidCharException ex){
			System.out.println("Rysujesz z³ym znakiem");
		}
		
		ui.printScreen(screen);
		System.out.println();
		
		TextScreen txt = new TextScreen(10, 10);
		try {
			txt.textScreen(3, 4, "dkfjos");
		} catch (OutOfScreenException e) {
			System.out.println("Rysujesz poza ekranem");
		} catch (InvalidCharException e) {
			System.out.println("Rysujesz z³ym znakiem");
		}
		
		ui.printScreen(txt);

	}
	
	public void printScreen(Screen screen){
		Point[][] points = screen.getScreen();
		for(int i = 0; i < screen.getHeight(); i++){
			for(int j = 0; j < screen.getWidth(); j++){
				System.out.print(points[j][i].get());
			}
			System.out.println();
		}
	}
	public void printUglyScreen(UglyScreen screen){
		HashMap<String, Point> points = screen.getScreen();
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				System.out.print(points.get(i + "*" + j).get());
			}
			System.out.println();
		}
	}
	
	

	
}
