package world;

import hive.HiveMind;

public class Game {
	private World world;
	private HiveMind hive_mind;
	public Game() {
		super();
		world = new World(100, 90, 7,30);
		hive_mind = new HiveMind(world, new Point3D(0, 0, 0));
	}

	//getters and setters
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public HiveMind getHive_mind() {
		return hive_mind;
	}

	public void setHive_mind(HiveMind hive_mind) {
		this.hive_mind = hive_mind;
	}
	
	
}
