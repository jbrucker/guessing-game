package game;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for starting the application.
 * Initialize the application and display first scene of the UI.
 * Use this class to create and initialize any objects your app needs.
 * 
 * @author Jim
 */
public class GameApp extends Application {
	public static final String UI_FORM = "game/GameUI.fxml";

	/**
	 * Select the scene to display and start JavaFX.
	 * This is a call-back method invoked by JavaFX.  
	 * Your main method calls Application.launch() and JavaFX
	 * calls this method to show a "scene".
	 * 
	 * @param stage the primary "stage" for showing the scene.
	 */
	@Override
	public void start(Stage stage) {
		Parent parent = null;
//		try {
			URL form = this.getClass().getClassLoader().getResource(UI_FORM);
			if (form == null) {
				Logger.getLogger("GameApp").log(Level.SEVERE, "Couldn't file FXML form " + UI_FORM);
				return;
			}
			try {
				parent = FXMLLoader.load(form);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// another way to use FXMLLoader.
			// FXMLLoader loader = new FXMLLoader();
			// parent = loader.load(form.openStream());

//		} catch (IOException ex) {
//			Logger.getLogger("GameApp").log(Level.SEVERE, "Failed to load form", ex);
//			return;
//		}

		Scene scene = new Scene(parent);
		stage.setTitle("Guessing Game");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
