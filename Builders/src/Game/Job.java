package Game;

import java.util.LinkedList;

public abstract class Job {
	private String profession;
	private boolean assigned;
	protected LinkedList<Task> taskChain;
	public void assignJob(Builder b) {

		assigned=true;
	}
	protected abstract void jobTaskChain();
}
