package world;

public class MovableEntityInWorld {
	protected Point3D position;
	protected World world;
	private Cube last_cube; //so you can move into walls with a depth of 1
	public MovableEntityInWorld(World world, Point3D position) {
		super();
		this.world = world;
		this.position = position;
		last_cube = world.getCube(position);
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
	public boolean enter_cube(Cube cube) {
		if (cube !=null) {
			// make it so this can go one step deep into solid cubes
			if (cube.getFill() == 1) {				
				if (this.getCube().getFill() == 0 ) {
					last_cube = this.getCube();
				}else {
					return false;
				}
			}else {
				if (this.getCube().getFill() == 1) {
					//move out of solid cube back to origin of movement
					if (!cube.equals(last_cube)) {
						return false;
					}
				}
			}			
			if (cube.enter(this)) {
				position = cube.getPosition();
				return true;
			}						
		}
		return false;	
	}
	
	/*
	 * move in a direction
	 */
	public boolean move(Direction direction) {
		return enter_cube(world.get_adjacent_cube(getCube(), direction));
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
