package TaskLibrary;

import Game.Builder;
import Game.Task;
import Game.Tile;

public class pickUpTask extends Task{

	public pickUpTask(int time) {
		super(time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onFinish(Builder builder) {
		for (int i = 0; i < builder.getTile().getItems().size(); i++) {
			builder.pickUpItem(builder.getTile().getItems().get(i));
		}
		
	}

	@Override
	public void performTask(Builder builder) {
		requiredTime-=builder.getWorkSpeed();
		if (requiredTime<=0) {
			onFinish(builder);
		}
		
	}

}
