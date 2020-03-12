package tests;

import control.keyInputHandler;
import gui.GameFrame;
import pathfinding.PathfinderField;
import world.*;

public class GuiTest {
		static Game game;
		static MoveableEntityInWorld entity;
		static keyInputHandler input_handler;
		static GameFrame game_frame;
		private static void check_position() {
			Cube position_of_creature = entity.getCube();
			String console_output = "position: ";
			console_output += "x: " + position_of_creature.getPosition().x;
			console_output += "|y: " + position_of_creature.getPosition().y;
			console_output += "|z: " + position_of_creature.getPosition().z;
			System.out.println(console_output);
		}
		
		public static void main(String[] args) {
			game = new Game();
			entity = game.getHive_mind().getSelector();
			input_handler = new keyInputHandler(game);
			game.getWorld().addCreature(new Creature(game.getWorld(), new Point3D(23, 20,3), 10));
			game_frame.addKeyListener(input_handler);
			while (true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//check_position();
				//System.out.println(game.getWorld().get_all_adjacent_fields(entity.getCube()).size());
			}
		}
}
