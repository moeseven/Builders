package World;

public class Creature {
	private int x,y,z;
	private int speed;
	private int accumulated_movepoints;
	private World world;
	public Creature(World world, int speed) {
		super();
		this.world = world;
		this.speed = speed;
	}
	public void init() {
		x = y = z = 0;
		accumulated_movepoints = 0;
	}
	public void move() {
		// should take direction parameter
	}
	public boolean enter_cube() {
		return false;
	}
}
