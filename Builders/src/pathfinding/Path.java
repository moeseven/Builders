package pathfinding;

import java.util.LinkedList;

public class Path {
	private LinkedList<PathfinderField> path;
	
	
	/*
	 * this consturctor does take the elemtns form the list
	 * and makes a new List form it. 
	 * The original list remains untouched
	 */
	public Path(LinkedList<PathfinderField> path) {
		super();
		this.path = new LinkedList<PathfinderField>();
		for (int i = 0; i < path.size(); i++) {
			addField(path.get(i));
		}
	}
	
	public Path() {
		path = new LinkedList<PathfinderField>();
	}
	
	public boolean addField(PathfinderField field) {
		if (field.isPathable()) {
			path.add(field);
			return true;
		}else {
			return false;
		}		 
	}
	public PathfinderField get_start() {
		return path.getFirst();
	}
	public PathfinderField get_end() {
		return path.getLast();
	}
	public int get_cost() {
		int retVal = 0;
		for (int i = 0; i < path.size(); i++) {
			retVal += path.get(i).get_path_cost();
		}
		return retVal;
	}
	
	public String toString() {
		String retVal = "";
		for (int i = 0; i < path.size(); i++) {
			retVal += path.get(i).toString();
		}
		return retVal;
	}
	
	//getters and setters
	public LinkedList<PathfinderField> getPath() {
		return path;
	}

//	public void setPath(LinkedList<PathfinderField> path) {
//		this.path = path;
//	}
	
}
