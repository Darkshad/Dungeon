package dungeon.object;

import dungeon.Dungeon;
import dungeon.object.Objects;

public abstract class ObjectsCanNotBeTaken extends Objects {
	protected boolean canBeTaken = false;
	
	public ObjectsCanNotBeTaken(String name, Dungeon dg) {
		super(name, dg);
	}
	
	public boolean canBeTaken() {
		return this.canBeTaken;
	}
	
	public abstract void use();
}