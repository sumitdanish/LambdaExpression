package com.mypractice.Test;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CanvasGame extends Application{
	Rectangle ge = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			AnchorPane anchorPane = new AnchorPane();
			anchorPane.getChildren().add(new MyGridPane(anchorPane));
			Scene sc = new Scene(anchorPane,ge.getWidth(),ge.getHeight());
			
			primaryStage.setScene(sc);
			primaryStage.show();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
}


class MyGridPane extends SplitPane
{
	double gh = 0;
	double gw = 0;
	public MyGridPane(AnchorPane an)
	{
		gw = getPrefWidth();
		gh = getPrefHeight();
		
		//setWidth((Scene)an.getScene().getWidth()());
		setStyle("-fx-background-color: #4B4B4B;");
		getItems().add(new MyLeftPanelOnGridPane());
		getItems().add(new MyRigthPanelInGridPane());
	}
} 

class MyLeftPanelOnGridPane extends VBox
{
	public MyLeftPanelOnGridPane(){
		
		setPadding(new Insets(10,20,0,20));
		setStyle("-fx-background-color: #336699;");
		for(int i = 0 ; i < 5 ; i++){
			Hyperlink hy = new Hyperlink("Hello World : "+i);
			getChildren().addAll(hy);
		}
	}
}
class MyRigthPanelInGridPane extends Pane
{
	public MyRigthPanelInGridPane(){
		setStyle("-fx-background-color: #336555;");
		
		setPadding(new Insets(10,20,0,20));
	}
}