package estimate_pi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pi estimator");
        Pane pane = new Pane();
        pane.getStylesheets().add("style.css");
        RightPane control_panel = new RightPane(pane);
        control_panel.show();

        Cartesian cartesian = new Cartesian(pane);
        cartesian.show();

        control_panel.setCartesian(cartesian);


        LinearGradient panel_gradient = new LinearGradient(0,
                0.1,
                0,
                300,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("138BA6")),
                new Stop(1, Color.web("#6513A6")));



        primaryStage.setScene(new Scene(pane, 500, 300));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
