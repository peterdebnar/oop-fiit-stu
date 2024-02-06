package sample.model.user;

import sample.database.TaskDatabase;

public class Transport extends User {
    TaskDatabase taskDatabase;

    /**
     * Dva konštruktory - použitý overloading
     * @param ID - ID dopravcu
     * @param username - uživateľské meno dopravcu
     * @param password - heslo dopravcu
     * @param name - meno dopravcu
     * @param surname - priezvisko dopravcu
     */

    public Transport(int ID, String username, String password, String name, String surname){
        taskDatabase = TaskDatabase.getInstance();
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Transport(String username, String password, String name, String surname){
        taskDatabase = TaskDatabase.getInstance();
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Metóda na prezretie úloh, ktoré má dopravca vyriešiť
     */

    public void viewTasks(){
        taskDatabase.printTasks();
    }
}
