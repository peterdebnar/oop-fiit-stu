package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.router.ROUTES;
import sample.router.Router;

public class MainLoginView extends View{

    /**
     * konštruktor pre TransportHomeView
     * @param window - Stage class
     */

    public MainLoginView(Stage window){
        this.gridPane = new GridPane();
        this.window = window;
        this.scene = new Scene(this.gridPane, 800, 600);
        this.window.setScene(this.scene);
    }

    /**
     * render - zobrazí okno na monitore užívateľa
     */

    public void render(){
        Button buttonCus = new Button("I am a Customer");
        Button buttonEmp = new Button("I am an Employee");
        Label welcome = new Label("Welcome to DebnikFloorball");

        buttonCus.setOnAction(event->{
            Router.routeTo(ROUTES.CUSTOMER_LOGIN);
        });
        buttonEmp.setOnAction(event->{
            Router.routeTo(ROUTES.EMPLOYEE_LOGIN);
        });

        this.gridPane.getChildren().add(welcome);
        this.gridPane.getChildren().add(buttonCus);
        this.gridPane.getChildren().add(buttonEmp);

        GridPane.setConstraints(buttonCus, 0, 1);
        GridPane.setConstraints(buttonEmp, 0, 2);

        this.window.show();
    }
}
