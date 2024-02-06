package sample.model.equipment;

public class Ball extends Equipment{
    protected String color;

    /**
     * 2 konštruktory na vytvorenie loptičky
     * @param ID - ID loptičky
     * @param weight - váha loptičky
     * @param price - cena loptičky
     * @param count - počet kusov loptičiek
     * @param color - farba loptičky
     */

    public Ball(int ID, float weight, float price, int count, String color){
        this.ID = ID;
        this.weight = weight;
        this.price = price;
        this.count = count;
        this.color = color;
    }

    public Ball(float weight, float price, int count, String color){
        this.ID = nextID++;
        this.weight = weight;
        this.price = price;
        this.count = count;
        this.color = color;
    }

    /**
     * metóda na získanie farby loptičky
     * @return - farba loptičky
     */

    public String getColor(){
        return this.color;
    }

    /**
     * metóda na nastavenie farby loptičky
     * @return - farba loptičky
     */

    public void setColor(String color){
        this.color = color;
    }
}
