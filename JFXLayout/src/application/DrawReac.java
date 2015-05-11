package application;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.CubicCurveToBuilder;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DrawReac extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			Group g = new Group();
			Rectangle rec = new Rectangle(20, 20, 100, 60);
			rec.setFill(Color.RED);
			rec.setArcHeight(10);
			rec.setArcWidth(10);
			FadeTransition fd = new FadeTransition(Duration.millis(100),rec);
			fd.setFromValue(1.0);
			fd.setToValue(0.1);
			fd.setCycleCount(Timeline.INDEFINITE);
			fd.setAutoReverse(true);
			fd.play();
			
			Path p = new Path();
			
			
			p.getElements().add(new MoveTo(50,50));
			p.getElements().add(new VLineTo(380));
			p.getElements().add(new HLineTo(380));
			//p.getElements().add(new CubicCurveTo(0, 220, 380,220, 380, 240));
			p.setFill(Color.CHOCOLATE);
			p.setStroke(Color.CYAN);
			p.setStrokeDashOffset(0.5);
			PathTransition pt = new PathTransition();
			pt.setDuration(Duration.millis(1000));
			pt.setPath(p); 
			pt.setNode(rec);
			pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setCycleCount(Timeline.INDEFINITE);
			pt.setAutoReverse(true);
			pt.play();
			g.getChildren().add(rec);
			Scene sc = new Scene(g, 700, 500);
			
			primaryStage.setScene(sc);
			primaryStage.show();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
