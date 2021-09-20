package objeto5;

import java.util.ArrayList;

public class Quadtree {

	private Rectangle boundary;
	private int depth;
	private int capacity;
	private ArrayList<Point> points = new ArrayList<Point>();
	private boolean isDivided = false;
	Quadtree northeast;
	Quadtree northwest;
	Quadtree southeast;
	Quadtree southwest;
	
	public Quadtree(Rectangle boundary, int capacity, int depth) {	
		this.boundary = boundary;
		this.capacity = capacity;
		this.depth = depth;
	}
	
	public void subdivide() {
		Rectangle nw = new Rectangle(boundary.getX() - boundary.getWidth() / 2, 
									 boundary.getY() - boundary.getHeight() / 2,
									 boundary.getWidth() / 2, boundary.getHeight() / 2);
		northwest = new Quadtree(nw, capacity, depth - 1);
	
		Rectangle ne = new Rectangle(boundary.getX() + boundary.getWidth() / 2, 
									 boundary.getY() - boundary.getHeight() / 2,
									 boundary.getWidth() / 2, boundary.getHeight() / 2);
		northeast = new Quadtree(ne, capacity, depth - 1);
		
		Rectangle sw = new Rectangle(boundary.getX() - boundary.getWidth() / 2, 
				 					 boundary.getY() + boundary.getHeight() / 2,
				 					 boundary.getWidth() / 2, boundary.getHeight() / 2);
		southwest = new Quadtree(sw, capacity, depth - 1);
		
		Rectangle se = new Rectangle(boundary.getX() + boundary.getWidth() / 2, 
				 					 boundary.getY() + boundary.getHeight() / 2,
				 					 boundary.getWidth() / 2, boundary.getHeight() / 2);
		southeast = new Quadtree(se, capacity, depth - 1);
		isDivided = true;
	}	
	
	public void insert(Point pnt) {
		
		if(!this.boundary.contains(pnt)) {
			return;
		} 
		if(this.points.size() < capacity) {
			this.points.add(pnt);
		}
		else {
			if(!isDivided && depth > 0) {
				this.subdivide();
				System.out.println("Entrando na profundidade: " + depth);
				this.points.add(pnt);
				for (Point point : points) {
					this.northeast.insert(point);
					this.northwest.insert(point);
					this.southeast.insert(point);
					this.southwest.insert(point);
				}
				this.points.clear();
			} else {
				this.points.add(pnt);
			}
		}
	}
}
