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

public class CreateBallView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public CreateBallView(Stage window){
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
        Button createBall = new Button("Create Ball");
        Label weightLabel = new Label("Weight: ");
        Label priceLabel = new Label("Price: ");
        Label countLabel = new Label("Count: ");
        Label colorLabel = new Label("Color: ");
        TextField weightTextField = new TextField();
        TextField priceTextField = new TextField();
        TextField countTextField = new TextField();
        TextField colorTextField = new TextField();

        backButton.setOnAction(event ->{
            Router.routeTo(ROUTES.DESIGNER_HOME);
        });

        createBall.setOnAction(event->{
            userController.createBall(Float.parseFloat(weightTextField.getText()), Float.parseFloat(priceTextField.getText()), Integer.parseInt(countTextField.getText()), colorTextField.getText());
        });

        this.gridPane.getChildren().add(backButton);
        this.gridPane.getChildren().add(createBall);
        this.gridPane.getChildren().add(weightLabel);
        this.gridPane.getChildren().add(priceLabel);
        this.gridPane.getChildren().add(countLabel);
        this.gridPane.getChildren().add(colorLabel);
        this.gridPane.getChildren().add(weightTextField);
        this.gridPane.getChildren().add(priceTextField);
        this.gridPane.getChildren().add(countTextField);
        this.gridPane.getChildren().add(colorTextField);

        GridPane.setConstraints(backButton, 0, 0);
        GridPane.setConstraints(weightLabel, 0, 1);
        GridPane.setConstraints(weightTextField, 1, 1);
        GridPane.setConstraints(priceLabel, 0, 2);
        GridPane.setConstraints(priceTextField, 1, 2);
        GridPane.setConstraints(countLabel, 0, 3);
        GridPane.setConstraints(countTextField, 1, 3);
        GridPane.setConstraints(colorLabel, 0, 4);
        GridPane.setConstraints(colorTextField, 1, 4);
        GridPane.setConstraints(createBall, 0, 5);

        this.window.show();
    }
}
