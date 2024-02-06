package sample.model.exception;

/**
 * Výnimka - použivateľské meno je už v databáze
 */

public class UsernameTakenException extends Exception{
    public UsernameTakenException(){
        super("Username is already taken!");
    }

    public UsernameTakenException(String message){
        super(message);
    }
}
