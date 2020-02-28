package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import hive.HiveMind;
import world.*;

public class keyInputHandler implements KeyListener{
	private HiveMind hive_mind;
	private HashMap<String, String> key_map;

	public keyInputHandler(HiveMind hive_mind) {
		super();
		this.hive_mind = hive_mind;
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
			hive_mind.getSelector().move(Direction.UP);			
		}
		if (e.getKeyText(kc).equals(key_map.get("move.down"))) {
			hive_mind.getSelector().move(Direction.DOWN);
		}
		if (e.getKeyText(kc).equals(key_map.get("move.west"))) {
			hive_mind.getSelector().move(Direction.WEST);
		}
		if (e.getKeyText(kc).equals(key_map.get("move.east"))) {
			hive_mind.getSelector().move(Direction.EAST);
		}
		if (e.getKeyText(kc).equals(key_map.get("move.south"))) {
			hive_mind.getSelector().move(Direction.SOUTH);
		}
		if (e.getKeyText(kc).equals(key_map.get("move.north"))) {
			hive_mind.getSelector().move(Direction.NORTH);
		}
		if (e.getKeyText(kc).equals(key_map.get("order.move"))) {
			//TODO
			//hive_mind.new_order(new MoveOrder());
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
