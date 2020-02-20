package World;

import World.Creature.Direction;

public class Worldtest {
	static World world;
	static Creature creature;
	private static void check_position() {
		Cube position = world.getCube(creature);
		String console_output = "position: ";
		console_output += "x: " + position.getX();
		console_output += "|y: " + position.getY();
		console_output += "|z: " + position.getZ();
		System.out.println(console_output);
	}
	
	public static void main(String[] args) {
		// TODO test functionality of basic world
		world = new World(10,12,4);
		creature = new Creature(world, 10);
		creature.move(Direction.UP);	
		System.out.println("trying to move up");
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
	}

	
}
