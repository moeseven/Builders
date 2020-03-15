package hive;

import java.util.ArrayList;

import world.Creature;

public class Order {
	private HiveMind hive_mind;
	private boolean running;
	private boolean is_loop_order;
	private Creature appointed_creature;
	private ArrayList<Workpackage> work_packages;
	public Order(HiveMind hive_mind) {
		super();
		this.hive_mind = hive_mind;
		this.work_packages = new ArrayList<Workpackage>();
	}
	public void complete_order() {
		//TODO
	}
	public boolean appoint_creature(Creature creature) {
		if (creature.isBusy()) {
			return false;
		}else {
			creature.setBusy(true);
			appointed_creature = creature;
			return true;
		}
	}
	
	//getters and setters
	public boolean is_running() {
		return running;
	}

	public void set_running(boolean is_running) {
		this.running = is_running;
	}
	
	
}
