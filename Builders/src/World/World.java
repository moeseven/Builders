package World;

public class World {
	private Cube[][][] playable_area;
	private Creature[] creatures;
	private int x_size,y_size,z_size;
	
	public World(int x_size, int y_size, int z_size) {
		super();
		this.playable_area = new Cube[x_size][y_size][z_size];
		this.x_size = x_size;
		this.y_size = y_size;
		this.z_size = z_size;
		generate_cubes();
	}
	
	private void generate_cubes(){
		for (int x = 0; x < x_size; x++) {
			for (int y = 0; y < y_size; y++) {
				for (int z = 0; z < z_size; z++) {
					playable_area[x][y][z]= new Cube(x, y, z, 0);
				}
			}
		}
	}
	
	/*
	 * returns the cube of the specified position in the world
	 * returns null if parameters reach outside of the world
	 */
	public Cube getCube(int x, int y, int z) {
		if ((0 <= x) && (x < x_size)) {
			if ((0 <= y) && (y < y_size)) {
				if ((0 <= z) && (z < z_size)) {
					return playable_area[x][y][z];
				}
			}
		}
		return null;
	}
	
	/*
	 * returns the cube the creature is at
	 */
	public Cube getCube(Creature creature) {
		return getCube(creature.getX(), creature.getY(), creature.getZ());
	} 
}
