package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.router.ROUTES;
import sample.router.Router;

public class DesignerHomeView extends View{

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public DesignerHomeView(Stage window){
        this.gridPane = new GridPane();
        this.window = window;
        this.scene = new Scene(this.gridPane, 800, 600);
        this.window.setScene(this.scene);
    }

    /**
     * render - zobrazí okno na monitore užívateľa
     */

    public void render(){
        Button logoutButton = new Button("Log Out");
        Button createStick = new Button("Create Stick");
        Button createBall = new Button("Create Ball");
        Button createGoal = new Button("Create Goal");

        logoutButton.setOnAction(event->{
            Router.routeTo(ROUTES.EMPLOYEE_LOGIN);
        });

        createStick.setOnAction(event->{
            Router.routeTo(ROUTES.CREATE_STICK);
        });

        createBall.setOnAction(event->{
            Router.routeTo(ROUTES.CREATE_BALL);
        });

        createGoal.setOnAction(event->{
            Router.routeTo(ROUTES.CREATE_GOAL);
        });

        this.gridPane.getChildren().add(logoutButton);
        this.gridPane.getChildren().add(createStick);
        this.gridPane.getChildren().add(createBall);
        this.gridPane.getChildren().add(createGoal);

        GridPane.setConstraints(logoutButton, 0, 0);
        GridPane.setConstraints(createStick, 0, 1);
        GridPane.setConstraints(createBall, 1, 1);
        GridPane.setConstraints(createGoal, 2, 1);

        this.window.show();
    }
}
