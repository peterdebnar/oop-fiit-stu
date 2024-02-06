package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.router.ROUTES;
import sample.router.Router;

public class ManagerHomeView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public ManagerHomeView(Stage window){
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
        Button backButton = new Button("Back");
        Button manageButton = new Button("Manage");

        backButton.setOnAction(event->{
            Router.routeTo(ROUTES.EMPLOYEE_LOGIN);
        });
        manageButton.setOnAction(event->{
            userController.manage();
        });

        this.gridPane.getChildren().add(backButton);
        this.gridPane.getChildren().add(manageButton);

        GridPane.setConstraints(manageButton, 0, 0);
        GridPane.setConstraints(backButton, 0, 1);

        this.window.show();
    }
}
