package pl.codeme.output;

import pl.codeme.exception.InvalidCharException;
import pl.codeme.exception.OutOfScreenException;

public class Screen {

		protected Point screen[][];
		protected int height;
		protected int width;
		
		public Screen(int width, int height){
			this.height = height;
			this.width = width;
			
			screen = new Point[width][height];
			
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++){
					try {
						screen[j][i] = new Point('.');
					} catch (InvalidCharException e) {}
				}
			}
		}
		
		public void drawPoint(int x, int y, char chr) throws OutOfScreenException, InvalidCharException{
			if(y >= height || x >= width) 
				throw new OutOfScreenException();
			screen[x][y].set(chr);
		}
		
		//rysuje liniê ukoœn¹ ale tylko przek¹tn¹ kwadratu
		public void drawDiagonalLine(int x1, int y1, int x2, int y2, char chr)
					throws OutOfScreenException, InvalidCharException{
			if(y1 >= height || x1 >= width || y2 >= height || x2 >= width) 
				throw new OutOfScreenException();
			if((x2 > x1 && y2 < y1)){
				for(int i = x1, j = y1; i <= x2  && j >= y2; i++, j--){	
					screen[i][j].set(chr);
				}
			}
			if((x2 < x1) && (y2 > y1)){
				for(int i = x1, j = y1; i >= x2  && j <= y2; i--, j++){	
					screen[i][j].set(chr);
				}
			}
			if(x2 > x1 && y2 > y1){	
				for(int i = y1, j = x1; i <= y2  && j <= x2; i++, j++){	
					screen[i][j].set(chr);
				}
			}
			if(x2 < x1 && y2 < y1){	
				for(int i = y1, j = x1; i >= y2  && j >= x2; i--, j--){	
					screen[i][j].set(chr);
				}
			}
		}
		
		//rysuje liniê ukoœn¹ 
		public void drawDiagonal(int x1, int y1, int x2, int y2, char chr)
				throws OutOfScreenException, InvalidCharException{
			if(y1 >= height || x1 >= width || y2 >= height || x2 >= width) 
				throw new OutOfScreenException();
			
			int dx = Math.abs(x2 - x1);
			int dy = Math.abs(y2 - y1);		
			/*double q = ((double)(dy)/(double)(dx));*/
			double q = (double)(y2-y1)/(double)(x2 - x1);
			
			//if(dx == dy) {
			//	drawDiagonalLine(x1, y1, x2, y2, chr);
			//} 
			
			if( dx > dy ) {
				if( x1 < x2 ){
					for(int j = x1; j <= x2 ; j++) {
						screen[j][ y1 + (int)(q*j) ].set(chr);
					}
				}
				else {
					for(int j = x2; j <= x1 ; j++) {
						screen[j][ y2 + (int)(q*j) ].set(chr);
					}
				}
			} 
			else {
				if( y1 < y2 ) {
					for(int j=y1; j<= y2; j++){
						screen[ x1 + (int)(j/q) ][j].set(chr);
					}
				}
				else {
					for(int j=y2; j<= y1; j++){
						screen[ x2 + (int)(j/q) ][j].set(chr);
					}
				}
			}

		}
		
		
		public Point[][] getScreen(){
			return screen;
		}
		
		public int getHeight(){
			return height;
		}
		public int getWidth(){
			return width;
		}
}
