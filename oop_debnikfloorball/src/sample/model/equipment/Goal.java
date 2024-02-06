package sample.model.equipment;

public class Goal extends Equipment {
    protected float height;
    protected float width;
    protected String material;

    /**
     * 2 konštruktory na vytvorenie bránky
     * @param ID - ID bránky
     * @param weight - váha bránky
     * @param price - cena bránky
     * @param count - počet kusov bránok
     * @param height - výška bránky
     * @param width - šírka bránky
     * @param material - materiál, z ktorého bola bránka vyrobená
     */

    public Goal(int ID, float weight, float price, int count, float height, float width, String material){
        this.ID = ID;
        this.weight = weight;
        this.price = price;
        this.count = count;
        this.height = height;
        this.width = width;
        this.material = material;
    }

    public Goal(float weight, float price, int count, float height, float width, String material){
        this.ID = nextID++;
        this.weight = weight;
        this.price = price;
        this.count = count;
        this.height = height;
        this.width = width;
        this.material = material;
    }

    /**
     * metóda na získanie výšky bránky
     * @return - výška bránky
     */

    public float getHeight(){
        return this.height;
    }

    /**
     * metóda na nastavenie výšky bránky
     * @param height - výška bránky
     */

    public void setHeight(float height){
        this.height = height;
    }

    /**
     * metóda na získanie šírky bránky
     * @return - šírka bránky
     */

    public float getWidth(){
        return this.width;
    }

    /**
     * metóda na nastavenie šírky bránky
     * @return - šírka bránky
     */

    public void setWidth(float width){
        this.width = width;
    }

    /**
     * metóda na získanie materiálu, z ktorého bola bránka vyrobená
     * @return - materiál
     */

    public String getMaterial(){
        return this.material;
    }

    /**
     * metóda na nastavenie materiálu, z ktorého bola bránka vyrobená
     * @return - materiál
     */

    public void setMaterial(String material){
        this.material = material;
    }
}
