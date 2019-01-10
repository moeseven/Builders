package Game;

import java.util.LinkedList;

public class Builder {
private String name;
private int hunger;
private int fatigue;
private int speed;
private int health;
private Tile tile;
private String profession;
private Tile destination;
private LinkedList<Item> items;
public Builder(Tile tile) {
	super();
	this.tile = tile;
}
public void onTick() {
	
}
}
