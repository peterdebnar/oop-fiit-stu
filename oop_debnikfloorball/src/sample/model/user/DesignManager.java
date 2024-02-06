package sample.model.user;

import sample.database.UserDatabase;

import java.util.ArrayList;

public class DesignManager extends Manager {

    /**
     * Dva konštruktory - použitý overloading
     * @param ID - ID dizajnového manažéra
     * @param username - uživateľské meno dizajnového manažéra
     * @param password - heslo dizajnového manažéra
     * @param name - meno dizajnového manažéra
     * @param surname - priezvisko dizajnového manažéra
     */

    public DesignManager(int ID, String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public DesignManager(String username, String password, String name, String surname){
        userDatabase = UserDatabase.getInstance();
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Metóda, s ktorou si dopravný manažér može vypísať svojich podriadených:
     * Designer
     */

    public void manage(){
        ArrayList<Designer> designers;
        designers = userDatabase.getDesigners();
        designers.forEach(usr->{
            System.out.println("Username: " + usr.getUsername());
            System.out.println("Name: " + usr.getSurname());
            System.out.println("Surname: " + getSurname());
            System.out.println("----------------------------------------------------------");
        });
    }
}
