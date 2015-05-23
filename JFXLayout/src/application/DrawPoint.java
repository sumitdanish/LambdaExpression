package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawPoint extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	Line line1;
	Circle cir1;
	int count = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			Group gr = new Group();
			Circle cir = new Circle(50,50,20);
			cir.setFill(Color.FIREBRICK);
			Line line = new Line();
			
			//Line line1;
			cir.setOnMousePressed(new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {
					//System.out.println("Mouse Clicked > "+event.getSceneX()+" > "+event.getSceneY());
					if(count > 0){
						line1 = new Line();
						line1.setStartX(event.getSceneX());
						line1.setStartY(event.getSceneY());
						line1.setFill(Color.AQUA);
					}else{
						line.setStartX(event.getSceneX());
						line.setStartY(event.getSceneY());
						line.setFill(Color.AQUA);
						line.setStrokeWidth(4);
					} 
				}
			});
			
			gr.setOnMouseDragged(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					//System.out.println("Mouse Dragged > "+event.getSceneX()+" > "+event.getSceneY());
					if(count != 0){
						
						line1.setEndX(event.getSceneX());
						line1.setEndY(event.getSceneY());
						line1.setFill(Color.AQUA);
						
					}else{
						line.setEndX(event.getSceneX());
						line.setEndY(event.getSceneY());
						line.setFill(Color.AQUA);
						
					}
				}
			});
			gr.setOnMouseReleased(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					//System.out.println("Mouse Released > "+event.getSceneX()+" > "+event.getSceneY());
					Line l;
					if(count != 0){
						
						line1.setEndX(event.getSceneX());
						line1.setEndY(event.getSceneY());
						l = line1;
					}else{
						line.setEndX(event.getSceneX());
						line.setEndY(event.getSceneY());
						line.setFill(Color.AQUA);
						l = line;
						gr.getChildren().addAll(cir);
					}
					cir1 = new Circle(event.getSceneX(),event.getSceneY(),20);
					cir1.setFill(Color.AQUAMARINE);
					gr.getChildren().addAll(cir1,l);
				}
			});
			count++;
			
			Scene sc = new Scene(gr,300,300);
			primaryStage.setScene(sc);;
			primaryStage.show();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
