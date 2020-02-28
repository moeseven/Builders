package hive;

import java.util.ArrayList;

import world.CubeSelector;
import world.Point3D;
import world.World;

public class HiveMind {
	private int energy;
	private CubeSelector selector;
	private World world;
	private ArrayList<Order> orders;
	public HiveMind(World world, Point3D position) {
		super();
		this.world = world;
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
	
}
