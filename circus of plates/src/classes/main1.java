package classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import world.Engine;
import world.GameLevel;
import world.Level2;
import world.Level1;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.World;
import factory.ObjectFactory;

public class main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectFactory factory = new ObjectFactory();
		List <BufferedImage>clowns  = new ArrayList();
		 List<GameObject> constantObjects = new ArrayList<>();
		 constantObjects.add(factory.createConstantObject("backGround", "circus.jpg", 1000, 1000));
		 constantObjects.add(factory.createConstantObject("shelf", "shelf2.png", 300, 69));
		 GameObject l=factory.createConstantObject("shelf", "shelf2.png", 300, 69);
		 GameObject l2=factory.createConstantObject("shelf", "shelf3.png", 230, 69);
		 GameObject l3=factory.createConstantObject("shelf", "shelf3.png", 230, 69);

		 l.setX(900-300);
		 l3.setX(900-230);
		 constantObjects.add(l);
		 constantObjects.add(l2);
		 l2.setY(l.getY()+100);
		 l3.setY(l3.getY()+100);
		 constantObjects.add(l3);
		 List<GameObject> control = new ArrayList<>();
		 GameLevel game = new Level2();
		 JMenuBar  menuBar = new JMenuBar();
			JMenu menu = new JMenu("File");
			JMenuItem newMenuItem = new JMenuItem("New");
			JMenuItem pauseMenuItem = new JMenuItem("Pause");
			JMenuItem resumeMenuItem = new JMenuItem("Resume");
			JMenuItem saveMenuItem = new JMenuItem("Save State");
			menu.add(newMenuItem);
			menu.addSeparator();
			menu.add(pauseMenuItem);
			menu.add(resumeMenuItem);
			menuBar.add(menu);
			World gameEngine =new Engine(constantObjects,game,900, 800,true);
			final GameController controlGame =GameEngine.start("Very Simple Game in 99 Line of Code", gameEngine, menuBar,Color.YELLOW);
			newMenuItem.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					controlGame.changeWorld(new Engine(constantObjects,game,900, 800,true));
					}
				});
				pauseMenuItem.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					controlGame.pause();
					}
				});
				resumeMenuItem.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
						controlGame.resume();
					}
				});
	}

}
