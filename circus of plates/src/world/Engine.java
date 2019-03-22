package world;

import iterator.Container;
import iterator.MyList;
import observer.Observer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import classes.GetColor;
import classes.LoggerClass;
import classes.Random;
import dynmic_linkage.Dynamic;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import factory.ObjectFactory;
import factory.PlatesFactory;
import factory.Player_StateFactory;
import game_objects.GetPlates;
import game_strategy.GameOver;
import game_strategy.PlayerWin;
import game_strategy.StartGame;
import game_strategy.State;

public class Engine implements World {

	private List<GameObject> constantObjects = new ArrayList<>();
	private List<GameObject> movableObjects = new ArrayList<>();
	private List<GameObject> controlableObjects = new ArrayList<>();
	
	
	private GameLevel level;
	private int controlledSpeed = 100;
	private int score;
	private long time;
	private int Height;
	private int Width;
	private int platesCollected;
	private int sameColorPlates;
	private State gameMode;
	private Player_StateFactory stateFactory;
	private ObjectFactory objectFactory;
	private PlatesFactory shapeFactory = new PlatesFactory();
	private Random Rand = new Random();
	private long startTime = System.currentTimeMillis();
	private int turn = 0;
	private int MAX_TIME = 1 * 100 * 1000;
	private int max;
	private LoggerClass logFactory = new LoggerClass();
	private Logger log;
	private game_strategy.State strategy;// 1 minute
	private Container k;

	
	
	public Engine(List<GameObject> constant, GameLevel level, int Width, int Height, boolean newGame) {
		this.constantObjects = constant;
		this.level = level;
		controlledSpeed = 6;
		this.score = 0;
		this.time = 0;
		this.Width = Width;
		this.Height = Height;
		this.platesCollected = 0;
		this.sameColorPlates = 0;
		stateFactory = new Player_StateFactory();
		objectFactory = new ObjectFactory();
		max = 200;
		shapeFactory = new PlatesFactory();
		
		this.controlableObjects.add(objectFactory.createClown("clown2.png", this, 150, 201));
		this.controlableObjects.add(objectFactory.createPlate2("n22.png", Color.gray, 50, 50, this, null,
				controlableObjects.get(0).getX() - 5 - 45 + controlableObjects.get(0).getWidth(),
				controlableObjects.get(0).getY() - 24));
		this.controlableObjects.add(objectFactory.createPlate2("n22.png", Color.gray, 50, 50, this, null,
				controlableObjects.get(0).getX() - 5, controlableObjects.get(0).getY() - 24));
		k = new MyList();
		log = logFactory.add();
		this.gameMode = stateFactory.changeState("start");
		log.info("Game start");
		long startTime = System.currentTimeMillis();
	}

	@Override
	public List<GameObject> getConstantObjects() {
		return constantObjects;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		return movableObjects;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		return controlableObjects;
	}

	@Override
	public int getWidth() {
		return Width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return Height;
	}

	@Override
	public boolean refresh() {
		boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
		int num1 = controlableObjects.size();
		if (turn > max && max != 0) {
			GameObject shelf = (GameObject) Rand.getRandom(constantObjects, 1, constantObjects.size() - 1);
			Color color = (Color) Rand.getRandom(level.getColors(), 0, level.getColors().size() - 1);
			String paths = (String) Rand.getRandom(level.getShapePaths(), 0, level.getShapePaths().size() - 1);
			GameObject newShape = shapeFactory.getShape(paths, color, this, shelf, level.getSize());
			log.config("New shape is added");
			movableObjects.add(newShape);
			turn = 1;
		}
		k.list(movableObjects);
		iterator.Iterator iterator = k.getIterator();
		turn++;
		if (score == 0) {
			strategy = new StartGame();

		}
		if (score == 5) {
			strategy = new PlayerWin();
			log.info("Number of shapes is increased");
		}
		if (timeout && !(strategy instanceof GameOver)) {
			strategy = new GameOver();
			log.warning("Game Over !!");
		}

		max = strategy.refresh(iterator);

		if (controlableObjects.size() != num1 && max != 0) {
			log.info("Clown catches new shape");
			GetPlates m = new GetPlates();
			List<GameObject> h = m.last(controlableObjects);
			if (h.size() > 2) {
				GetColor b = new GetColor();
				String n1 = b.getColor(h.get(0).getSpriteImages()[0]);
				String n2 = b.getColor(h.get(1).getSpriteImages()[0]);
				String n3 = b.getColor(h.get(2).getSpriteImages()[0]);
				if (n1.equals(n3) && n1.equals(n2)) {
					score++;
					h.get(0).setX(-1);
					h.get(1).setX(-1);
					h.get(2).setX(-1);

					controlableObjects.remove(h.get(0));
					controlableObjects.remove(h.get(1));
					controlableObjects.remove(h.get(2));
					log.severe("Score Now is " + score);

				}

			}
		}

		time = Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);

		return !timeout;

	}

	@Override
	public String getStatus() {
		return "Level   " + level.getString() + " | Score=" + score + "   |   Time=" + time; // update status
	}

	@Override
	public int getSpeed() {
		return level.getSpeed();
	}

	@Override
	public int getControlSpeed() {
		return controlledSpeed * 5;
	}

}
