package Game;
import java.util.HashSet;
import java.util.Set;

public class Game {
private Tile[][][] world;
private Set<Room> rooms;
private Set<Builder> builders;
private Set<Job> jobs;
private JobManager jobManager;

public Game() {
	super();
	jobs= new HashSet<Job>();
	jobManager = new JobManager();
	world = new Tile[20][20][5];
	builders = new HashSet<Builder>();
}

public void onTick() {
	for(Builder b: builders) {
		b.onTick();
	}
	for(Room r: rooms) {
		r.onTick();
	}
}
}
