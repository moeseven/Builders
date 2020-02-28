package world;

public class Game {
	private World world;
	private MovableEntityInWorld player_world_navigator;
	public Game() {
		super();
		world = new World(100, 90, 7,20);
		player_world_navigator = new MovableEntityInWorld(world, new Point3D(0, 0, 6));
	}

	//getters and setters
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public MovableEntityInWorld getPlayer_world_navigator() {
		return player_world_navigator;
	}

	public void setPlayer_world_navigator(MovableEntityInWorld player_world_navigator) {
		this.player_world_navigator = player_world_navigator;
	}
	
	
}
