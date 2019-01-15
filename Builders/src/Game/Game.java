package Game;
import java.util.HashSet;
import java.util.Set;

import javafx.scene.layout.TilePane;

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
	//neighboring tiles
	for (int x = 0; x < world[0].length; x++) {
		for (int y = 0; y < world[1].length; y++) {
			for (int z = 0; z < world[2].length; z++) {
				world[x][y][z]= new Tile(x, y, z);
				if(z==0) {
					world[x][y][z].setAir(true);
				}
			}
		}
	}
	for (int x = 0; x < world[0].length; x++) {
		for (int y = 0; y < world[1].length; y++) {
			for (int z = 0; z < world[2].length; z++) {
				if (x+1<world[0].length) {
					world[x][y][z].setEast(world[x+1][y][z]);
				}
				if (x-1>0) {
					world[x][y][z].setWest(world[x-1][y][z]);
				}
				if (y+1<world[1].length) {
					world[x][y][z].setSouth(world[x][y+1][z]);
				}
				if (y-1>0) {
					world[x][y][z].setNorth(world[x+1][y-1][z]);
				}
				if (z+1<world[2].length) {
					world[x][y][z].setBelow(world[x][y][z+1]);
					
				}
				if (z-1>0) {
					world[x][y][z].setAbove(world[x][y][z-1]);
				}				
			}
		}
	}
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
