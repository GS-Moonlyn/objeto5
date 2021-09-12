package objeto5;

public class mainApp {
private Rectangle boundary = new Rectangle (200, 200, 200, 200);
private QuadTree qt = new QuadTree (boundary);

for (int i = 0; i < 1; i++) {
	Point p = new Point ((int)Math.floor(Math.random()*(200-0+1)+0),(int)Math.floor(Math.random()*(200-0+1)+0));
	
	
	qt.insert();
 }
}
