package sample.model.user;

import sample.database.TaskDatabase;
import sample.database.UserDatabase;
import sample.model.user.Manager;

import java.util.ArrayList;

public class TrafficManager extends Manager {
    TaskDatabase taskDatabase;

    /**
     * Dva konštruktory - použitý overloading
     * @param ID - ID dopravného manažéra
     * @param username - uživateľské meno dopravného manažéra
     * @param password - heslo dopravného manažéra
     * @param name - meno dopravného manažéra
     * @param surname - priezvisko dopravného manažéra
     */

    public TrafficManager(int ID, String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        taskDatabase = TaskDatabase.getInstance();
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public TrafficManager(String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        taskDatabase = TaskDatabase.getInstance();
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Metóda, s ktorou si dopravný manažér može vypísať svojich podriadených:
     * Transport
     */

    public void manage(){
        ArrayList<Transport> transport;
        transport = userDatabase.getTransport();
        transport.forEach(usr->{
            System.out.println("Username: " + usr.getUsername());
            System.out.println("Name: " + usr.getSurname());
            System.out.println("Surname: " + getSurname());
            System.out.println("----------------------------------------------------------");
        });
    }

    /**
     * Metóda na vytvorenie úlohy pre dopravcu
     * @param ID - ID tovaru, ktorý treba prepraviť
     * @param count - počet tovaru
     * @param destination - miesto, kam treba tovar doviezť
     */

    public void createTask(int ID, int count, String destination){
        taskDatabase.set(ID, count, destination);
    }
}
