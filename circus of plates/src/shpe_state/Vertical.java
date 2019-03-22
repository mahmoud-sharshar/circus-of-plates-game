package shpe_state;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import game_objects.Plate;

public class Vertical implements ShapeState {

	private Plate shape;
	private GameObject rightPlate;
	private GameObject leftPlate;

	public Vertical(Plate shape) {
		this.shape = shape;
		leftPlate = shape.getEngine().getControlableObjects().get(2);
		rightPlate = shape.getEngine().getControlableObjects().get(1);
		this.reset();

	}

	@Override
	public int changeX(int x) {
		if (x == leftPlate.getX() || x == rightPlate.getX())// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			return x;
		return shape.getX();
	}

	@Override
	public int changeY(int y) {
		int numOfPlates = shape.getEngine().getControlableObjects().size() - 1;
		int shapePosition = shape.getX() + (shape.getWidth() / 2);
		if (shapePosition >= leftPlate.getX() && shapePosition <= leftPlate.getX() + leftPlate.getWidth()
				&& y + shape.getHeight() == this.calculateMaxY(leftPlate.getX())) {
			shape.setX(leftPlate.getX());
			shape.setHandType("left");
			shape.setState(new Controlable(shape));
			shape.getEngine().getControlableObjects().add(shape);// ?????????????
			shape.getEngine().getMovableObjects().remove(shape);// ??????????????

		} else if (shapePosition >= rightPlate.getX() && shapePosition <= rightPlate.getX() + rightPlate.getWidth()
				&& y + shape.getHeight() == this.calculateMaxY(rightPlate.getX())) {
			shape.setX(rightPlate.getX());
			shape.setHandType("right");
			shape.setState(new Controlable(shape));
			shape.getEngine().getControlableObjects().add(shape);// ?????????????
			shape.getEngine().getMovableObjects().remove(shape);// ??????????????

		}else if(y>=shape.getEngine().getHeight()) {
			
		}
		return y;
	}

	private int calculateMaxY(int x) {
	
		for(int i=shape.getEngine().getControlableObjects().size()-1;i>0;i--) {
			GameObject sh = shape.getEngine().getControlableObjects().get(i);
			if(sh.getX() == x) {
				return sh.getY();
			}
		}
		return 0;
	}

	@Override
	public void reset() {
		if(shape.getShelf().getX()==0) {
			shape.x = shape.getShelf().getWidth();
			
		}else {
			shape.x = shape.getEngine().getWidth() - shape.getShelf().getWidth();
		}
		shape.y = shape.getShelf().getY();
	}

}
