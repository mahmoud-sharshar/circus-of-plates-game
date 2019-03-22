package controller;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import factory.ObjectFactory;
import world.Engine;
import world.GameLevel;
import world.Level1;
import world.Level2;
import world.Level3;

public class GameFacade {

	ObjectFactory factory = new ObjectFactory();

	private List<GameObject> getConstantObjects() {
		List<GameObject> constantObjects = new ArrayList<>();
		constantObjects.add(factory.createConstantObject("backGround", "circus.jpg", 1000, 1000));
		constantObjects.add(factory.createConstantObject("shelf", "shelf2.png", 300, 69));
		GameObject l = factory.createConstantObject("shelf", "shelf2.png", 300, 69);
		GameObject l2 = factory.createConstantObject("shelf", "shelf3.png", 230, 69);
		GameObject l3 = factory.createConstantObject("shelf", "shelf3.png", 230, 69);

		l.setX(900 - 300);
		l3.setX(900 - 230);
		constantObjects.add(l);
		constantObjects.add(l2);
		l2.setY(l.getY() + 100);
		l3.setY(l3.getY() + 100);
		constantObjects.add(l3);
		return constantObjects;
	}

	public World createEngine(String level ) {
		List<GameObject> constantObjects = getConstantObjects();
		GameLevel selectedLevel;
		
		if (level.equals("level1")) {
			selectedLevel = new Level1();
		} else if (level.equals("level2")) {
			selectedLevel = new Level2();
		} else if (level.equals("level3")) {
			selectedLevel = new Level3();
		} else {
			selectedLevel = new Level1();
		}
		return new Engine(constantObjects, selectedLevel, 900, 800, true);
	}
}
