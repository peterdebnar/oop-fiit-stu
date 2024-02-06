package sample.controller;

import sample.database.UserDatabase;
import sample.model.exception.InvalidLoginException;
import sample.model.exception.UsernameTakenException;
import sample.model.user.*;

import java.util.ArrayList;

/**
 * premostenie medzi view a model
 */

public class UserController {
    UserDatabase userDatabase;

    /**
     * konštruktor pre  controller
     */

    public UserController(){
        userDatabase = UserDatabase.getInstance();
    }

    /**
     * verifikácia loginu zákazníka
     * @param username - uživateľské meno zákazníka
     * @param password - heslo zákazníka
     * @return - 1 ak sa login podaril, 0 ak nie
     */

    public int verifyCustomer(String username, String password){
        Customer customer;
        try{
            customer = userDatabase.getCustomer(username);
            if(customer == null){
                throw new InvalidLoginException();
            }
            if(customer.verify(password) == 0){
                throw new InvalidLoginException();
            }
        }catch (InvalidLoginException exception){
            System.out.println(exception.getMessage());
            return 0;
        }
        return 1;
    }

    /**
     * metóda na verifikáciu loginu zamestnanca
     * @param username - uživateľské meno zamestnanca
     * @param password - heslo zamestnanca
     * @return - string obsahujúci typ zamestnanca alebo "" ak sa nepodarilo
     */

    public String verifyEmployee(String username, String password){
        User employee;
        try{
            employee = userDatabase.getEmployee(username);
            if(employee == null){
                throw new InvalidLoginException();
            }
            if(employee.verify(password) == 1){
                userDatabase.setLoggedUser(employee);
                if(employee instanceof Director){
                    return "director";
                }
                if(employee instanceof Designer){
                    return "designer";
                }
                if(employee instanceof Transport){
                    return "transport";
                }
                if(employee instanceof Warehouseman){
                    return "warehouseman";
                }
                if(employee instanceof TrafficManager){
                    return "traffic";
                }
                if(employee instanceof Manager){
                    return "manager";
                }
            }
            throw new InvalidLoginException();
        }catch(InvalidLoginException exception){
            System.out.println(exception.getMessage());
            return "";
        }
    }

    /**
     * metóda, ktorá zistí, či je uživateľské meno  už obsadené
     * @param username - uživateľské meno
     * @return - 1 ak je obsadené, 0 ak nie
     */

    public int isTaken(String username){
        int taken;
        try{
            taken = userDatabase.compare(username);
            if(taken == 1){
                throw new UsernameTakenException();
            }
            else{
                return 0;
            }
        }catch (UsernameTakenException exception){
            System.out.println(exception.getMessage());
            return 1;
        }
    }

    /**
     * metóda na zapísanie zamestnanca do databázy
     * @param employee - zákazník
     * @param name - meno
     * @param surname - priezvisko
     * @param username - uživateľské meno
     * @param password - heslo
     */

    public void save(String employee, String name, String surname, String username, String password){
        switch(employee){
            case "Customer":
                userDatabase.save(new Customer(username, password, name, surname));
                break;
            case "Director":
                userDatabase.save(new Director(username, password, name, surname));
                break;
            case "Designer":
                userDatabase.save(new Designer(username, password, name, surname));
                break;
            case "Transport":
                userDatabase.save(new Transport(username, password, name, surname));
                break;
            case "Warehouseman":
                userDatabase.save(new Warehouseman(username, password, name, surname));
                break;
            case "Manager":
                userDatabase.save(new Manager(username, password, name, surname));
                break;
            case "Traffic Manager":
                userDatabase.save(new TrafficManager(username, password, name, surname));
                break;
            case "Business Manager":
                userDatabase.save(new BusinessManager(username, password, name, surname));
                break;
            case "Design Manager":
                userDatabase.save(new DesignManager(username, password, name, surname));
                break;
        }
    }

    /**
     * prepojenie view a Manager.manage
     */

    public void manage(){
        Manager loggedUser = (Manager)userDatabase.getLoggedUser();
        loggedUser.manage();
    }

    /**
     * prepojenie view a Customer.buy
     */

    public void buy(int id, int count){
        Customer loggedCustomer = (Customer) userDatabase.getLoggedUser();
        loggedCustomer.buy(id, count);
    }

    /**
     * prepojenie view a TrafficManager.createTask()
     */

    public void createTask(int ID, int count, String destination){
        TrafficManager loggedUser = (TrafficManager) userDatabase.getLoggedUser();
        loggedUser.createTask(ID, count, destination);
    }

    /**
     * prepojenie view a Transport.viewTasks()
     */

    public void viewTasks(){
        Transport loggedUser = (Transport) userDatabase.getLoggedUser();
        loggedUser.viewTasks();
    }

    /**
     * prepojenie view a Designer.createStick()
     */

    public void createStick(float weight, float price, int count, int length, String material, String bladeSide, String grip, int flex){
        Designer loggedUser = (Designer) userDatabase.getLoggedUser();
        loggedUser.createStick(weight, price, count, length, material, bladeSide, grip, flex);
    }

    /**
     * prepojenie view a Designer.createGoal()
     */

    public void createGoal(float weight, float price, int count, float height, float width, String material){
        Designer loggedUser = (Designer) userDatabase.getLoggedUser();
        loggedUser.createGoal(weight, price, count, height, width, material);
    }

    /**
     * prepojenie view a Designer.createBall()
     */

    public void createBall(float weight, float price, int count, String color){
        Designer loggedUser = (Designer) userDatabase.getLoggedUser();
        loggedUser.createBall(weight, price, count, color);
    }
}
