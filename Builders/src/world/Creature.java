package world;

public class Creature extends MovableEntityInWorld{
	
	private int speed;
	private int accumulated_movepoints;
	private int accumulated_workpoints;
	private Direction facing_direction;
	private boolean busy;
	
	public Creature(World world,Point3D position, int speed) {
		super(world, position);
		this.speed = speed;
		init();
	}
	public void init() {
		accumulated_movepoints = 0;
		facing_direction = Direction.DOWN;
	}
	
	
	@Override
	public boolean enter_cube(Cube cube) {
		if (cube !=null) {
			if (cube.fill == 0) {
				if (cube.enter(this)) {
					position = cube.getPosition();
					reset_work_progress();
					return true;
				}
			}						
		}
		return false;
	}
	/*
	 * try to move towards facing direction
	 */
	public boolean move_forward() {
		return enter_cube(world.get_adjacent_cube(getCube(), facing_direction));
	}
	
	
	public void reset_work_progress() {
		accumulated_workpoints = 0;
	}
	
	//getters and setters
	
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

	public Direction getFacing_direction() {
		return facing_direction;
	}
	public void setFacing_direction(Direction facing_direction) {
		this.facing_direction = facing_direction;
	}
	public int getAccumulated_workpoints() {
		return accumulated_workpoints;
	}
	public void setAccumulated_workpoints(int accumulated_workpoints) {
		this.accumulated_workpoints = accumulated_workpoints;
	}
	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	
	
	
}
