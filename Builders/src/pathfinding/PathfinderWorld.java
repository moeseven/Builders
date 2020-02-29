package pathfinding;

import java.util.ArrayList;

public interface PathfinderWorld {
	public ArrayList<PathfinderField> get_all_adjacent_fields(PathfinderField field);
	public int get_number_of_fields();
}
