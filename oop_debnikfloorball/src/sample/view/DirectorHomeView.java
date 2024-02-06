package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.router.ROUTES;
import sample.router.Router;

public class DirectorHomeView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public DirectorHomeView(Stage window){
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
        Button createButton = new Button("Create");
        Label mainLabel = new Label("Create account for employee");
        Label usernameLabel = new Label("Username: ");
        Label nameLabel = new Label("First Name: ");
        Label surnameLabel = new Label("Surname: ");
        Label passwordLabel = new Label("Password: ");
        Label confirmPasswordLabel = new Label("Confirm Password: ");
        Label errorLabel = new Label("Passwords do not match!");
        Label functionLabel = new Label("Function: ");
        TextField usernameTextField = new TextField();
        TextField nameTextField = new TextField();
        TextField surnameTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();
        ChoiceBox<String> functionsBox = new ChoiceBox<>();

        backButton.setOnAction(event->{
            Router.routeTo(ROUTES.EMPLOYEE_LOGIN);
        });

        createButton.setOnAction(event->{
            String name, surname, username, password, confirm, function;
            name = nameTextField.getText();
            surname = surnameTextField.getText();
            username = usernameTextField.getText();
            password = passwordField.getText();
            confirm = confirmPasswordField.getText();
            function = functionsBox.getValue();

            if(!name.equals("") && !surname.equals("") && !username.equals("") && !password.equals("") && !function.equals("") && password.equals(confirm)){
                int taken;
                taken = userController.isTaken(username);
                if(taken == 0){
                    userController.save(function, name, surname, username, password);
                    errorLabel.setTextFill(Color.color(0, 1, 0));
                    errorLabel.setText("User created!");
                    errorLabel.setVisible(true);
                }
                else{
                    errorLabel.setTextFill(Color.color(1, 0, 0));
                    errorLabel.setText("Username is taken!");
                    errorLabel.setVisible(true);
                }
            }
            else if(!password.equals(confirm)){
                errorLabel.setTextFill(Color.color(1, 0, 0));
                errorLabel.setText("Passwords do not match!");
                errorLabel.setVisible(true);
            }
            else{
                errorLabel.setTextFill(Color.color(1, 0, 0));
                errorLabel.setText("Invalid register!");
                errorLabel.setVisible(true);
            }
        });

        this.gridPane.getChildren().add(functionsBox);
        this.gridPane.getChildren().add(functionLabel);
        this.gridPane.getChildren().add(mainLabel);
        this.gridPane.getChildren().add(createButton);
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

        GridPane.setConstraints(mainLabel, 0, 0);
        GridPane.setConstraints(nameLabel, 0, 1);
        GridPane.setConstraints(nameTextField, 1, 1);
        GridPane.setConstraints(surnameLabel, 0, 2);
        GridPane.setConstraints(surnameTextField, 1, 2);
        GridPane.setConstraints(usernameLabel, 0, 3);
        GridPane.setConstraints(usernameTextField, 1, 3);
        GridPane.setConstraints(passwordLabel, 0, 4);
        GridPane.setConstraints(passwordField, 1, 4);
        GridPane.setConstraints(confirmPasswordLabel, 0, 5);
        GridPane.setConstraints(confirmPasswordField, 1, 5);
        GridPane.setConstraints(functionLabel, 0, 6);
        GridPane.setConstraints(functionsBox, 1, 6);
        GridPane.setConstraints(errorLabel, 0, 7);
        GridPane.setConstraints(createButton, 0, 8);
        GridPane.setConstraints(backButton, 0, 9);

        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.color(1, 0, 0));

        functionsBox.getItems().add("Director");
        functionsBox.getItems().add("Manager");
        functionsBox.getItems().add("Traffic Manager");
        functionsBox.getItems().add("Business Manager");
        functionsBox.getItems().add("Design Manager");
        functionsBox.getItems().add("Customer");
        functionsBox.getItems().add("Transport");
        functionsBox.getItems().add("Warehouseman");
        functionsBox.getItems().add("Designer");

        this.window.show();
    }
}
