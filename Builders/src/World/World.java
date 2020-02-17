package World;

public class World {
	private Cube[][][] playable_area;
	private Creature[] creatures;
	public World(int x_size, int y_size, int z_size) {
		super();
		this.playable_area = new Cube[x_size][y_size][z_size];
		
	}
	
	public Cube getCube(int x, int y, int z) {
		return playable_area[x][y][z];
	}
	
}
