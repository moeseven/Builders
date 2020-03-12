package world;

import pathfinding.Path;
import pathfinding.Pathfinder;

public class CreatureMovement{
	private Pathfinder pathfinder;
	private Creature creature;
	private int fail_count;
	public CreatureMovement(Creature creature) {
		super();
		this.creature = creature;
		pathfinder = new Pathfinder(creature.getWorld());
	}
	
	public void reset() {
		pathfinder.reset();
	}

	public boolean move() {
		int movement_cost = creature.getCube().get_path_cost();
		if (creature.getAccumulated_actionpoints() >= movement_cost) {
			if (!(creature.getDestination().getPosition().has_same_coordinates(creature.getPosition()))) {
				// find path and start moving
				if (pathfinder.path_found(creature.getDestination())) {
					Path path = pathfinder.get_best_path();
					Cube cube = (Cube) path.getPath().get(path.getIndex_for_walking());
					if (creature.move(cube)) {
						creature.pay_action_points(movement_cost);
						path.setIndex_for_walking(path.getIndex_for_walking() + 1);
						return true;
					}else {
						//TODO a path might bet blocked for ever: deal with that here
						fail_count++;
						if (fail_count > 10) {
							creature.setBusy(false);
						}
					}
				}else {
					if (pathfinder.find_path(creature.getCube(), creature.getDestination())) {
						fail_count = 0;
					}else {
						//failed can't reach!
						System.out.println("failed pathfinding");
					}
				}
			}
			
		}
		return false;
	}


}
