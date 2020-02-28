package alloldConcepts;

public abstract class Task {
	protected int requiredTime;
	public Task(int time) {
		requiredTime=time;
	}
	public abstract void onFinish(Builder builder);
	public abstract void performTask(Builder builder);
}
