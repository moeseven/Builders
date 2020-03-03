package tests;

import control.keyInputHandler;
import gui.GameFrame;
import pathfinding.Pathfinder;
import world.Creature;
import world.Cube;
import world.Game;
import world.MovableEntityInWorld;
import world.Point3D;

public class PathfinderTest {
	static Game game;
	static keyInputHandler input_handler;
	static GameFrame game_frame;
	static Pathfinder pathfinder;
	
	public static void main(String[] args) {
		game = new Game();
		game_frame = new GameFrame(game);
		input_handler = new keyInputHandler(game.getHive_mind());
		game.getWorld().addCreature(new Creature(game.getWorld(), new Point3D(23, 20,3), 10));
		game_frame.addKeyListener(input_handler);
		pathfinder = new Pathfinder(game.getWorld());	
		while (true) {
			//find new path
			pathfinder.find_path(game.getWorld().getCube(new Point3D((int) (Math.random()*game.getWorld().getX_size()), (int) (Math.random()*game.getWorld().getY_size()), 0)), game.getWorld().getCube(new Point3D((int) (Math.random()*game.getWorld().getX_size()), (int) (Math.random()*game.getWorld().getY_size()), (int) (Math.random()*game.getWorld().getZ_size()))));
			if (pathfinder.path_found()) {
				System.out.println(pathfinder.get_best_path().toString());
			}else {
				System.out.println("there was no path that could be found");
			}
			game_frame.getWorld_jpanel().setPath(pathfinder.get_best_path());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
