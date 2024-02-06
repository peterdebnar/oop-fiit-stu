package sample.model.user;

import sample.database.UserDatabase;
import sample.model.equipment.Equipment;
import sample.model.warehouse.Warehouse;

public class Customer extends User {
    Warehouse warehouse;

    /**
     * Tri konštruktory - použitý overloading
     * @param ID - ID zákazníka
     * @param username - uživateľské meno zákazníka
     * @param password - heslo zákazníka
     * @param name - meno zákazníka
     * @param surname - priezvisko zákazníka
     */

    public Customer(int ID, String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        warehouse = Warehouse.getInstance();
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Customer(String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        warehouse = Warehouse.getInstance();
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Metóda na kúpenie tovaru
     * @param id - ID tovaru, ktorý kúpi zákazník
     * @param count - počet kusov tovaru, ktorý kúpi zákazník
     */

    public void buy(int id, int count){
        float oldEconomy = userDatabase.getEconomy();
        Equipment equipment = warehouse.get(id);
        if(count <= equipment.getCount()){
            userDatabase.setEconomy(oldEconomy + count*equipment.getPrice());
            warehouse.setCount(id, equipment.getCount()-count);
        }
    }
}
