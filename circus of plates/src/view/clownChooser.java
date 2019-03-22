package view;



import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class clownChooser extends VBox {
	private ImageView circleImage;
	private ImageView clownImage;
	private String circleNotChosen = "/resources/grey_circle.png";
	private String circleChosen = "/resources/yellow_boxTick.png";
	
	private Clown clown;
	
	private boolean isChosen;
	public clownChooser(Clown clown) {
		circleImage = new ImageView(circleNotChosen);
		clownImage = new ImageView(clown.getUrl());
		this.clown = clown;
		
		isChosen = false;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.getChildren().add(circleImage);
		this.getChildren().add(clownImage);
	}
	public Clown getClown() {
		return this.clown;
	}
	public boolean getIsChosen() {
		return isChosen; 
	}
	public void setCircleImage(boolean isChosen) {
		String imageToSet = new String();
		this.isChosen = isChosen;
		if(this.isChosen) {
			imageToSet = circleChosen;
		}else {
			imageToSet = circleNotChosen;
		}
		circleImage.setImage(new Image(imageToSet));
	}
}
