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
	private ArrayList<Order> orders;
	private ArrayList<Creature> creatures;
	public HiveMind(World world, Point3D position) {
		super();
		this.world = world;
		creatures = new ArrayList<Creature>();
		orders = new ArrayList<Order>();
		selector = new CubeSelector(world, position);
	}
	
	public void new_order(Order order) {
		orders.add(order);
	}
	public void cancle_order(Order order) {
		if (orders.contains(order)) {
			orders.remove(order);
		}
	}
	public void addCreature(Creature creature) {
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

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Creature> getCreatures() {
		return creatures;
	}

	public void setCreatures(ArrayList<Creature> creatures) {
		this.creatures = creatures;
	}
	///////////////////////////////

	
}
