package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.controller.WarehouseController;
import sample.router.ROUTES;
import sample.router.Router;

public class CustomerHomeView extends View{
    WarehouseController warehouseController;
    UserController userController;

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public CustomerHomeView(Stage window){
        warehouseController = new WarehouseController();
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
        Button sticksButton = new Button("View Sticks");
        Button ballsButton = new Button("View Balls");
        Button goalsButton = new Button("View Goals");
        Button buyButton = new Button("Buy");
        Label idLabel = new Label("ID: ");
        Label countLabel = new Label("Count: ");
        Label dashLabel = new Label("----------------------------------");
        TextField idTextField = new TextField();
        TextField countTextField = new TextField();

        logoutButton.setOnAction(event->{
            Router.routeTo(ROUTES.CUSTOMER_LOGIN);
        });

        sticksButton.setOnAction(event->{
            warehouseController.print("sticks");
        });

        ballsButton.setOnAction(event->{
            warehouseController.print("balls");
        });

        goalsButton.setOnAction(event->{
            warehouseController.print("goals");
        });

        buyButton.setOnAction(event->{
            userController.buy(Integer.parseInt(idTextField.getText()), Integer.parseInt(countTextField.getText()));
        });


        this.gridPane.getChildren().add(logoutButton);
        this.gridPane.getChildren().add(sticksButton);
        this.gridPane.getChildren().add(ballsButton);
        this.gridPane.getChildren().add(goalsButton);
        this.gridPane.getChildren().add(buyButton);
        this.gridPane.getChildren().add(idLabel);
        this.gridPane.getChildren().add(countLabel);
        this.gridPane.getChildren().add(dashLabel);
        this.gridPane.getChildren().add(idTextField);
        this.gridPane.getChildren().add(countTextField);

        GridPane.setConstraints(logoutButton, 0, 0);
        GridPane.setConstraints(sticksButton, 0, 1);
        GridPane.setConstraints(ballsButton, 1, 1);
        GridPane.setConstraints(goalsButton, 2, 1);
        GridPane.setConstraints(dashLabel, 0, 2);
        GridPane.setConstraints(idLabel, 0, 3);
        GridPane.setConstraints(idTextField, 1, 3);
        GridPane.setConstraints(countLabel, 0, 4);
        GridPane.setConstraints(countTextField, 1, 4);
        GridPane.setConstraints(buyButton, 0, 5);

        dashLabel.setVisible(false);

        this.window.show();
    }

}
