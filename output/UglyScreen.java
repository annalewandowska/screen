package pl.codeme.output;
import java.util.HashMap;
import pl.codeme.exception.InvalidCharException;
import pl.codeme.exception.OutOfScreenException;

//narysowaæ liniê ukoœn¹ (5 parametrów) i ko³o - znaleŸæ algorytm
public class UglyScreen {
		
		private HashMap<String, Point> screen = new HashMap<>();
		
	//	protected Point screen[][];
		protected int height;
		protected int width;
		
		public UglyScreen(int width, int height){
			this.height = height;
			this.width = width;
			
			//screen = new Point[width][height];
			
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++){
					try {
						String key = j + "*" + i;
						screen.put(key, new Point('.'));
					} catch (InvalidCharException e) {}
				}
			}
			
		}
		
		public void drawPoint(int x, int y, char chr) throws OutOfScreenException, InvalidCharException{
			if(y >= height || x >= width) 
				throw new OutOfScreenException();
			String key = x + "*" + y;
			screen.get(key).set(chr);
		}
		
//		//rysuje liniê ukoœn¹ ale tylko przek¹tn¹ kwadratu
//		public void drawDiagonalLine(int x1, int y1, int x2, int y2, char chr)
//					throws OutOfScreenException, InvalidCharException{
//			if(y1 >= height || x1 >= width || y2 >= height || x2 >= width) 
//				throw new OutOfScreenException();
//			for(int i = y1, j = x1; i <= y2  && j <= x2; i++, j++){	
//				screen[i][j].set(chr);
//			}
//		}
//		
//		//rysuje liniê ukoœn¹ 
//		public void drawDiagonal(int x1, int y1, int x2, int y2, char chr)
//				throws OutOfScreenException, InvalidCharException{
//			if(y1 >= height || x1 >= width || y2 >= height || x2 >= width) 
//				throw new OutOfScreenException();
//			
//			double q = ((double)(y2 - y1)/(double)(x2 - x1));
//			
//			if(Math.abs(x2 - x1) > Math.abs(y2 - y1)){
//				for(int j = x1; j <= x2 ; j++ ){	
//					screen[j][y1 + (int)Math.round((q*j))].set(chr);
//				}	
//			}
//			if(Math.abs(x2 - x1) < Math.abs(y2 - y1)){		
//				for(int i = y1, j = x1; i <= y2  && j <= x2 ; j++ ){	
//					screen[i + (int)Math.round((q*j))][j].set(chr);
//				}
//			} else {
//				for(int i = y1, j = x1; i <= y2  && j <= x2; i++, j++){	
//					screen[i][j].set(chr);
//				}
//			}
//		}
	
		
		public HashMap<String, Point> getScreen(){
			return screen;
		}
		
		public int getHeight(){
			return height;
		}
		public int getWidth(){
			return width;
		}
}
