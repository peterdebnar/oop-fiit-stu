package sample.router;

import javafx.stage.Stage;
import sample.view.*;

public class Router {
    public static Stage window;

    /**
     * prechod medzi oknami
     */

    public static void routeTo(ROUTES route){
        View view = null;

        if(route == ROUTES.CUSTOMER_LOGIN){
            view = new CustomerLoginView(window);
        }
        else if(route == ROUTES.CUSTOMER_REGISTER){
            view = new CustomerRegisterView(window);
        }
        else if(route == ROUTES.EMPLOYEE_LOGIN){
            view = new EmployeeLoginView(window);
        }
        else if(route == ROUTES.MAIN_LOGIN){
            view = new MainLoginView(window);
        }
        else if(route == ROUTES.CUSTOMER_HOME){
            view = new CustomerHomeView(window);
        }
        else if(route == ROUTES.DIRECTOR_HOME){
            view = new DirectorHomeView(window);
        }
        else if(route == ROUTES.DESIGNER_HOME){
            view = new DesignerHomeView(window);
        }
        else if(route == ROUTES.TRANSPORT_HOME){
            view = new TransportHomeView(window);
        }
        else if(route == ROUTES.WAREHOUSEMAN_HOME){
            view = new WarehousemanHomeView(window);
        }
        else if(route == ROUTES.MANAGER_HOME){
            view = new ManagerHomeView(window);
        }
        else if(route == ROUTES.TRAFFIC_HOME){
            view = new TrafficManagerHomeView(window);
        }
        else if(route == ROUTES.CREATE_STICK){
            view = new CreateStickView(window);
        }
        else if(route == ROUTES.CREATE_BALL){
            view = new CreateBallView(window);
        }
        else if(route == ROUTES.CREATE_GOAL){
            view = new CreateGoalView(window);
        }
        if(view != null){
            view.render();
        }
    }
}
