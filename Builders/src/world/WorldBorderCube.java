package world;

public class WorldBorderCube extends Cube {
	
	/*
	 * this cube is returned when any action reaches beyond the map limits
	 */
	public WorldBorderCube() {
		super( new Point3D(0, 0, 0),1);
	}
	@Override
	public boolean enter(MoveableEntityInWorld entity) {
		return false;
	}

}
