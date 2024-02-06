package sample.database;

import sample.model.user.*;

import java.util.ArrayList;

/**
 * Databáza uživateľov s použitím návrhového vzoru Singleton
 */

public class UserDatabase implements Database{

    private final ArrayList<Director> directorDatabase = new ArrayList<>();
    private final ArrayList<Customer> customerDatabase = new ArrayList<>();
    private final ArrayList<Designer> designerDatabase = new ArrayList<>();
    private final ArrayList<Manager> managerDatabase = new ArrayList<>();
    private final ArrayList<BusinessManager> businessManagerDatabase = new ArrayList<>();
    private final ArrayList<TrafficManager> trafficManagerDatabase = new ArrayList<>();
    private final ArrayList<DesignManager> designManagerDatabase = new ArrayList<>();
    private final ArrayList<Transport> transportDatabase = new ArrayList<>();
    private final ArrayList<Warehouseman> warehousemanDatabase = new ArrayList<>();
    private User loggedUser;
    private float economy;

    private UserDatabase(){}

    private static UserDatabase instance;

    /**
     * Princíp Singletonu - nevytvára sa nový objekt, používa sa stále len 1
     * @return - vráti inštanciu
     */

    public static UserDatabase getInstance(){
        if(instance == null){
            instance = new UserDatabase();
        }
        return instance;
    }

    /**
     * metóda na získanie uživateľa podľa ID
     * @param ID - ID uživateľa
     * @return - vráti uživateľa
     */

    public User get(int ID){
        for(User user: directorDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        for(User user: customerDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        for(User user: designerDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        for(User user: managerDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        for(User user: transportDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        for(User user: warehousemanDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        for(User user: businessManagerDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        for(User user: designManagerDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        for(User user: trafficManagerDatabase ){
            if(user.getID() == ID){
                return user;
            }
        }
        return null;
    }

    /**
     * metóda na získanie uživateľa podĺa uživateľškého mena
     * @param username - uživateľské meno
     * @return - uživateľ
     */

    public User get(String username){
        for(User user: directorDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: customerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: designerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: managerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: transportDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: warehousemanDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: businessManagerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: designManagerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: trafficManagerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    /**
     * metóda na získanie zákazníka podľa uživateľského mena
     * @param username - uživateľské meno
     * @return - vráti uživateľa (zákazníka)
     */

    public Customer getCustomer(String username){
        for(Customer user: customerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    /**
     * metóda na získanie zamestnanca podľa uživateľského mena
     * @param username - uživateľské meno
     * @return - vráti uživateľa (zamestnanca)
     */

    public User getEmployee(String username){
        for(User user: directorDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: designerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: managerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: transportDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: warehousemanDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: businessManagerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: designManagerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        for(User user: trafficManagerDatabase ){
            if(user.getUsername().equals(username)){
                return user;
            }
        }

        return null;
    }

    /**
     * meróda na získanie zoznamu dizajnérov
     * @return - vráti pole dizajnérov
     */

    public ArrayList<Designer> getDesigners(){
        return designerDatabase;
    }

    /**
     * meróda na získanie zoznamu dopravcov
     * @return - vráti pole dopravcov
     */

    public ArrayList<Transport> getTransport(){
        return transportDatabase;
    }

    /**
     * meróda na získanie zoznamu business manažérov
     * @return - vráti pole business manažérov
     */

    public ArrayList<BusinessManager> getBusinessManagers(){
        return businessManagerDatabase;
    }

    /**
     * meróda na získanie zoznamu dopravných manažérov
     * @return - vráti pole dopravných manažérov
     */

    public ArrayList<TrafficManager> getTrafficManagers(){
        return trafficManagerDatabase;
    }

    /**
     * meróda na získanie zoznamu dizajnových manažérov
     * @return - vráti pole dizajnových manažérov
     */

    public ArrayList<DesignManager> getDesignManagers(){
        return designManagerDatabase;
    }

    /**
     * metóda na uloženie uživateľa do Databázy
     * @param user - uživateľ
     */

    public void save(User user){
        if(user instanceof Director){
            directorDatabase.add((Director)user);
        }
        else if(user instanceof Designer){
            designerDatabase.add((Designer)user);
        }
        else if(user instanceof TrafficManager){
            trafficManagerDatabase.add((TrafficManager) user);
        }
        else if(user instanceof BusinessManager){
            businessManagerDatabase.add((BusinessManager) user);
        }
        else if(user instanceof DesignManager){
            designManagerDatabase.add((DesignManager)user);
        }
        else if(user instanceof Manager){
            managerDatabase.add((Manager)user);
        }
        else if(user instanceof Transport){
            transportDatabase.add((Transport)user);
        }
        else if(user instanceof Warehouseman){
            warehousemanDatabase.add((Warehouseman)user);
        }
        else if(user instanceof Customer){
            customerDatabase.add((Customer)user);
        }
        else{
            System.out.println("SAVE FAILED!");
        }
    }

    /**
     * metóda na zistenie zhody uživateľského mena z parametra s uživateľským menom z Databázy
     * @param username - uživateľské meno 1
     * @return - 1 ak už je v databáze toto meno, 0 ak nie
     */

    public int compare(String username){
        for(User user: directorDatabase){
            if(user.getUsername().equals(username)){
                return 1;
            }
        }
        for(User user: designerDatabase){
            if(user.getUsername().equals(username)){
                return 1;
            }
        }
        for(User user: transportDatabase){
            if(user.getUsername().equals(username)){
                return 1;
            }
        }
        for(User user: warehousemanDatabase){
            if(user.getUsername().equals(username)){
                return 1;
            }
        }
        for(User user: customerDatabase){
            if(user.getUsername().equals(username)){
                return 1;
            }
        }
        for(User user: trafficManagerDatabase){
            if(user.getUsername().equals(username)){
                return 1;
            }
        }
        for(User user: designManagerDatabase){
            if(user.getUsername().equals(username)){
                return 1;
            }
        }
        for(User user: businessManagerDatabase){
            if(user.getUsername().equals(username)){
                return 1;
            }
        }
        return 0;
    }

    /**
     * metóda na nastavenie lognutého(aktívneho) uživateľa
     * @param user - uživateľ
     */

    public void setLoggedUser(User user){
        loggedUser = user;
        System.out.println(loggedUser);
    }

    /**
     * metóda na získanie lognutého(aktívneho) uživateľa
     * @return - uživateľ
     */

    public User getLoggedUser(){
        return loggedUser;
    }


    public float getEconomy(){
        return economy;
    }

    public void setEconomy(float economy){
        this.economy = economy;
    }
}
