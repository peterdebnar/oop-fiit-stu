package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.database.UserDatabase;
import sample.model.user.*;
import sample.router.ROUTES;
import sample.router.Router;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        UserDatabase userDatabase = UserDatabase.getInstance();
        userDatabase.save(new Customer(101, "java", "python", "Peter", "Debnar"));
        userDatabase.save(new Director(102, "Dobby", "Harry", "Dusan", "Rozok"));
        userDatabase.save(new Designer(102, "designIsLove", "art", "Vilo", "Nezbrojil"));
        userDatabase.save(new Warehouseman(102, "storaage", "hokejka", "Kamila", "Pandurkova"));
        userDatabase.save(new Transport(102, "Booom", "Wroom", "Marek", "Klasica"));
        userDatabase.save(new Manager(102, "Lucid", "Dream", "Samuel", "Janosik"));
        userDatabase.save(new TrafficManager(102, "margaretka", "pomaranc", "Gabriel", "Sedy"));
        userDatabase.save(new DesignManager(102, "smola111", "smotana", "Marian", "Sandala"));
        userDatabase.save(new BusinessManager(102, "Gremlin", "dukat09", "Ignac", "Hlboky"));
        userDatabase.setEconomy(1000);
        primaryStage.setTitle("DebnikFloorball");
        Router.window = primaryStage;
        Router.routeTo(ROUTES.MAIN_LOGIN);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
