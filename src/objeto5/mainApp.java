package objeto5;

import java.util.Random;

public class mainApp {	
	private static int windowWidth = 400;
	private static int windowHeight = 400;
	public static void main(String[] args) {

        Random rng = new Random();
		Rectangle boundary = new Rectangle(0, 0, windowWidth, windowHeight);
		Quadtree qt = new Quadtree(boundary, 4, 3);
		for (int i = 0; i < 5; i++) {
			// Point p = new Point(rng.nextInt(401), rng.nextInt(401));
			Point p = new Point(rng.nextInt(boundary.getWidth() + 1), 
								rng.nextInt(boundary.getHeight() + 1));
			System.out.println(p.getX() + ", " + p.getY());
			qt.insert(p);
		}
	}
}
