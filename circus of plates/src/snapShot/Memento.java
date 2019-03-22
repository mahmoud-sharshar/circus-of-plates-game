package snapShot;

import shpe_state.ShapeState;

public class Memento {

	private ShapeState state;

	public Memento(ShapeState state) {

		this.state = state;
	}

	public ShapeState getState() {
		state.reset();
		return state;
	}

}
