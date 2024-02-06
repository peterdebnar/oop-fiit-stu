package sample.model.user;

import sample.database.UserDatabase;

public class BusinessManager extends Manager {

    public BusinessManager(int ID, String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public BusinessManager(String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public void manage(){
        System.out.println("CURRENT BALANCE: " + userDatabase.getEconomy() + "$");
    }
}
