package view;



import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class MySubScene extends SubScene {

	private final static String backgroundImage = "/resources/yellow_panel.png";
	private boolean isHidden;

	public MySubScene() {
		super(new AnchorPane(), 650, 450);
		prefHeight(450);
		prefWidth(450);
		Image image = new Image(backgroundImage, 650, 450, false, true);
		BackgroundImage backImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, null);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(backImage));
		isHidden = true;
		setLayoutX(1000);
		setLayoutY(300);
	}

	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		if (isHidden) {
			transition.setToX(-750);
			isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}
		transition.play();
	}
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
}
