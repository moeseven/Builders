package world;

public class Point3D {
public int x,y,z;

public Point3D(int x, int y, int z) {
	super();
	this.x = x;
	this.y = y;
	this.z = z;
}

public boolean has_same_coordinates(Point3D point) {
	if (x == point.x) {
		if (y == point.y) {
			if (z == point.z) {
				return true;
			}
		}
	}
	return false;
}
  
}
