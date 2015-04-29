package com.practice.HBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HBox1 extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			
			TextField text = new TextField();
			HBox hbox = new HBox();
			hbox.getChildren().add(text);
			HBox.setHgrow(text,Priority.ALWAYS);
			Scene sc = new Scene(hbox,320, 112, Color.rgb(0, 0, 0, 0));
			primaryStage.setScene(sc);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
