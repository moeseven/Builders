package world;

import pathfinding.PathfinderField;

public class Cube implements PathfinderField{
	protected Point3D position;
	protected int fill; //percentage of cube filled with material e.g. dirt
	protected boolean marked = false;
	protected int base_movement_cost = 50;
	
	/*
	 * x,y,z position of cube
	 * fill is percentage of material in the cube
	 */
	public Cube(Point3D position, int fill) {
		super();
		this.position = position;
		this.fill = fill;
	}
	
	public boolean enter(MoveableEntityInWorld entity) {
		return true;
	}
	
	//interface PathfinderField
	@Override
	public boolean is_pathable() {
		if (fill>0) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public int get_path_cost() {
		// TODO terrain specific cost
		return base_movement_cost;
	}
	
	public String toString() {
		return "[" + this.getPosition().x + "|" + this.getPosition().y + "|" + this.getPosition().z + "]";
	}
	///
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

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	
	
	
	
	
	
	
	
	
}
