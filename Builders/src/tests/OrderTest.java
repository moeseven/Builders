package tests;

import control.keyInputHandler;
import gui.GameFrame;
import pathfinding.Pathfinder;
import world.Creature;
import world.Cube;
import world.Game;
import world.MoveableEntityInWorld;
import world.Point3D;

public class OrderTest {
	static Game game;
	static keyInputHandler input_handler;
	static Pathfinder pathfinder;
	
	public static void main(String[] args) {
		game = new Game();
		input_handler = new keyInputHandler(game);
		game.getVision().getGame_frame().addKeyListener(input_handler);	
		game.getHive_mind().addCreature(new Creature(game.getWorld(), new Point3D(23, 20,0), 10));
	}
}
