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

public class CreateGoalView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public CreateGoalView(Stage window){
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
        Button createGoal = new Button("Create Goal");
        Label weightLabel = new Label("Weight: ");
        Label priceLabel = new Label("Price: ");
        Label countLabel = new Label("Count: ");
        Label heightLabel = new Label("Height: ");
        Label widthLabel = new Label("Width: ");
        Label materialLabel = new Label("Material: ");
        TextField weightTextField = new TextField();
        TextField priceTextField = new TextField();
        TextField countTextField = new TextField();
        TextField heightTextField = new TextField();
        TextField widthTextField = new TextField();
        TextField materialTextField = new TextField();

        backButton.setOnAction(event ->{
            Router.routeTo(ROUTES.DESIGNER_HOME);
        });

        createGoal.setOnAction(event->{
            userController.createGoal(Float.parseFloat(weightTextField.getText()), Float.parseFloat(priceTextField.getText()), Integer.parseInt(countTextField.getText()), Float.parseFloat(heightTextField.getText()), Float.parseFloat(widthTextField.getText()), materialTextField.getText());
        });

        this.gridPane.getChildren().add(backButton);
        this.gridPane.getChildren().add(createGoal);
        this.gridPane.getChildren().add(weightLabel);
        this.gridPane.getChildren().add(priceLabel);
        this.gridPane.getChildren().add(countLabel);
        this.gridPane.getChildren().add(heightLabel);
        this.gridPane.getChildren().add(widthLabel);
        this.gridPane.getChildren().add(materialLabel);
        this.gridPane.getChildren().add(weightTextField);
        this.gridPane.getChildren().add(priceTextField);
        this.gridPane.getChildren().add(countTextField);
        this.gridPane.getChildren().add(heightTextField);
        this.gridPane.getChildren().add(widthTextField);
        this.gridPane.getChildren().add(materialTextField);

        GridPane.setConstraints(backButton, 0, 0);
        GridPane.setConstraints(weightLabel, 0, 1);
        GridPane.setConstraints(weightTextField, 1, 1);
        GridPane.setConstraints(priceLabel, 0, 2);
        GridPane.setConstraints(priceTextField, 1, 2);
        GridPane.setConstraints(countLabel, 0, 3);
        GridPane.setConstraints(countTextField, 1, 3);
        GridPane.setConstraints(heightLabel, 0, 4);
        GridPane.setConstraints(heightTextField, 1, 4);
        GridPane.setConstraints(widthLabel, 0, 5);
        GridPane.setConstraints(widthTextField, 1, 5);
        GridPane.setConstraints(materialLabel, 0, 6);
        GridPane.setConstraints(materialTextField, 1, 6);
        GridPane.setConstraints(createGoal, 0, 7);

        this.window.show();
    }
}
