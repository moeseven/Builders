package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import world.*;

public class inputHandler implements KeyListener{
	private MovableEntityInWorld movable_entity;
	private HashMap<String, String> key_map;

	public inputHandler(MovableEntityInWorld creature) {
		super();
		this.movable_entity = creature;
		load_key_map("control/keycontrols.properties");
	}
	
	private void load_key_map(String filename) {
		key_map = new HashMap<String,String>();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				throw new java.lang.RuntimeException("cant find file "+ filename);
			}
			prop.load(input);
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				key_map.put(key, value);
				System.out.println("Key : " + key + ", Value : " + value);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int kc = e.getKeyCode();
		
	
		if (e.getKeyText(kc).equals(key_map.get("move.up"))) {
			movable_entity.move(Direction.UP);			
		}
		if (e.getKeyText(kc).equals(key_map.get("move.down"))) {
			movable_entity.move(Direction.DOWN);
		}
		if (e.getKeyText(kc).equals(key_map.get("move.west"))) {
			movable_entity.move(Direction.WEST);
		}
		if (e.getKeyText(kc).equals(key_map.get("move.east"))) {
			movable_entity.move(Direction.EAST);
		}
		if (e.getKeyText(kc).equals(key_map.get("move.south"))) {
			movable_entity.move(Direction.SOUTH);
		}
		if (e.getKeyText(kc).equals(key_map.get("move.north"))) {
			movable_entity.move(Direction.NORTH);
		}
		System.out.println(e.getKeyText(kc));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
