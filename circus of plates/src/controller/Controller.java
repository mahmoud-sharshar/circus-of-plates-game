package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import view.ViewManager;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;

import world.Engine;

public class Controller {

	private ViewManager view;
	private GameFacade model;
	private static Controller instance = null;
	private Controller(GameFacade model, ViewManager view) {
		this.view = view;
		this.model = model;
		view.setController(this);
	}
	
	public static Controller getInstance(GameFacade model, ViewManager view) {
		if(instance ==null) {
			instance = new Controller(model, view);
		}
		
		return instance;
		
	}

	public void startGame(String levelName) {
		System.out.println(levelName);
//		final GameController controlGame = GameEngine.start("Very Simple Game in 99 Line of Code",
//				model.createEngine(levelName), null, Color.YELLOW);
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
		final GameController controlGame = GameEngine.start("Very Simple Game in 99 Line of Code",
				model.createEngine(levelName), menuBar, Color.YELLOW);
		newMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				controlGame.changeWorld(model.createEngine(levelName));
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
