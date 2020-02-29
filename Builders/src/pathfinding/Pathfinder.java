package pathfinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Pathfinder {
	private static int MAX_PATHFINDING_STEPS;
	private HashSet<PathfinderField> newly_accessible_fields;
	private HashSet<PathfinderField> reset_buffer_newly_accessible_fields;
	private HashMap<PathfinderField,Path> best_paths_map;
	private PathfinderField origin;
	private PathfinderField destination;
	private PathfinderWorld world;
	public Pathfinder(PathfinderField origin, PathfinderField destination, PathfinderWorld world) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.world = world;
		best_paths_map = new HashMap<PathfinderField,Path>();
		newly_accessible_fields = new HashSet<PathfinderField>();
		reset_buffer_newly_accessible_fields = new HashSet<PathfinderField>();
	}

	public Path get_best_path() {
		if (best_paths_map.containsKey(destination)) {
			return best_paths_map.get(destination);
		}else {
			return null;
		}
	}
	
	public boolean find_path() {
		//TODO pathfinding algorithm
		
		newly_accessible_fields.add(origin);
		while (!path_found() || newly_accessible_fields.size() == 0) {
			reset_newly_accessible_fields();
			for(PathfinderField field : reset_buffer_newly_accessible_fields) {
				scan_step(field);
			}
		}
		return path_found();
	}
	
	private boolean path_found() {
		if (best_paths_map.containsKey(destination)) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 *scans all adjacent fields and tries to find better paths towards them 
	 */
	private void scan_step(PathfinderField field) {
		ArrayList<PathfinderField> adjacent_fields = world.get_all_adjacent_fields(field);
		for (int i = 0; i < adjacent_fields.size(); i++) {
			Path another_path = new Path(best_paths_map.get(field).getPath());
			another_path.addField(adjacent_fields.get(0));
			if (best_paths_map.containsKey(adjacent_fields.get(i))) {
				if (another_path.get_cost() < best_paths_map.get(adjacent_fields.get(i)).get_cost()) {
					better_path(adjacent_fields.get(i),another_path);
				}
			}else {
				better_path(adjacent_fields.get(i),another_path);
			}
		}
	}
	
	/*
	 * a new better path to a field has been found
	 */
	private void better_path(PathfinderField field, Path path) {
		best_paths_map.put(field,path);
		newly_accessible_fields.add(field);
	}
	
	/*
	 * resets newly_accessible_fields (empyt set)
	 * and copies it to reset_buffer_newly_accessible_fields
	 * this can then be used in the new iteration
	 * 
	 * 
	 */
	private void reset_newly_accessible_fields() {
		reset_buffer_newly_accessible_fields = new HashSet<PathfinderField>();
		for(PathfinderField field :newly_accessible_fields) {
			reset_buffer_newly_accessible_fields.add(field);
		}
		newly_accessible_fields = new HashSet<PathfinderField>();
	}
}
