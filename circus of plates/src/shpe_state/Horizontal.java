package shpe_state;

import eg.edu.alexu.csd.oop.game.GameObject;
import game_objects.Plate;

public class Horizontal implements ShapeState {

	private Plate shape;

	public Horizontal(Plate shape) {
		this.shape = shape;
		this.reset();
	}

	@Override
	public int changeX(int x) {
		if (shape.getShelf().getX() == 0) {// left shelf
			if (shape.getShelf().getWidth() <= x) {
				shape.setState(new Vertical(shape));
				return x;
			} else
				return x;
		} else {// right shelf
			if (shape.getShelf().getWidth() <= shape.getEngine().getWidth() - shape.getX()) {
				shape.setState(new Vertical(shape));
				return x - 2;
			} else {
				return x - 2;
			}
		}

	}

	@Override
	public int changeY(int y) {
		return shape.getY();

	}

	@Override
	public void reset() {
		if (shape.getShelf().getX() == 0)// left shelf
			shape.x = 0;
		else// right shelf
			shape.x = shape.getShelf().getX() + shape.getShelf().getWidth();
		shape.y = shape.getShelf().getY();
		
	}

}
