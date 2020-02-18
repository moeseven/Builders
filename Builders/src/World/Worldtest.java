package World;


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
		creature.move('u');	
		System.out.println("trying to move up");
		check_position();
		creature.move('u');	
		System.out.println("trying to move up");
		check_position();
		creature.move('u');	
		System.out.println("trying to move up");
		check_position();
		creature.move('n');	
		System.out.println("trying to move north");
		check_position();
		creature.move('n');	
		System.out.println("trying to move north");
		check_position();
		creature.move('e');	
		System.out.println("trying to move east");
		check_position();
		creature.move('d');	
		System.out.println("trying to move down");
		check_position();
		creature.move('e');	
		System.out.println("trying to move east");
		check_position();
		creature.move('e');	
		System.out.println("trying to move east");
		check_position();
		creature.move('w');	
		System.out.println("trying to move west");
		check_position();
		creature.move('n');	
		System.out.println("trying to move north");
		check_position();
		creature.move('n');	
		System.out.println("trying to move north");
		check_position();
	}

	
}
