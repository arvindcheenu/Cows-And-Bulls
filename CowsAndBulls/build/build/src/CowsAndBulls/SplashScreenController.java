package CowsAndBulls;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreenController implements Initializable {
	@FXML
	private Button newGameButton;
	@FXML 
	private AnchorPane anchor1;
	@FXML
	private void initNewGame() throws IOException {
		try {
			Stage stage = (Stage) anchor1.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("CowsAndBulls.fxml"));
			Scene scene = new Scene(root,423,668);
			scene.setFill(Color.BLACK);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Cows and Bulls");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleButtonClick (ActionEvent event) {
		FadeOutCurrent();
	}
	
	private void FadeOutCurrent () {
		FadeTransition fadetransition = new FadeTransition(Duration.millis(600));
		fadetransition.setNode(anchor1);
		fadetransition.setFromValue(1);
		fadetransition.setToValue(0);
		fadetransition.setOnFinished ((ActionEvent e) -> {
			try {
				initNewGame();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		fadetransition.play();
	}
	
	public void initialize (URL url, ResourceBundle rb) {
		anchor1.setOpacity(0);
		makeFadeInTransition();
	}
	
	private void makeFadeInTransition() {
		FadeTransition fadetransition = new FadeTransition(Duration.millis(1500));
		fadetransition.setNode(anchor1);
		fadetransition.setFromValue(0);
		fadetransition.setToValue(1);
		fadetransition.play();
	}
}
