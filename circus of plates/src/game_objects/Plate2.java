package game_objects;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import classes.ColorShapes;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import observer.Observer;
import shpe_state.Horizontal;
import shpe_state.ShapeState;

public class Plate2 extends AbstractObject {

	private ShapeState state;
	private int pointer;
	private World engine;
	private GameObject shelf;
	private BufferedImage[] spriteImages;
	private int x;
	private int y;
	private boolean newShape = false;
	private List<Observer> observers = new ArrayList<>();

	/**
	 * 
	 * @param width
	 * @param height
	 */
	public Plate2(String path, Color color, int width, int height, World engine, GameObject shelf) {
		super(width, height, path);
		ColorShapes m = new ColorShapes();
		spriteImages = new BufferedImage[1];
		spriteImages[0] = m.color(path, color);
		this.engine = engine;
		this.shelf = shelf;
		setObservers();
	}

	@Override
	public void setX(int x) {
		this.x = x;
		for(int i=0;i<this.observers.size();i++) {
			this.observers.get(i).update(x, this.y);
		}
	}

	@Override
	public void setY(int y) {
		if (!newShape)
			this.y = y;
		newShape = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BufferedImage[] getSpriteImages() {

		return spriteImages;
	}

	public boolean isVisible() {
		return true;
	}

	private void setObservers() {
		for (int i = 3; i < this.engine.getControlableObjects().size(); i++) {
			observers.add((Observer) engine.getControlableObjects().get(i));
		}
	}

}
