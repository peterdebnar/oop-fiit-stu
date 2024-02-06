package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.router.ROUTES;
import sample.router.Router;

public class TrafficManagerHomeView extends View{
    UserController userController;

    /**
     * konštruktor pre WarehousemanHomeView
     * @param window - Stage class
     */

    public TrafficManagerHomeView(Stage window){
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
        Button manageButton = new Button("Manage");
        Button createTask = new Button("Create Task");
        Label idLabel = new Label ("ID: ");
        Label countLabel = new Label ("Count: ");
        Label destinationLabel = new Label ("Destination: ");
        TextField idTextField = new TextField();
        TextField countTextField = new TextField();
        TextField destinationTextField = new TextField();

        logoutButton.setOnAction(event->{
            Router.routeTo(ROUTES.EMPLOYEE_LOGIN);
        });

        manageButton.setOnAction(event->{
            userController.manage();
        });

        createTask.setOnAction(event->{
            userController.createTask(Integer.parseInt(idTextField.getText()), Integer.parseInt(countTextField.getText()), destinationTextField.getText());
        });

        this.gridPane.getChildren().add(logoutButton);
        this.gridPane.getChildren().add(manageButton);
        this.gridPane.getChildren().add(createTask);
        this.gridPane.getChildren().add(idLabel);
        this.gridPane.getChildren().add(countLabel);
        this.gridPane.getChildren().add(destinationLabel);
        this.gridPane.getChildren().add(idTextField);
        this.gridPane.getChildren().add(countTextField);
        this.gridPane.getChildren().add(destinationTextField);

        GridPane.setConstraints(logoutButton, 0, 0);
        GridPane.setConstraints(manageButton, 0, 1);
        GridPane.setConstraints(idLabel, 0, 2);
        GridPane.setConstraints(idTextField, 1, 2);
        GridPane.setConstraints(countLabel, 0, 3);
        GridPane.setConstraints(countTextField, 1, 3);
        GridPane.setConstraints(destinationLabel, 0, 4);
        GridPane.setConstraints(destinationTextField, 1, 4);
        GridPane.setConstraints(createTask, 0, 5);

        this.window.show();
    }
}
