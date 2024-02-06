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


public class CreateStickView extends View{
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public CreateStickView(Stage window){
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
        Label weightLabel = new Label("Weight: ");
        Label priceLabel = new Label("Price: ");
        Label countLabel = new Label("Count: ");
        Label lengthLabel = new Label("Length: ");
        Label materialLabel = new Label("Material: ");
        Label bladeSideLabel = new Label("Blade Side: ");
        Label gripLabel = new Label("Grip: ");
        Label flexLabel = new Label("Flex: ");
        TextField weightTextField = new TextField();
        TextField priceTextField = new TextField();
        TextField countTextField = new TextField();
        TextField lengthTextField = new TextField();
        TextField materialTextField = new TextField();
        TextField bladeSideTextField = new TextField();
        TextField gripTextField = new TextField();
        TextField flexTextField = new TextField();
        Button createStick = new Button("Create Stick");
        Button backButton = new Button("Back");

        createStick.setOnAction(event->{
            userController.createStick(Float.parseFloat(weightTextField.getText()), Float.parseFloat(priceTextField.getText()), Integer.parseInt(countTextField.getText()), Integer.parseInt(lengthTextField.getText()), materialTextField.getText(), bladeSideTextField.getText(), gripTextField.getText(), Integer.parseInt(flexTextField.getText()));
        });

        backButton.setOnAction(event ->{
            Router.routeTo(ROUTES.DESIGNER_HOME);
        });

        this.gridPane.getChildren().add(weightLabel);
        this.gridPane.getChildren().add(priceLabel);
        this.gridPane.getChildren().add(countLabel);
        this.gridPane.getChildren().add(lengthLabel);
        this.gridPane.getChildren().add(materialLabel);
        this.gridPane.getChildren().add(bladeSideLabel);
        this.gridPane.getChildren().add(gripLabel);
        this.gridPane.getChildren().add(flexLabel);
        this.gridPane.getChildren().add(weightTextField);
        this.gridPane.getChildren().add(priceTextField);
        this.gridPane.getChildren().add(countTextField);
        this.gridPane.getChildren().add(lengthTextField);
        this.gridPane.getChildren().add(materialTextField);
        this.gridPane.getChildren().add(bladeSideTextField);
        this.gridPane.getChildren().add(gripTextField);
        this.gridPane.getChildren().add(flexTextField);
        this.gridPane.getChildren().add(createStick);
        this.gridPane.getChildren().add(backButton);

        GridPane.setConstraints(backButton, 0, 0);
        GridPane.setConstraints(weightLabel, 0, 1);
        GridPane.setConstraints(weightTextField, 1, 1);
        GridPane.setConstraints(priceLabel, 0, 2);
        GridPane.setConstraints(priceTextField, 1, 2);
        GridPane.setConstraints(countLabel, 0, 3);
        GridPane.setConstraints(countTextField, 1, 3);
        GridPane.setConstraints(lengthLabel, 0, 4);
        GridPane.setConstraints(lengthTextField, 1, 4);
        GridPane.setConstraints(materialLabel, 0, 5);
        GridPane.setConstraints(materialTextField, 1, 5);
        GridPane.setConstraints(bladeSideLabel, 0, 6);
        GridPane.setConstraints(bladeSideTextField, 1, 6);
        GridPane.setConstraints(gripLabel, 0, 7);
        GridPane.setConstraints(gripTextField, 1, 7);
        GridPane.setConstraints(flexLabel, 0, 8);
        GridPane.setConstraints(flexTextField, 1, 8);
        GridPane.setConstraints(createStick, 0, 9);

        this.window.show();
    }
}
