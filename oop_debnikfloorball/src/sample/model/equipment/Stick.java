package sample.model.equipment;

public class Stick extends Equipment {
    protected int length;
    protected String material;
    protected String bladeSide;
    protected String grip;
    protected int flex;

    /**
     * 2 konštruktory pre vytvorenie hokejky
     * @param ID - ID hokejky
     * @param weight - váha hokejky
     * @param price - cena hokejky
     * @param count - počet kusov hokejok
     * @param length - dĺžka hokejky
     * @param material - materiál, z ktorého bola hokejka vyrobená
     * @param bladeSide - strana čepele
     * @param grip - úchyt
     * @param flex - ohybnosť hokejky
     */

    public Stick(int ID, float weight, float price, int count, int length, String material, String bladeSide, String grip, int flex){
        this.ID = ID;
        this.weight = weight;
        this.price = price;
        this.count = count;
        this.length = length;
        this.material = material;
        this.bladeSide = bladeSide;
        this.grip = grip;
        this.flex = flex;
    }

    public Stick(float weight, float price, int count, int length, String material, String bladeSide, String grip, int flex){
        this.ID = nextID++;
        this.weight = weight;
        this.price = price;
        this.count = count;
        this.length = length;
        this.material = material;
        this.bladeSide = bladeSide;
        this.grip = grip;
        this.flex = flex;
    }

    /**
     * metóda na získanie dĺžky hokejky
     * @return - vracia dĺžku hokejky
     */

    public int getLength(){
        return this.length;
    }

    /**
     * metóda na nastavenie dĺžky hokejky
     * @param length - nová dĺžka hokejky
     */

    public void setLength(int length){
        this.length = length;
    }

    /**
     * metóda na získanie materiálu, z ktorého bola hokejka vyrobená
     * @return - vracia materiál
     */

    public String getMaterial(){
        return this.material;
    }

    /**
     * metóda na nastavenie materiálu, z ktorého bola hokejka vyrobená
     * @param material - materiál
     */

    public void setMaterial(String material){
        this.material = material;
    }

    /**
     * metóda na získanie strany čepele, s ktorú má hokejka
     * @return - strana čepele
     */

    public String getBladeSide(){
        return this.bladeSide;
    }

    /**
     * metóda na nastaveniestrany čepele, s ktorú má hokejka
     * @param bladeSide - strana čepele
     */

    public void setBladeSide(String bladeSide){
        this.bladeSide = bladeSide;
    }

    /**
     * metóda na získanie úchytu, ktorý sa na hokejke používa
     * @return - úchyt
     */

    public String getGrip(){
        return this.grip;
    }

    /**
     * metóda na nastavenie úchytu, ktorý sa na hokejke používa
     * @param grip - úchyt
     */

    public void setGrip(String grip){
        this.grip = grip;
    }

    /**
     * metóda na získanie ohybnosti hokejky
     * @return - ohybnosť hokejky
     */

    public int getFlex(){
        return this.flex;
    }
}
