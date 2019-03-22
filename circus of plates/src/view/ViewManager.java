package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;





public class ViewManager {
	private List<MyButton> menuButtons;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	private MySubScene helpSubScene;
	private MySubScene scoreSubScene;
	private MySubScene selectSubScene;
	private MySubScene levelSubScene;
	private MySubScene subSceneToHide;
	
	private String selectedLevel;
	private Controller controller;

	public String getSelectedLevel() {
		return selectedLevel;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	/**
	 * you need to attach those three buttons to your work to handle the levels.
	 */
	private MyButton level1;
	
	public Image getChosenImage() {
		return chosenImage;
	}
	
	private MyButton level2;
	private MyButton level3;

	private List<clownChooser> clownList;
	private Clown clownChosen;
	/**
	 * the chosen clown image;
	 */
	private Image chosenImage;

	private final static int x = 50;
	private final static int y = 300;

	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, 900, 800);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButtons();
		setBackground();
		createSubScenes();
	}

	private void showSubScene(MySubScene subScene) {
		if (subSceneToHide != null) {
			subSceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		subSceneToHide = subScene;
	}

	private void createButtons() {
		createStartButton();
//		createScoreButton();
//		createHelpButton();
		createAddButton();
		createExitButton();

	}

	private void createSubScenes() {
		helpSubScene = new MySubScene();
		mainPane.getChildren().add(helpSubScene);

		scoreSubScene = new MySubScene();
		mainPane.getChildren().add(scoreSubScene);

		createSelectSubScene();

		createLevelSubScene();

	}

	private void createSelectSubScene() {
		selectSubScene = new MySubScene();
		mainPane.getChildren().add(selectSubScene);

		Label label1 = new Label("Choose clown");
		try {
			label1.setFont(Font.loadFont(new FileInputStream("src/resources/junegull.ttf"), 23));
		} catch (FileNotFoundException e) {
			label1.setFont(Font.font("Vrdana", 23));
		}
		label1.setLayoutX(240);
		label1.setLayoutY(30);
		selectSubScene.getPane().getChildren().add(label1);
		selectSubScene.getPane().getChildren().add(createClownsToChoose());
	}

	private HBox createClownsToChoose() {
		HBox box = new HBox();
		box.setSpacing(20);
		clownList = new ArrayList<>();
		for (Clown clown : Clown.values()) {
			clownChooser clownToChoose = new clownChooser(clown);
			clownList.add(clownToChoose);
			box.getChildren().add(clownToChoose);
			clownToChoose.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for (clownChooser clownChosen : clownList) {
						clownChosen.setCircleImage(false);
					}
					clownToChoose.setCircleImage(true);
					clownChosen = clownToChoose.getClown();
					chosenImage = new Image(clownChosen.getUrl());
					System.out.println(clownChosen.getUrl());
				}
			});
		}
		box.setLayoutX(70);
		box.setLayoutY(100);
		return box;

	}

	private void createLevelSubScene() {
		levelSubScene = new MySubScene();
		mainPane.getChildren().add(levelSubScene);
		Label label1 = new Label("Choose level");
		try {
			label1.setFont(Font.loadFont(new FileInputStream("src/resources/junegull.ttf"), 23));
		} catch (FileNotFoundException e) {
			label1.setFont(Font.font("Vrdana", 23));
		}
		label1.setLayoutX(240);
		label1.setLayoutY(30);
		levelSubScene.getPane().getChildren().add(label1);

		level1 = createLevelButton("level1");
		level2 = createLevelButton("level2");
		level3 = createLevelButton("level3");

		VBox box = new VBox();
		box.setSpacing(50);
		box.getChildren().addAll(level1, level2, level3);
		box.setPadding(new Insets(40, 40, 40, 40));
		box.setLayoutX(180);
		box.setLayoutY(60);
		levelSubScene.getPane().getChildren().add(box);

	}

	public Stage getMainStage() {
		return mainStage;
	}

	private void addMenuButton(MyButton button) {
		button.setLayoutX(x);
		button.setLayoutY(y + menuButtons.size() * 100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}

	private void createStartButton() {
		MyButton button = new MyButton("Start Game");
		addMenuButton(button);

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(levelSubScene);
			}
		});
	}

	private void createAddButton() {
		MyButton button = new MyButton("select clown");
		addMenuButton(button);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(selectSubScene);

			}
		});
	}

	private void createScoreButton() {
		MyButton button = new MyButton("Score");
		addMenuButton(button);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoreSubScene);

			}
		});
	}

	private void createHelpButton() {
		MyButton button = new MyButton("Help");
		addMenuButton(button);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(helpSubScene);

			}
		});
	}

	private void createExitButton() {
		MyButton button = new MyButton("Exit");
		addMenuButton(button);

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainStage.close();

			}
		});
	}

	private void setBackground() {
		Image backgroundImage = new Image("/resources/circus.jpg", 900, 800, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	
	private MyButton createLevelButton(String levelName) {
		MyButton newLevel = new MyButton(levelName);
		this.selectedLevel = levelName;

		newLevel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				controller.startGame(levelName);

			}
		});
		return newLevel;
	}
}
