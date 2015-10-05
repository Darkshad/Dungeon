package dungeon.object;

import dungeon.Dungeon;
import dungeon.object.Objects;

public abstract class ObjectsCanBeTaken extends Objects {
	protected boolean canBeTaken = true;
	
	public ObjectsCanBeTaken(String name, Dungeon dg) {
		super(name, dg);
	}
	
	public boolean canBeTaken() {
		return this.canBeTaken;
	}
	
	public abstract void use();
}
