package sample.database;

import sample.model.user.*;

import java.util.ArrayList;

public interface Database {
    User get(int ID);
    User get(String username);
    Customer getCustomer(String username);
    User getEmployee(String username);
    ArrayList<Designer> getDesigners();
    public ArrayList<Transport> getTransport();
    ArrayList<BusinessManager> getBusinessManagers();
    ArrayList<TrafficManager> getTrafficManagers();
    ArrayList<DesignManager> getDesignManagers();
    void save(User user);
    int compare(String username);
    void setLoggedUser(User user);
    User getLoggedUser();
    float getEconomy();
    void setEconomy(float economy);
}

