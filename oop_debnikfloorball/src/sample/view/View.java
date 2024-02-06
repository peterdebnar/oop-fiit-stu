package sample.view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class View {
    protected GridPane gridPane;
    protected Stage window;
    protected Scene scene;

    public abstract void render();
}
