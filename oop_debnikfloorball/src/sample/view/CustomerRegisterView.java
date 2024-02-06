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

public class CustomerRegisterView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public CustomerRegisterView(Stage window){
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
        Button registerButton = new Button("Register");
        Button backButton = new Button("Back");
        Label usernameLabel = new Label("Username: ");
        Label nameLabel = new Label("First Name: ");
        Label surnameLabel = new Label("Surname: ");
        Label passwordLabel = new Label("Password: ");
        Label confirmPasswordLabel = new Label("Confirm Password: ");
        Label errorLabel = new Label("Passwords do not match!");
        TextField usernameTextField = new TextField();
        TextField nameTextField = new TextField();
        TextField surnameTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();

        registerButton.setOnAction(event->{
            String name, surname, username, password, confirm;
            name = nameTextField.getText();
            surname = surnameTextField.getText();
            username = usernameTextField.getText();
            password = passwordField.getText();
            confirm = confirmPasswordField.getText();

            if(!name.equals("") && !surname.equals("") && !username.equals("") && !password.equals("") && password.equals(confirm)){
                int taken;
                taken = userController.isTaken(username);
                if(taken == 0){
                    userController.save("Customer", name, surname, username, password);
                    Router.routeTo(ROUTES.CUSTOMER_HOME);
                }
                else{
                    errorLabel.setText("Username is taken!");
                    errorLabel.setVisible(true);
                }
            }
            else if(!password.equals(confirm)){
                errorLabel.setText("Passwords do not match!");
                errorLabel.setVisible(true);
            }
            else{
                errorLabel.setText("Invalid register!");
                errorLabel.setVisible(true);
            }
        });
        backButton.setOnAction(event->{
            Router.routeTo(ROUTES.CUSTOMER_LOGIN);
        });

        this.gridPane.getChildren().add(registerButton);
        this.gridPane.getChildren().add(backButton);
        this.gridPane.getChildren().add(usernameLabel);
        this.gridPane.getChildren().add(nameLabel);
        this.gridPane.getChildren().add(surnameLabel);
        this.gridPane.getChildren().add(passwordLabel);
        this.gridPane.getChildren().add(confirmPasswordLabel);
        this.gridPane.getChildren().add(errorLabel);
        this.gridPane.getChildren().add(usernameTextField);
        this.gridPane.getChildren().add(nameTextField);
        this.gridPane.getChildren().add(surnameTextField);
        this.gridPane.getChildren().add(passwordField);
        this.gridPane.getChildren().add(confirmPasswordField);

        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setConstraints(nameTextField, 1, 0);
        GridPane.setConstraints(surnameLabel, 0, 1);
        GridPane.setConstraints(surnameTextField, 1, 1);
        GridPane.setConstraints(usernameLabel, 0, 2);
        GridPane.setConstraints(usernameTextField, 1, 2);
        GridPane.setConstraints(passwordLabel, 0, 3);
        GridPane.setConstraints(passwordField, 1, 3);
        GridPane.setConstraints(confirmPasswordLabel, 0, 4);
        GridPane.setConstraints(confirmPasswordField, 1, 4);
        GridPane.setConstraints(errorLabel, 0, 5);
        GridPane.setConstraints(registerButton, 0, 6);
        GridPane.setConstraints(backButton, 0, 7);

        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.color(1, 0, 0));

        this.window.show();
    }
}
