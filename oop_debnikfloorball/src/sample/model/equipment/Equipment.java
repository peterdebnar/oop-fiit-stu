package sample.model.equipment;

public abstract class Equipment implements EquipmentInterface {
    protected int ID;
    protected static int nextID = 10000;
    protected float weight;
    protected float price;
    protected int count;

    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public float getWeight(){
        return this.weight;
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

    public float getPrice(){
        return this.price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count){
        this.count = count;
    }
}