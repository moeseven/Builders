package hive;

import world.Creature;

public abstract class Order {
	private HiveMind hive_mind;
	private boolean is_running;
	private boolean is_loop_order;
	private Creature appointed_creature;
	public Order(HiveMind hive_mind) {
		super();
		this.hive_mind = hive_mind;
	}
	public abstract void completed_order();
	public void finish() {
		is_running = false;
		appointed_creature.setBusy(false);
		completed_order();
		hive_mind.cancle_order(this);
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
	public boolean isIs_running() {
		return is_running;
	}

	public void setIs_running(boolean is_running) {
		this.is_running = is_running;
	}
	
	
}
