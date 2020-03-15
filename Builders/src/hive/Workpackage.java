package hive;

import world.Point3D;

public abstract class Workpackage {
	private boolean running;
	private int work_cost;
	private Point3D position;
	public void finish() {
		
	}
	public abstract void do_work();
}
