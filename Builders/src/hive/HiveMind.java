package hive;

import java.util.ArrayList;

import world.ClassWithGameTick;
import world.Creature;
import world.CubeSelector;
import world.Point3D;
import world.World;

public class HiveMind implements ClassWithGameTick{
	private int energy;
	private CubeSelector selector;
	private World world;

	private ArrayList<Creature> creatures;
	public HiveMind(World world, Point3D position) {
		super();
		this.world = world;
		creatures = new ArrayList<Creature>();
		selector = new CubeSelector(world, position);
	}
	
	/*
	 * finds and returns first creature from creatures that has nothing to do
	 */
	public Creature get_non_busy_creature() {
		for (int i = 0; i < creatures.size(); i++) {
			if (!creatures.get(i).isBusy()) {
				return creatures.get(i);
			}
		}
		return null;
	}
	public void add_creature(Creature creature) {
		creatures.add(creature);
	}
		@Override
	public void tick() {
		// TODO Auto-generated method stub
			for (int i = 0; i < creatures.size(); i++) {
				creatures.get(i).tick();
			}
			//creatures.forEach((n) -> n.tick());
	}
		
		
	//getters and setters
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public CubeSelector getSelector() {
		return selector;
	}
	public void setSelector(CubeSelector selector) {
		this.selector = selector;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}



	public ArrayList<Creature> getCreatures() {
		return creatures;
	}

	public void setCreatures(ArrayList<Creature> creatures) {
		this.creatures = creatures;
	}
	///////////////////////////////

	
}
