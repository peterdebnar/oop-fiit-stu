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

public class CustomerLoginView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public CustomerLoginView(Stage window){
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
        Button registerButton = new Button("Register");
        Button backButton = new Button("Back");
        Label loginLabel = new Label("Log in");
        Label noAccountLabel = new Label("Don't have an Account yet? Register now!");
        Label invalidLoginLabel = new Label("Invalid Login!");
        TextField usernameTextField = new TextField();
        PasswordField passwordField = new PasswordField();

        loginButton.setOnAction(event->{
            int verify = userController.verifyCustomer(usernameTextField.getText(), passwordField.getText());
            if(verify == 1){
                Router.routeTo(ROUTES.CUSTOMER_HOME);
            }
            else{
                invalidLoginLabel.setVisible(true);
            }
        });
        registerButton.setOnAction(event->{
            Router.routeTo(ROUTES.CUSTOMER_REGISTER);
        });
        backButton.setOnAction(event->{
            Router.routeTo(ROUTES.MAIN_LOGIN);
        });

        this.gridPane.getChildren().add(loginButton);
        this.gridPane.getChildren().add(registerButton);
        this.gridPane.getChildren().add(backButton);
        this.gridPane.getChildren().add(loginLabel);
        this.gridPane.getChildren().add(noAccountLabel);
        this.gridPane.getChildren().add(invalidLoginLabel);
        this.gridPane.getChildren().add(usernameTextField);
        this.gridPane.getChildren().add(passwordField);

        GridPane.setConstraints(loginLabel, 0, 0);
        GridPane.setConstraints(usernameTextField, 0, 1);
        GridPane.setConstraints(passwordField, 0, 2);
        GridPane.setConstraints(invalidLoginLabel, 0, 3);
        GridPane.setConstraints(loginButton, 0, 4);
        GridPane.setConstraints(noAccountLabel, 0, 5);
        GridPane.setConstraints(registerButton, 0, 6);
        GridPane.setConstraints(backButton, 0, 7);

        invalidLoginLabel.setVisible(false);
        invalidLoginLabel.setTextFill(Color.color(1, 0, 0));

        this.window.show();
    }
}
