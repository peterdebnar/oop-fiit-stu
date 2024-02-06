package sample.model.user;

import sample.database.UserDatabase;

import java.util.ArrayList;

public class Manager extends User {

    public Manager(){};

    /**
     * Tri konštruktory - použitý overloading
     * @param ID - ID hlavného manažéra
     * @param username - uživateľské meno hlavného manažéra
     * @param password - heslo hlavného manažéra
     * @param name - meno hlavného manažéra
     * @param surname - priezvisko hlavného manažéra
     */

    public Manager(int ID, String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Manager(String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Metóda, s ktorou si dopravný manažér može vypísať svojich podriadených:
     * BusinessManager, TrafficManager, DesignManager
     */

    public void manage(){
        ArrayList<BusinessManager> businessManagers;
        ArrayList<TrafficManager> trafficManagers;
        ArrayList<DesignManager> designManagers;
        businessManagers = userDatabase.getBusinessManagers();
        trafficManagers = userDatabase.getTrafficManagers();
        designManagers = userDatabase.getDesignManagers();
        System.out.println("BUSINESS MANAGERS:");
        businessManagers.forEach(usr->{
            System.out.println("Username: " + usr.getUsername());
            System.out.println("Name: " + usr.getSurname());
            System.out.println("Surname: " + getSurname());
            System.out.println("----------------------------------------------------------");
        });
        System.out.println("############################################################");
        System.out.println("TRAFFIC MANAGERS:");
        trafficManagers.forEach(usr->{
            System.out.println("Username: " + usr.getUsername());
            System.out.println("Name: " + usr.getSurname());
            System.out.println("Surname: " + getSurname());
            System.out.println("----------------------------------------------------------");
        });
        System.out.println("############################################################");
        System.out.println("DESIGN MANAGERS:");
        designManagers.forEach(usr->{
            System.out.println("Username: " + usr.getUsername());
            System.out.println("Name: " + usr.getSurname());
            System.out.println("Surname: " + getSurname());
            System.out.println("----------------------------------------------------------");
        });
    }
}
