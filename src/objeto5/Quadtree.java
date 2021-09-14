package objeto5;

import java.util.ArrayList;
import java.util.List;

public class Quadtree {

	private static final int MAX_POINTS = 3;
	private Boundary boundary;
	private List <Point> points = new ArrayList<>();
	private List <Quadtree> quadtrees = new ArrayList<>();
	
	public Quadtree(Boundary boundary) {
		this.boundary = boundary;
	}
	
	public boolean addPoint(Point point) {
		if(this.boundary.hasPoint(point)) {
			if(this.points.size() < MAX_POINTS) {
				this.points.add(point);
				return true;
			}
		else {
			if(this.quadtrees.size() == 0) {
				createQuadrant();
			}
			return addPointToQuadrant(point);
		}
	}
		return false;
	}
	
	private boolean addPointToQuadrant(Point point) {
		boolean pointAdded;
		for(int i = 0; i < 4; i++) {
			pointAdded = this.quadtrees.get(i).addPoint(point);
			if(pointAdded) {
				return true;
			}		
		}
		return false;
	}
	
	private void createQuadrant() {
		Boundary bound;
		for (int i = 0; i < 4; i++) {
			bound = this.boundary.getQuadrant(i);
			quadtrees.add(new Quadtree(bound));
		}
	}
}
