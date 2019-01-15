package TaskLibrary;

import Game.Builder;
import Game.Task;
import Game.Tile;
import ItemLibrary.Berry;

public class pickBerries extends pickUpTask{

	public pickBerries(int time) {
		super(time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onFinish(Builder builder) {
		for (int i = 0; i < builder.getTile().getItems().size(); i++) {
			if(builder.getTile().getItems().get(i) instanceof Berry) {
				builder.pickUpItem(builder.getTile().getItems().get(i));
			}			
		}
		
	}

}
