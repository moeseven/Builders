package Game;

public abstract class Job {
	private String profession;
	private boolean assigned;
	public void assignJob(Builder b) {
		b.setActiveJob(this);
		assigned=true;
	}
	protected abstract void jobTaskChain();
}
