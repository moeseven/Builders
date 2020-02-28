package alloldConcepts;

import java.util.LinkedList;

public class CollectAndBringToStorageJob extends Job{
	public CollectAndBringToStorageJob(Tile pickUpTile, Tile storageTile){
		taskChain= new LinkedList<Task>();
		//move to tile A
		this.taskChain.add(new pickUpTask(1));
		//move to tile B
		this.taskChain.add(new dropItemsTask(1));
	}
	@Override
	protected void jobTaskChain() {
		// TODO Auto-generated method stub
		
	}

}
