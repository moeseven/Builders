package alloldConcepts;

public class dropItemsTask extends Task{

	public dropItemsTask(int time) {
		super(time);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onFinish(Builder builder) {
		for (int i = 0; i < builder.getItems().size(); i++) {
			builder.dropItem(builder.getItems().get(i));
		}
		
	}
	@Override
	public void performTask(Builder builder) {
		// TODO Auto-generated method stub
		
	}

}
