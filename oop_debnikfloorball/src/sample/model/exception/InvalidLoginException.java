package sample.model.exception;

/**
 * Výnimka - zlé prihlasovacie údaje (zrejme nevyplnená informácia)
 */

public class InvalidLoginException extends Exception{
    public InvalidLoginException(){
        super("Invalid login input!");
    }

    public InvalidLoginException(String message){
        super(message);
    }
}
