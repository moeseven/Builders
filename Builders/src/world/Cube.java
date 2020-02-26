package world;

public class Cube {
	protected Point3D position;
	protected int fill; //percentage of cube filled with material e.g. dirt
	
	/*
	 * x,y,z position of cube
	 * fill is percentage of material in the cube
	 */
	public Cube(Point3D position, int fill) {
		super();
		this.position = position;
		this.fill = fill;
	}
	
	public boolean enter(MovableEntityInWorld entity) {
		return true;
	}
	
	//getters and setters
	public Point3D getPosition() {
		return position;
	}

	public void setPosition(Point3D position) {
		this.position = position;
	}

	public int getFill() {
		return fill;
	}

	public void setFill(int fill) {
		this.fill = fill;
	}
	
	
	
	
	
	
	
	
	
}
