package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import pathfinding.Path;
import world.Creature;
import world.Cube;
import world.Direction;
import world.MovableEntityInWorld;
import world.Point3D;
import world.World;

public class WorldJPanel extends JPanel{
	
	private Path path;
	private World world;
	private static int CUBE_SIZE = 10;
	private static int X_OFFSET = 20;
	private static int Y_OFFSET = 20;
	private MovableEntityInWorld selected_moveable_entity;
	public WorldJPanel(World world, MovableEntityInWorld selected_movable_entity) {
		super();
		this.world = world;
		this.selected_moveable_entity = selected_movable_entity;
	}
	
	public void update() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		for (int x = 0; x < world.getX_size(); x++) {
			for (int y = 0; y < world.getY_size(); y++) {
				paintCube(world.getCube(new Point3D(x, y, selected_moveable_entity.getPosition().z)), g);
			}
		}
		paintPath(path, g);
		g.setColor(Color.CYAN);
		for (int c = 0; c < world.getCreatures().size(); c++) {
			paintCreature(world.getCreatures().get(c), g);
		}
	}
	
	
	/*
	 * draws a cube 
	 * dark if it is filled
	 * bright if below cube is not filled
	 * green circle if this is the selected cube
	 */
	private void paintCube(Cube cube, Graphics g) {
		
		//choose correct color
		if (cube.getFill() == 0) {
			if (world.get_adjacent_cube(cube, Direction.DOWN).getFill() == 0) {
				g.setColor(Color.LIGHT_GRAY); // cube not filled and cube beneath is not filled
			}else {
				g.setColor(Color.GRAY);//cube is not filled
			}			
		}else {
			g.setColor(Color.DARK_GRAY); //cube is filled
		}
		g.fillRect(X_OFFSET + (cube.getPosition().x * CUBE_SIZE), Y_OFFSET + (cube.getPosition().y * CUBE_SIZE),CUBE_SIZE, CUBE_SIZE);
		
		//draw selection
		if (selected_moveable_entity.getPosition().has_same_coordinates(cube.getPosition())) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLUE);
			g2.setStroke(new BasicStroke(3));
			g2.drawRect(X_OFFSET + (cube.getPosition().x * CUBE_SIZE), Y_OFFSET + (cube.getPosition().y * CUBE_SIZE), CUBE_SIZE, CUBE_SIZE);
		}
	}
	
	private void paintPath(Path path, Graphics g) {
		if (path != null) {
					Cube cube;
			for (int i = 0; i < path.getPath().size(); i++) {
				cube = (Cube) path.getPath().get(i);
				if (cube.getPosition().z == selected_moveable_entity.getPosition().z) {
					g.setColor(Color.red);
					g.fillOval(X_OFFSET + (cube.getPosition().x * CUBE_SIZE + CUBE_SIZE/3), Y_OFFSET + (cube.getPosition().y * CUBE_SIZE+ CUBE_SIZE/3),CUBE_SIZE/2, CUBE_SIZE/2);				
				}
			}
		}			
	}
	
	private void paintCreature(Creature creature, Graphics g) {
		if (creature.getPosition().z == selected_moveable_entity.getPosition().z) {			
			g.fillOval(X_OFFSET + (creature.getPosition().x * CUBE_SIZE), Y_OFFSET + (creature.getPosition().y * CUBE_SIZE), CUBE_SIZE, CUBE_SIZE);
		}
		
	}
	
	
	//getters and setters
	
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	
	 
}
