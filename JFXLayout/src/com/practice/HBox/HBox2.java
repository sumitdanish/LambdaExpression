package com.practice.HBox;

import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HBox2 extends Application {

	
	 final Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	@Override
	public void start(Stage primaryStage) throws Exception {
		try{

			Rectangle ge = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
			double width = ge.getWidth();
			double hight = ge.getHeight();
			System.out.println("Changing the width > "+width+" > "+hight);
			Region region = new LoginRegion(width,hight,primaryScreenBounds).getGridPane();
			region.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
				@Override
				public void changed(ObservableValue<? extends Bounds> observable,
						Bounds oldValue, Bounds newValue) {
					region.setPrefSize(newValue.getWidth(), newValue.getHeight());
					
					//gp.setPrefSize((newValue.getWidth())-ul.getWidth(), newValue.getHeight());
				}
			});
			Scene sc = new Scene(region,300, 300, Color.WHITE);
			
			primaryStage.setScene(sc);
			primaryStage.show();
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	public static void main(String[] args){
		launch(args);
	}

}
