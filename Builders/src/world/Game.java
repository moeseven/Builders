package world;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gui.Vision;
import hive.HiveMind;

public class Game implements ActionListener {
	private World world;
	private HiveMind hive_mind;
	private Timer game_tick_timer = new Timer(150, this);
	private Vision vision;
	public Game() {
		super();
		world = new World(100, 90, 7,30);
		hive_mind = new HiveMind(world, new Point3D(0, 0, 0));
		vision = new Vision(this);
		//game_tick_timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		vision.update();
		//game_tick_timer.restart();
	}
	//getters and setters
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public HiveMind getHive_mind() {
		return hive_mind;
	}

	public void setHive_mind(HiveMind hive_mind) {
		this.hive_mind = hive_mind;
	}
	public Vision getVision() {
		return vision;
	}
	public void setVision(Vision vision) {
		this.vision = vision;
	}


	
	
}
