package sample.model.task;

public class Task {
    private int ID;
    private int count;
    private String destination;

    /**
     * konštruktor na vytvorenie úlohy
     * @param ID - ID produktu, ktorý treba odviesť
     * @param count - počet kusov produktu, ktorý treba odviesť
     * @param destination - miesto, kam treba produkt odviesť
     */

    public Task(int ID, int count, String destination){
        this.ID = ID;
        this.count = count;
        this.destination = destination;
    }

    /**
     * Metóda get na vrátenie ID
     * @return - vráti ID tovaru
     */

    public int getID(){
        return this.ID;
    }

    /**
     * nastaví ID tovaru
     * @param ID - nové ID tovaru
     */

    public void setID(int ID){
        this.ID = ID;
    }

    /**
     * Metóda get na vrátenie počtu kusov tovaru
     * @return - vráti počet kusov tovaru
     */

    public int getCount(){
        return this.count;
    }

    /**
     * nastaví nový počet kusov tovaru, ktorý treba odviesť
     * @param count - nový počet kusov tovaru
     */

    public void setCount(int count){
        this.count = count;
    }

    /**
     * Metóda get na vrátenie miesta, kam treba tovar doviesť
     * @return - vráti miesto, kam treba tovar doviesť
     */

    public String getDestination(){
        return this.destination;
    }

    /**
     * nastaví nové miesto, kam treba tovar doviesť
     * @param destination - nové miesto
     */

    public void setDestination(String destination){
        this.destination = destination;
    }
}
