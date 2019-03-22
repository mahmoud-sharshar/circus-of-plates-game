package game_objects;

import java.awt.Color;
import java.awt.image.BufferedImage;


import classes.ColorShapes;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import observer.Observer;
import shpe_state.Controlable;
import shpe_state.Horizontal;
import shpe_state.ShapeState;
import shpe_state.Vertical;
import snapShot.CareTaker;
import snapShot.Originator;

public class Plate implements GameObject ,Observer{

	private ShapeState state;
	private int pointer;
	private World engine;
	private GameObject shelf;
	private BufferedImage[] spriteImages;
	private String handType;

	public int x;
	public int y;

	private int Width;
	private int Height;

	private Originator organiser;
	private CareTaker store;

	/**
	 * 
	 * @param width
	 * @param height
	 */
	public Plate(String path, Color color, int width, int height, World engine, GameObject shelf) {
		this.Width = width;
		this.Height = height;

		this.organiser = new Originator();
		this.store = new CareTaker();

		ColorShapes m = new ColorShapes();
		spriteImages = new BufferedImage[1];
		spriteImages[0] = m.color(path, color);
		this.engine = engine;
		this.shelf = shelf;
		state = new Horizontal(this);
		
		this.organiser.setState(state);
		this.store.add(this.organiser.saveTOMemento());
	}

	public CareTaker getStore() {
		return store;
	}

	@Override
	public void setX(int x) {
		this.x = state.changeX(x);

	}

	@Override
	public void setY(int y) {
		this.y = state.changeY(y);

	}

	public void setState(ShapeState state) {
		this.state = state;
	}

	public ShapeState getState() {
		return this.state;
	}

	public World getEngine() {
		return engine;
	}

	public GameObject getShelf() {
		return this.shelf;
	}

	public BufferedImage[] getSpriteImages() {

		return spriteImages;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.Width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.Height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getHandType() {
		return handType;
	}

	public void setHandType(String handType) {
		this.handType = handType;
	}

	@Override
	public void update(int x, int y) {
		if(this.handType.equals("left")) {
			this.setX(this.engine.getControlableObjects().get(2).getX());
		}else if(this.handType.equals("right")) {
			this.setX(this.engine.getControlableObjects().get(1).getX());
		}
	
		
	}



	
	
	

}
