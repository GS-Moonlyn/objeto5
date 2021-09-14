package objeto5;

public class Boundary {

	private float x1;
	private float x2;
	private float y1;
	private float y2;
	
	public Boundary(float x1, float y1, float x2, float y2) {		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public boolean hasPoint(Point point) {
		return point.getX() >= this.x1
			&& point.getX() < this.x2
			&& point.getY() >= this.y1
			&& point.getY() < this.x2;
	}
	
	public boolean isOverlapping(Boundary bound) {
		if(bound.getX2() < this.getX1()) {
			return false;
		}
		
		if(bound.getX1() > this.getX2()) {
			return false;
		}
		
		if(bound.getY1() > this.getY2()) {
			return false;
		}
		
		if(bound.getY2() < this.getY1()) {
			return false;
		}	
		return true;
	}
	
	public Boundary getQuadrant (int quadrantIndex) {
		float quadrantWidth = (this.x2 - this.x1) / 2;
		float quadrantHeight = (this.y2 - this.y1) / 2;
		
		switch(quadrantIndex) {
		//SW
		case 0:
			return new Boundary(x1, y1, x1 + quadrantWidth, y1 + quadrantHeight);
		//NW
		case 1:
			return new Boundary(x1, y1 + quadrantHeight, x1 + quadrantWidth, y2);
		//NE
		case 2:
			return new Boundary(x1 + quadrantWidth, y1 + quadrantHeight, x2, y2);
		//SE
		case 3:
			return new Boundary(x1 + quadrantWidth, y1, x2, y1 + quadrantHeight);
		}	
		return null;	
	}
	
	public float getX1() {return x1;}
	
	public float getX2() {return x2;}
	
	public float getY1() {return y1;}

	public float getY2() {return y2;}
	
	public void setX1(float x1) {this.x1 = x1;}
	
	public void setX2(float x2) {this.x2 = x2;}
	
	public void setY1(float y1) {this.y1 = y1;}
	
	public void setY2(float y2) {this.y2 = y2;}
	
}
