package tests;

import GUI.GameFrame;
import control.inputHandler;
import world.*;

public class InputTest {
		static Game game;
		static Creature creature;
		static inputHandler input_handler;
		static GameFrame game_frame;
		private static void check_position() {
			Cube position_of_creature = creature.getCube();
			String console_output = "position: ";
			console_output += "x: " + position_of_creature.getPosition().x;
			console_output += "|y: " + position_of_creature.getPosition().y;
			console_output += "|z: " + position_of_creature.getPosition().z;
			System.out.println(console_output);
		}
		
		public static void main(String[] args) {
			// TODO test functionality of basic world
			game = new Game();
			game_frame = new GameFrame(game);
			creature = new Creature(game.getWorld(), new Point3D(0,0,0), 10);
			input_handler = new inputHandler(creature);
			game_frame.addKeyListener(input_handler);
			check_position();
			creature.move(Direction.UP);	
			System.out.println("trying to move up");
			check_position();
			creature.move(Direction.UP);	
			System.out.println("trying to move up");
			check_position();
			creature.move(Direction.NORTH);	
			System.out.println("trying to move north");
			check_position();
			creature.move(Direction.NORTH);	
			System.out.println("trying to move north");
			check_position();
			creature.move(Direction.EAST);	
			System.out.println("trying to move east");
			check_position();
			creature.move(Direction.DOWN);	
			System.out.println("trying to move down");
			check_position();
			creature.move(Direction.EAST);	
			System.out.println("trying to move east");
			check_position();
			creature.move(Direction.EAST);	
			System.out.println("trying to move east");
			check_position();
			creature.move(Direction.WEST);	
			System.out.println("trying to move west");
			check_position();
			creature.move(Direction.NORTH);	
			System.out.println("trying to move north");
			check_position();
			creature.move(Direction.NORTH);	
			System.out.println("trying to move north");
			check_position();
			while (true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				check_position();
			}
		}
}
