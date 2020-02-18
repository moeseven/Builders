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
		init();
	}
	public void init() {
		x = y = z = 0;
		accumulated_movepoints = 0;
	}
	public boolean move(char direction) {
		// should take direction parameter
		Cube target_of_movement;
		switch (direction) {
		case 'u': //up
			target_of_movement = world.getCube(x, y, z+1);
			return enter_cube(target_of_movement);
		case 'd': //down
			target_of_movement = world.getCube(x, y, z-1);
			return enter_cube(target_of_movement);
		case 'n': //north
			target_of_movement = world.getCube(x, y+1, z);
			return enter_cube(target_of_movement);
		case 'e': //east
			target_of_movement = world.getCube(x+1, y, z);
			return enter_cube(target_of_movement);
		case 's': //south
			target_of_movement = world.getCube(x, y-1, z);
			return enter_cube(target_of_movement);
		case 'w': //west
			target_of_movement = world.getCube(x-1, y, z);
			return enter_cube(target_of_movement);
		default:
			throw new java.lang.RuntimeException("faulty call of method!");
		}
	}
	
	private boolean enter_cube(Cube cube) {
		if (cube != null) {
			if (cube.enter(this)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * for testing
	 */
	public void output_position_on_console() {
		Cube position = world.getCube(this);
		String console_output = "position: ";
		console_output += "x: " + position.getX();
		console_output += "|y: " + position.getY();
		console_output += "|z: " + position.getZ();
		System.out.println(console_output);
	}
	
	
	//getters and setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAccumulated_movepoints() {
		return accumulated_movepoints;
	}
	public void setAccumulated_movepoints(int accumulated_movepoints) {
		this.accumulated_movepoints = accumulated_movepoints;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	
	
	
}
