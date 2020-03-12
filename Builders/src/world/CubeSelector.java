package world;

public class CubeSelector extends MoveableEntityInWorld{
	private Cube last_cube; //so you can move into walls with a depth of 1
	
	public CubeSelector(World world, Point3D position) {
		super(world, position);
		last_cube = world.getCube(position);
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
}
