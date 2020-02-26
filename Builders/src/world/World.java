package world;

public class World {
	private WorldBorderCube world_border;
	private Cube[][][] playable_area;
	private Creature[] creatures;
	private int x_size,y_size,z_size;
	
	public World(int x_size, int y_size, int z_size) {
		super();
		this.playable_area = new Cube[x_size][y_size][z_size];
		this.x_size = x_size;
		this.y_size = y_size;
		this.z_size = z_size;
		world_border = new WorldBorderCube();
		generate_cubes();
	}
	
	private void generate_cubes(){
		for (int x = 0; x < x_size; x++) {
			for (int y = 0; y < y_size; y++) {
				for (int z = 0; z < z_size; z++) {
					playable_area[x][y][z]= new Cube(new Point3D(x,y,z), 0);
				}
			}
		}
	}
	
	/*
	 * returns the cube of the specified position in the world
	 * returns world border if parameters reach outside of the world
	 */
	public Cube getCube(Point3D position) {
		if ((0 <= position.x) && (position.x < x_size)) {
			if ((0 <= position.y) && (position.y < y_size)) {
				if ((0 <= position.z) && (position.z < z_size)) {
					return playable_area[position.x][position.y][position.z];
				}
			}
		}
		return world_border;
	}
	
	/*
	 * returns adjacent cube in the specified direction
	 */
	public Cube get_adjacent_cube(Cube cube, Direction direction) {
		switch (direction) {
		case UP: //up
			return getCube(new Point3D(cube.getPosition().x, cube.getPosition().y, (cube.getPosition().z + 1)));
		case DOWN: //down
			return getCube(new Point3D(cube.getPosition().x, cube.getPosition().y, (cube.getPosition().z - 1)));
		case NORTH: //north
			return getCube(new Point3D(cube.getPosition().x, (cube.getPosition().y + 1), (cube.getPosition().z)));
		case EAST: //east
			return getCube(new Point3D((cube.getPosition().x + 1), cube.getPosition().y, (cube.getPosition().z)));
		case SOUTH: //south
			return getCube(new Point3D(cube.getPosition().x, cube.getPosition().y - 1, (cube.getPosition().z)));
		case WEST: //west
			return getCube(new Point3D((cube.getPosition().x - 1), cube.getPosition().y, (cube.getPosition().z)));
		default:
			throw new java.lang.RuntimeException("faulty call of method!");
		}
	}
}
