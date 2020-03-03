package pathfinding;

import java.util.ArrayList;

public interface PathfinderWorld {
	public ArrayList<PathfinderField> get_all_adjacent_fields(PathfinderField field);
}
