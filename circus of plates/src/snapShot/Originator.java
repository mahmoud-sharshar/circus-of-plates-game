package snapShot;

import java.lang.management.MemoryNotificationInfo;

import shpe_state.ShapeState;

public class Originator {

	ShapeState state;
	
	public void setState(ShapeState state) {
		this.state = state;
	}

	
	public Memento saveTOMemento() {
		return new Memento(this.state);
	}
	
	public void getStateFromMemento(Memento m) {
		this.state = m.getState();
	}
	
	
	
	
}
