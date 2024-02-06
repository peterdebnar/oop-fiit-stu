package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.router.ROUTES;
import sample.router.Router;

public class EmployeeLoginView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public EmployeeLoginView(Stage window){
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
        Button loginButton = new Button("Log in");
        Button backButton = new Button("Back");
        Label loginLabel = new Label("Log in");
        Label invalidLoginLabel = new Label("Invalid Login!");
        TextField usernameTextField = new TextField();
        PasswordField passwordField = new PasswordField();

        backButton.setOnAction(event->{
            Router.routeTo(ROUTES.MAIN_LOGIN);
        });
        loginButton.setOnAction(event->{
            String verify = userController.verifyEmployee(usernameTextField.getText(), passwordField.getText());
            if(!verify.isEmpty()){
                switch(verify){
                    case "director":
                        Router.routeTo(ROUTES.DIRECTOR_HOME);
                        break;
                    case "designer":
                        Router.routeTo(ROUTES.DESIGNER_HOME);
                        break;
                    case "transport":
                        Router.routeTo(ROUTES.TRANSPORT_HOME);
                        break;
                    case "warehouseman":
                        Router.routeTo(ROUTES.WAREHOUSEMAN_HOME);
                        break;
                    case "traffic":
                        Router.routeTo(ROUTES.TRAFFIC_HOME);
                        break;
                    case "manager":
                        Router.routeTo(ROUTES.MANAGER_HOME);
                        break;
                }
            }
            else{
                invalidLoginLabel.setVisible(true);
            }
        });

        this.gridPane.getChildren().add(loginButton);
        this.gridPane.getChildren().add(backButton);
        this.gridPane.getChildren().add(loginLabel);
        this.gridPane.getChildren().add(invalidLoginLabel);
        this.gridPane.getChildren().add(usernameTextField);
        this.gridPane.getChildren().add(passwordField);

        GridPane.setConstraints(loginLabel, 0, 0);
        GridPane.setConstraints(usernameTextField, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(invalidLoginLabel, 0, 2);
        GridPane.setConstraints(loginButton, 0, 3);
        GridPane.setConstraints(backButton, 0, 4);

        invalidLoginLabel.setVisible(false);
        invalidLoginLabel.setTextFill(Color.color(1, 0, 0));

        this.window.show();
    }
}
