package world;

public abstract class MoveableEntityInWorld {
	protected Point3D position;
	protected World world;

	public MoveableEntityInWorld(World world, Point3D position) {
		super();
		this.world = world;
		this.position = position;
	}
	
	/*
	 * returns the cube the entity is in
	 */
	public Cube getCube() {
		return world.getCube(position);
	} 
	
	/*
	 * enters cube
	 */
	public abstract boolean enter_cube(Cube cube);
	
	/*
	 * move in a direction
	 */
	public boolean move(Direction direction) {
		return enter_cube(world.get_adjacent_cube(getCube(), direction));
	}
	/*
	 * move to cube
	 * only allows moving to adjacent cubes
	 */
	public boolean move(Cube cube) {
		if (world.get_immediatly_accessable_fields(getCube()).contains(cube)) {
			return enter_cube(cube);
		}else {
			return false;
		}
		
	}
	
	//getters and setters
	
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}

	public Point3D getPosition() {
		return position;
	}

	public void setPosition(Point3D position) {
		this.position = position;
	}

	
}
