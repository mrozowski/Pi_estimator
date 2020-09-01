package estimate_pi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class RightPane {
    private Pane parent;
    private Cartesian cartesian;
    private Label all_points;
    private Label in_circle;
    private Label result_schame;
    private Label result_l;
    private Label error_l;
    private Label bottom_result;

    public RightPane(Pane parent){
        this.parent = parent;
        all_points = new Label("");
        in_circle = new Label("");
        result_schame = new Label("");
        result_l = new Label("");
        error_l = new Label("");
        bottom_result = new Label("0.0");

    }

    public void show(){
        GridPane left_panel = new GridPane();
        GridPane header = new GridPane();
        GridPane points_grid = new GridPane();
        GridPane result_grid = new GridPane();
        GridPane error_grid = new GridPane();

        //background
        left_panel.setMinWidth(200);
        left_panel.setMinHeight(300);
        left_panel.setPadding(new Insets(10));
        left_panel.setStyle("-fx-background-color: linear-gradient(to right, #138BA6, #6513A6)");
        left_panel.setLayoutX(300);
        left_panel.setVgap(1);

        //Setting grids
        header.setVgap(5);
        points_grid.setVgap(5);
        points_grid.setPadding(new Insets(3,0,0,0));
        result_grid.setVgap(5);
        error_grid.setVgap(5);

        //header
        Label label = new Label("Set number of points");
        GridPane.setConstraints(label, 0,0);

        TextField input = new TextField();
        input.setMinSize(80, 30);
        input.setMaxSize(115, 30);
        input.setStyle("-fx-background-color: white;" +
                "-fx-background-radius: 0 0 0 5;");



        Button apply = new Button("OK");
        apply.setOnMouseClicked(mouseEvent -> {
            applyChanges(input.getText());

        });

        apply.setMinSize(65, 30);
        apply.setStyle("-fx-background-color: #232728;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 0 5 5 0;");

        HBox hbox = new HBox(input, apply);
        GridPane.setConstraints(hbox, 0,1);

        //points_grid
        Label points_number = new Label("Number of points: ");
        GridPane.setConstraints(points_number, 0,2);
        GridPane.setConstraints(all_points, 1,2);

        Label circle_label = new Label("Points in circle: ");
        GridPane.setConstraints(circle_label, 0,3);
        GridPane.setConstraints(in_circle, 1,3);

        Label result_label = new Label("Result = ");
        GridPane.setConstraints(result_label, 0,4);
        GridPane.setConstraints(result_schame, 1,4);

        Label result_label2 = new Label("Result = ");
        GridPane.setConstraints(result_label2, 0,5);
        GridPane.setConstraints(result_l, 1,5);

        Label error_label = new Label("Error = ");
        GridPane.setConstraints(error_label, 0,6);
        Label error_eq = new Label("| Pi - Result |");
        GridPane.setConstraints(error_eq, 1,6);

        Label error_label2 = new Label("Error = ");
        GridPane.setConstraints(error_label2, 0,7);
        GridPane.setConstraints(error_l, 1,7);

        Line line = new Line(0, 0, 170, 0);
        line.setStyle("-fx-stroke: linear-gradient(to right, rgba(133, 228, 249, 0), rgba(133, 228, 249, 1), rgba(133, 228, 249, 0));");
        GridPane.setConstraints(line, 0,8);


        bottom_result.setStyle("-fx-font: 24 arial;");
        HBox result = new HBox(bottom_result);
        result.setAlignment(Pos.CENTER);
        result.setMinHeight(45);
        GridPane.setConstraints(result, 0,9);

        Button magic_button = new Button("Average");
        magic_button.setMinWidth(100);
        magic_button.setLayoutX(440);
        magic_button.setLayoutY(140);
        magic_button.setRotate(-90);
        magic_button.setPadding(Insets.EMPTY);
        magic_button.getStyleClass().add("magic_button");
        magic_button.setOnMouseClicked(mouseEvent -> {
            advance_estimation(input.getText());
        });


        header.getChildren().setAll(label, hbox);
        points_grid.getChildren().setAll(points_number, all_points, circle_label, in_circle);
        result_grid.getChildren().setAll(result_label, result_schame, result_label2, result_l);
        error_grid.getChildren().setAll(error_label, error_eq, error_label2, error_l);
        VBox vbox = new VBox(header, points_grid, result_grid, error_grid);
        left_panel.getChildren().setAll(vbox, line, result);
        parent.getChildren().addAll(left_panel, magic_button);
    }

    private void advance_estimation(String a) {
        double avg = 0;
        int loop = 100;
        for(int i=0; i<loop; i++){
            applyChanges(a);
            avg += cartesian.getResult();
        }
        avg = avg/loop;
        error_l.setText(String.format("%5.4f", (Math.abs(Math.PI - avg))));
        bottom_result.setText(String.format("%5.4f", avg));

    }

    private void setResults(int n, int a, double result){
        all_points.setText(String.valueOf(n));
        in_circle.setText(String.valueOf(a));
        result_schame.setText(a + " / " + n + " * 4");

        String res = String.format("%5.4f", result);
        result_l.setText(res);
        bottom_result.setText(res);
        error_l.setText(String.format("%5.4f", (Math.abs(Math.PI - result))));
    }
    private void applyChanges(String text) {
        int a;
        try{
            a = Integer.parseInt(text);
            if(a > 1) {
                cartesian.setRandomPoints(a);
                setResults(a, cartesian.getPointsInCircle(), cartesian.getResult());
            }
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
            //add later message box
        }

    }

    public void setCartesian(Cartesian cartesian) {
        this.cartesian = cartesian;
    }
}
