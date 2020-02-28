package alloldConcepts;

import java.util.LinkedList;

public class Builder {
private boolean walkingDirection;
private String name;
private int hunger;
private int fatigue;
private int speed;
private int workSpeed;
private int movepoints;
private int health;
private int maxWeight;
private int weight;
private Tile tile;
private String profession;
private Tile destination;
private LinkedList<Item> items;
private Task activeTask;
public Builder(Tile tile) {
	super();
	this.tile = tile;
}
public void onTick() {
	if (activeTask != null) {
		activeTask.performTask(this);
	}
	//moving
	if (activeTask instanceof moveTask) {
		movepoints+=speed;
		if (movepoints>=tile.getTerrainCost()) {
			movepoints-=tile.getTerrainCost();
			if (tile!=destination) {
				moveCloserToDestination();
			}else {
				//reached destination do work
			}
		}
	}
	
}
private void moveCloserToDestination() {
	//basic pathfinding trapped in local maxima!!!
	int leaving=1;
	int xDistance=destination.getX()-tile.getX();
	int yDistance=destination.getY()-tile.getY();
	while (leaving>0) {
		walkingDirection=!walkingDirection;
		if (walkingDirection) {
			if(Integer.signum(xDistance)==1) {
				if (tile.getEast().enter(this)) {
					leaving=0;
				}
			}
			if(Integer.signum(xDistance)==-1) {
				if (tile.getWest().enter(this)) {
					leaving=0;
				}
			}
		}else {
			if(Integer.signum(yDistance)==1) {
				if (tile.getSouth().enter(this)) {
					leaving=0;
				}
			}
			if(Integer.signum(yDistance)==-1) {
				if (tile.getNorth().enter(this)) {
					leaving=0;
				}
			}
		}
		
	}
}
//private boolean moveEast() {
//	tile.getEast().
//}
//private boolean moveWest() {
//	
//}
//private boolean moveNorth() {
//	
//}
//private boolean moveSouth() {
//	
//}
//private boolean moveDown() {
//	
//}
//private boolean moveUp() {
//	
//}

public boolean pickUpItem(Item item) {	
	if(item.getWeight()<=weight+maxWeight) {
		items.add(item);
		weight+=item.getWeight();
		tile.getItems().remove(item);
		return true;
	}
	return false;
}
public void dropItem(Item item) {
	 items.remove(item);
	 weight-=item.getWeight();
	 tile.getItems().add(item);
}
//getters and setters
public boolean isWalkingDirection() {
	return walkingDirection;
}
public void setWalkingDirection(boolean walkingDirection) {
	this.walkingDirection = walkingDirection;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getHunger() {
	return hunger;
}
public void setHunger(int hunger) {
	this.hunger = hunger;
}
public int getFatigue() {
	return fatigue;
}
public void setFatigue(int fatigue) {
	this.fatigue = fatigue;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public int getMovepoints() {
	return movepoints;
}
public void setMovepoints(int movepoints) {
	this.movepoints = movepoints;
}
public int getHealth() {
	return health;
}
public void setHealth(int health) {
	this.health = health;
}
public Tile getTile() {
	return tile;
}
public void setTile(Tile tile) {
	this.tile = tile;
}
public String getProfession() {
	return profession;
}
public void setProfession(String profession) {
	this.profession = profession;
}
public Tile getDestination() {
	return destination;
}
public void setDestination(Tile destination) {
	this.destination = destination;
}
public LinkedList<Item> getItems() {
	return items;
}
public void setItems(LinkedList<Item> items) {
	this.items = items;
}
public int getWorkSpeed() {
	return workSpeed;
}
public void setWorkSpeed(int workSpeed) {
	this.workSpeed = workSpeed;
}
public int getMaxWeight() {
	return maxWeight;
}
public void setMaxWeight(int maxWeight) {
	this.maxWeight = maxWeight;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public Task getActiveTask() {
	return activeTask;
}
public void setActiveTask(Task activeTask) {
	this.activeTask = activeTask;
}


}
