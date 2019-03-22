package view;



import controller.Controller;
import controller.GameFacade;
import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {

	private Controller controller;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ViewManager manager = new ViewManager();
			
			GameFacade model = new GameFacade();
			controller = Controller.getInstance(model, manager);
			
			primaryStage = manager.getMainStage();
			primaryStage.setTitle("Circus of Plates");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
