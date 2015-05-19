package com.mypractice.Test;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
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
			anchorPane.getChildren().add(new MyGridPane());
			Scene sc = new Scene(anchorPane,ge.getWidth(),ge.getHeight());
			primaryStage.setScene(sc);
			primaryStage.show();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
}


class MyGridPane extends BorderPane
{
	double gh = 0;
	double gw = 0;
	public MyGridPane()
	{
		gw = getPrefWidth();
		gh = getPrefHeight();
		setLeft(new MyLeftPanelOnGridPane(this));
		setCenter(new MyRigthPanelInGridPane(this));
	}
} 

class MyLeftPanelOnGridPane extends VBox
{
	public MyLeftPanelOnGridPane(BorderPane borderPane){
		setHeight(borderPane.getPrefHeight());
		setWidth(borderPane.getPrefWidth()/3);
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
	public MyRigthPanelInGridPane(BorderPane borderPane){
		setStyle("-fx-background-color: #336555;");
		setHeight(borderPane.getPrefHeight());
		setWidth((borderPane.getPrefWidth())-(borderPane.getPrefWidth()/3));
		setPadding(new Insets(10,20,0,20));
	}
}