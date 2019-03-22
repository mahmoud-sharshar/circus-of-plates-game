package view;



import java.io.FileInputStream;

import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class MyButton extends Button {
	private final String fontPath = "src/resources/junegull.ttf";
	private final String buttonPressedStyle = "-fx-background-color :transparent; -fx-background-image : url('/resources/yellow_button01.png')";
	private final String buttonFreeStyle = "-fx-background-color :transparent; -fx-background-image : url('/resources/yellow_button00.png')";

	public MyButton(String text) {
		setText(text);
		setPrefWidth(190);
		setPrefHeight(49);
		setButtonFont();
		setStyle(buttonFreeStyle);
		intializeButtonListeners();
	}

	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(fontPath), 23));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Vrdana", 23));
		}

	}

	private void setButtonPressedStyle() {
		setStyle(buttonPressedStyle);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}

	private void setButtonReleasedStyle() {
		setStyle(buttonFreeStyle);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4);
	}

	private void intializeButtonListeners() {
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}

			}
		});

		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}

			}
		});

		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());

			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(null);

			}
		});

	}

}
