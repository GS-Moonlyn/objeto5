package objeto5;

public class Rectangle {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
	}
	
	public boolean contains(Point point) {
		return (point.getX() > this.x - this.width &&
				point.getX() < this.x + this.width &&
				point.getY() > this.y - this.height &&
				point.getY() < this.y + this.height);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}