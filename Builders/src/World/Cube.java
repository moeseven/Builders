package World;

public class Cube {
	private int x,y,z;
	private int fill; //percentage of cube filled with material e.g. dirt
	
	/*
	 * x,y,z position of cube
	 * fill is percentage of material in the cube
	 */
	public Cube(int x, int y, int z, int fill) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.fill = fill;
	}
	
	/*
	 * enters cube if it is empty
	 */
	public boolean enter(Creature creature) {
		if (fill == 0) {
			creature.setX(x);
			creature.setY(y);
			creature.setZ(z);
			return true;
		}else {
			return false;
		}				
	}
	
	//getters and setters
	
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
	
	
	
	
}
