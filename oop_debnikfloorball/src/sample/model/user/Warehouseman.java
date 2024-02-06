package sample.model.user;

import sample.model.user.User;

public class Warehouseman extends User {
    /**
     * Dva konštruktory - použitý overloading
     * @param ID - ID skladníka
     * @param username - uživateľské meno skaldníka
     * @param password - heslo skladníka
     * @param name - meno skladníka
     * @param surname - priezvisko skladníka
     */

    public Warehouseman(int ID, String username, String password, String name, String surname){
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Warehouseman(String username, String password, String name, String surname){
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
