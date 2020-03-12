package world;


public class Creature extends MoveableEntityInWorld implements ClassWithGameTick{
	private static int ACTION_POINT_CAP = 100;
	private int speed;
	private int actionpoints;
	private Direction facing_direction;
	private boolean busy;
	private Cube destination;
	private CreatureMovement movement;
	
	public Creature(World world,Point3D position, int speed) {
		super(world, position);
		this.speed = speed;
		movement = new CreatureMovement(this);
		init();
	}
	public void init() {
		destination = world.getCube(position);
		actionpoints = 0;
		facing_direction = Direction.DOWN;
	}
	
	
	@Override
	public boolean enter_cube(Cube cube) {
		if (cube !=null) {
			if (cube.fill == 0) {
				if (cube.enter(this)) {
					position = cube.getPosition();
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
		actionpoints = 0;
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		add_action_points(speed);
		// check wheather it has to move
		movement.move();
	}
	
	/*
	 * with this method the maximum action points
	 * will not be exceeded
	 */
	public void add_action_points(int a) {
		actionpoints += a;
		if (actionpoints > ACTION_POINT_CAP) {
			actionpoints = ACTION_POINT_CAP;
		}
	}
	
	public boolean pay_action_points(int points) {
		if (points <= actionpoints) {
			actionpoints -= points;
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * this prevents messing up the movement
	 * when giving a new destination
	 */
	public boolean give_movement_destination(Cube cube) {
		this.movement.reset();
		destination = cube;
		
		return busy;
		
	}
	
	//getters and setters
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Direction getFacing_direction() {
		return facing_direction;
	}
	public void setFacing_direction(Direction facing_direction) {
		this.facing_direction = facing_direction;
	}
	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	public int getAccumulated_actionpoints() {
		return actionpoints;
	}
	public void setAccumulated_actionpoints(int accumulated_actionpoints) {
		this.actionpoints = accumulated_actionpoints;
	}
	public Cube getDestination() {
		return destination;
	}
	
	
	
	
}
