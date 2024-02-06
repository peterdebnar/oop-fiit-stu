package sample.model.user;

public class Director extends User {

    /**
     * Dva konštruktory - použitý overloading
     * @param ID - ID riaditeľa
     * @param username - uživateľské meno riaditeľa
     * @param password - heslo riaditeľa
     * @param name - meno riaditeľa
     * @param surname - priezvisko riaditeľa
     */

    public Director(int ID, String username, String password, String name, String surname){
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Director(String username, String password, String name, String surname){
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
