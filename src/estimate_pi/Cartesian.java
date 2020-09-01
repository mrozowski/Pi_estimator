package estimate_pi;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;



public class Cartesian {
    private Pane parent;
    private Point[] points;
    private Pane newPane;
    private Arc one_quarter;
    private int points_in_circle;
    private double result;
    public Cartesian(Pane parent){
        this.parent = parent;
        createQuarterCircle();
    }

    public void setRandomPoints(int n){
        points_in_circle = 0;
        points =  createRandom_points(n);

        for(Point a: points){
            if(distance(a)){
                a.insideCircle();
                points_in_circle++;
            }
        }


        newPane.getChildren().setAll(one_quarter);
        newPane.getChildren().addAll(points);

        result = (double)points_in_circle/n * 4;
    }

    private void createQuarterCircle(){
        //Bluish gradiend for the one quarter of a circle
        RadialGradient gradient1 = new RadialGradient(0,
                0.1,
                0,
                300,
                300,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("85E4F9")),
                new Stop(1, Color.web("#138BA6")));

        //Creating one quarter of a circle
        one_quarter = new Arc(0, 300f, 300f, 300f, 0, 0);
        one_quarter.setLength(90.0f);
        one_quarter.setType(ArcType.ROUND);
        one_quarter.setFill(gradient1);
        one_quarter.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 20, 0.2, 2, -2);");
    }

    public void show(){
        newPane = new Pane();
        newPane.setStyle("-fx-background-color: #BEDBDB;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 10, 0, 4, 0);");


        newPane.getChildren().add(one_quarter);
        parent.getChildren().add(newPane);

    }

    private boolean distance(Point point) {
        return ((Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2)) < 1);
    }

    private Point[] createRandom_points(int n) {
        Point[] points = new Point[n];
        for(int i=0; i<n; i++){
            double x = Math.random();
            double y = Math.random();

            points[i] = new Point(x, y);
        }

        return points;
    }

    public int getPointsInCircle() {
        return points_in_circle;
    }

    public double getResult() {
        return result;
    }
}
