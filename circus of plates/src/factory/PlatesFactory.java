package factory;

import java.awt.Color;
import java.util.HashMap;

import dynmic_linkage.Dynamic;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import game_objects.Plate;

public class PlatesFactory {

	private final HashMap<String, Plate> shapesMap = new HashMap<>();

	public HashMap<String, Plate> getShapesMap() {
		return shapesMap;
	}

	private ObjectFactory factory = new ObjectFactory();

	public GameObject getShape(String path, Color color, World engine, GameObject shelf, int size) {
		Plate shape = shapesMap.get(path + "," + color);

		
		if (shape == null ||(shape.getY() < shape.getEngine().getHeight() && shape.getX() != -1)) {
			shape = (Plate) factory.createPlate(path, color, 45, 24, engine, shelf);
			shapesMap.put(path + "," + color, shape);
		}else {
			System.out.println("i entered");
			shape.getEngine().getMovableObjects().remove(shape);
			shape.setState(shape.getStore().get(0).getState());
			
		}

		System.out.println(shape.getX());
		return shape;
	}
}
