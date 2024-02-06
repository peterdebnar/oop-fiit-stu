package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.router.ROUTES;
import sample.router.Router;

public class WarehousemanHomeView extends View{

    /**
     * konštruktor pre WarehousemanHomeView
     * @param window - Stage class
     */

    public WarehousemanHomeView(Stage window){
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

        backButton.setOnAction(event->{
            Router.routeTo(ROUTES.EMPLOYEE_LOGIN);
        });

        this.gridPane.getChildren().add(backButton);

        GridPane.setConstraints(backButton, 0, 0);
        this.window.show();
    }
}
