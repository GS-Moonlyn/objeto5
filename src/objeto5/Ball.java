package objeto5;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Ball extends Polygon {
	
	int uLeftXPos, uLeftYPos;
	
	int xDirection = 1;
	int yDirection = 1;
	
	int ballWidth = 26;
	int ballHeight = 31;
	
	int width = Board.boardWidth;
	int height = Board.boardHeight;
	
	int[] polyXArray, polyYArray;
	
	public static int[] sPolyXArray = {10, 17, 26, 34, 27, 36, 26, 14, 8, 1, 5, 1, 10};
	public static int[] sPolyYArray = {0, 5, 1, 8, 13, 20, 31, 28, 31, 22, 16, 7, 0};

	static ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public Ball(int[] polyXArray, int[] polyYArray, int pointsInPoly, int randomStartXPos, int randomStartYPos) {
		
		super(polyXArray, polyYArray, pointsInPoly);
		
		this.xDirection = (int) (Math.random() * 4 + 1);
		this.yDirection = (int) (Math.random() * 4 + 1);
		
		this.uLeftXPos = randomStartXPos;
		this.uLeftYPos = randomStartYPos;
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(super.xpoints[0], super.ypoints[0], ballWidth, ballHeight);
	}
	
	public void move() {
		
		Rectangle ballToCheck = this.getBounds();
		
		for(Ball ball : balls) {
			
			Rectangle otherBall = ball.getBounds();
			
			if(ball != this && otherBall.intersects(ballToCheck)) {
				
				int tempXDirection = this.xDirection;
				int tempYDirection = this.yDirection;
				
				this.xDirection = ball.xDirection;
				this.yDirection = ball.yDirection;
				
				ball.xDirection = tempXDirection;
				ball.yDirection = tempYDirection;				
			}
		}
		
		int uLeftXPos = super.xpoints[0];
		int uLeftYPos = super.ypoints[0];
		
		if (uLeftXPos < 0 || (uLeftXPos + 25) > width) xDirection = -xDirection;
		if (uLeftYPos < 0 || (uLeftYPos + 50) > height) yDirection = -yDirection;
		
		for(int i = 0; i < super.xpoints.length; i++) {
			
			super.xpoints[i] += xDirection;
			super.ypoints[i] += yDirection;
		}
		
	}
	
	public static int[] getpolyXArray(int randomStartXPos) {
		
		int[] tempPolyXArray = (int[])sPolyXArray.clone();
		
		for(int i = 0; i < tempPolyXArray.length; i++) {
			
			tempPolyXArray[i] += randomStartXPos;
		}
		
		return tempPolyXArray;
		
	
			}
	
	public static int[] getpolyYArray(int randomStartYPos) {
		
		int[] tempPolyYArray = (int[])sPolyYArray.clone();
		
		for(int i = 0; i < tempPolyYArray.length; i++) {
			
			tempPolyYArray[i] += randomStartYPos;
	}
		
		return tempPolyYArray;
}
	
}
