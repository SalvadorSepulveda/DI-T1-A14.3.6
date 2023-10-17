package es.ieslosmontecillos.pathtransitoinexmple;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransition extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Path Transition Example");
        primaryStage.show();

        Circle path = new Circle(250, 250, 100);
        path.setFill(Color.WHITE);
        path.setStrokeWidth(3.0);
        path.setStroke(Color.BLACK);

        DoubleProperty angle = new SimpleDoubleProperty();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(4), new KeyValue(angle, 360)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        root.getChildren().add(path);

        Rectangle rectangle = new Rectangle(50, 75);
        rectangle.setX(225.0);
        rectangle.setY(120.0);
        rectangle.setFill(Color.YELLOW);

        Rotate rotation = new Rotate();
        rotation.setPivotX(250.0);
        rotation.setPivotY(250.0);
        rectangle.getTransforms().add(rotation);
        rotation.angleProperty().bind(angle);

        root.getChildren().add(rectangle);

        path.setOnMousePressed((e) -> {
            timeline.pause();
        });

        path.setOnMouseReleased((e) -> {
            timeline.play();
        });
    }
}
