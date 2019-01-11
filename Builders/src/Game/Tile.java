package Game;
import java.util.LinkedList;

public class Tile {
private Room room;
private int x;
private int y;
private int z;
private LinkedList<Item> items;
private int terrainCost;
private boolean solid;
private Tile north;
private Tile south;
private Tile east;
private Tile west;
private Tile above;
private Tile below;
public Tile(int x, int y, int z) {
	super();
	this.x = x;
	this.y = y;
	this.z = z;
}
public void onTick() {
	
}
public boolean enter(Builder b){
	if (!solid) {
		b.setTile(this);
		return true;
	}else {
		return false;
	}
}
public boolean addToRoom(Room room) {
	this.room=room;
	return true;
}
//geters and setters
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getZ() {
	return z;
}
public void setZ(int z) {
	this.z = z;
}
public LinkedList<Item> getItems() {
	return items;
}
public void setItems(LinkedList<Item> items) {
	this.items = items;
}
public int getTerrainCost() {
	return terrainCost;
}
public void setTerrainCost(int terrainCost) {
	this.terrainCost = terrainCost;
}
public boolean isSolid() {
	return solid;
}
public void setSolid(boolean solid) {
	this.solid = solid;
}
public Tile getNorth() {
	return north;
}
public void setNorth(Tile north) {
	this.north = north;
}
public Tile getSouth() {
	return south;
}
public void setSouth(Tile south) {
	this.south = south;
}
public Tile getEast() {
	return east;
}
public void setEast(Tile east) {
	this.east = east;
}
public Tile getWest() {
	return west;
}
public void setWest(Tile west) {
	this.west = west;
}
public Tile getAbove() {
	return above;
}
public void setAbove(Tile above) {
	this.above = above;
}
public Tile getBelow() {
	return below;
}
public void setBelow(Tile below) {
	this.below = below;
}

}
