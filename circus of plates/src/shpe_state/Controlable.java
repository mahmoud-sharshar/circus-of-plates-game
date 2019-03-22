package shpe_state; 

import eg.edu.alexu.csd.oop.game.GameObject;
import game_objects.Plate;

public class Controlable implements ShapeState{

	private Plate shape;
	public Controlable(Plate shape) {
		this.shape = shape;
	}
	
	@Override
	public int changeX(int x) {
		
//		
//		if(shape.getHandType().equals("left")) {
//			return shape.getEngine().getControlableObjects().get(2).getX();
//		}else if(shape.getHandType().equals("right")) {
//			return shape.getEngine().getControlableObjects().get(1).getX();
//		}
		return x;
	}

	@Override
	public int changeY(int y) {
		// TODO Auto-generated method stub
		return shape.getY();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}
