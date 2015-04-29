package com.practice.HBox;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class LoginRegion extends Region {

	private GridPane gp;
	private Label ul;
	private Label pas;
	private TextField utf;
	private PasswordField pw;
	private Rectangle2D primaryScreenBounds;
	private ColumnConstraints columnConstraints;
	private ColumnConstraints columnConstraints2;
	private ColumnConstraints columnConstraints3;
	private ColumnConstraints columnConstraints4;
	private ColumnConstraints columnConstraints5;
	public LoginRegion(double width,double hight,Rectangle2D primaryScreenBounds){
		this.primaryScreenBounds = primaryScreenBounds;
		columnConstraints = new ColumnConstraints(100);
		columnConstraints2 = new ColumnConstraints(170);
		columnConstraints3 = new ColumnConstraints(100);
		columnConstraints4 = new ColumnConstraints(170);
		columnConstraints = new ColumnConstraints(300);
		gp = new GridPane();
		gp.setPadding(new Insets(10,0,0,20));
		gp.setHgap(5);gp.setVgap(5);
		 ul = new Label("User Name : ");
		GridPane.setHalignment(ul, HPos.RIGHT);
		utf = new TextField();
		pas = new Label("Password : ");
		GridPane.setHalignment(pas, HPos.RIGHT);
		pw = new PasswordField();
		Button login = new Button("Sign In");
		gp.setPrefHeight(primaryScreenBounds.getHeight());
		gp.setPrefWidth(primaryScreenBounds.getWidth());
		gp.gridLinesVisibleProperty().set(true);
		
		gp.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
			@Override
			public void changed(ObservableValue<? extends Bounds> observable,
					Bounds oldValue, Bounds newValue) {
				
			}
		});
		
		GridPane.setHalignment(login,HPos.RIGHT);
		GridPane.setMargin(login,new Insets(10,0,0,0));
		gp.add(ul,0,0);gp.add(utf,1,0);
		gp.add(pas,0,1);gp.add(pw,1,1); 
		gp.add(login,1,2);
	}
	
	public GridPane getGridPane(){
		return gp;
	}
	
	
}
