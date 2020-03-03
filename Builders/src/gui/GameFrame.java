package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import world.Game;

public class GameFrame extends JFrame {
	private WorldJPanel world_jpanel;
	public GameFrame(Game game) {
		super();
		setSize(new Dimension(1100, 1000));
		setVisible(true);
		world_jpanel = new WorldJPanel(game.getWorld(), game.getHive_mind().getSelector());
		this.setLayout(new BorderLayout());
		add(world_jpanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public WorldJPanel getWorld_jpanel() {
		return world_jpanel;
	}
	public void setWorld_jpanel(WorldJPanel world_jpanel) {
		this.world_jpanel = world_jpanel;
	}

	
}
