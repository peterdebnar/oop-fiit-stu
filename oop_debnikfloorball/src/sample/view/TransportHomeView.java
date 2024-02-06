package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.router.ROUTES;
import sample.router.Router;

public class TransportHomeView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public TransportHomeView(Stage window){
        userController = new UserController();
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
        Button viewButton = new Button("View Tasks");

        logoutButton.setOnAction(event->{
            Router.routeTo(ROUTES.EMPLOYEE_LOGIN);
        });

        viewButton.setOnAction(event->{
            userController.viewTasks();
        });

        this.gridPane.getChildren().add(logoutButton);
        this.gridPane.getChildren().add(viewButton);

        GridPane.setConstraints(logoutButton, 0, 0);
        GridPane.setConstraints(viewButton, 0, 1);

        this.window.show();
    }
}
