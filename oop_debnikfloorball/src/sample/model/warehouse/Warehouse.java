package sample.model.warehouse;

import sample.model.equipment.Ball;
import sample.model.equipment.Equipment;
import sample.model.equipment.Goal;
import sample.model.equipment.Stick;

import java.util.ArrayList;

/**
 * Warehouse - sklad, na ktorý som využil návrhový vzor Singleton
 * V sklade sa nachádzajú florbalové loptičky, hokejky a bránky
 */

public class Warehouse implements WarehouseInterface{
    private final ArrayList<Ball> ballList = new ArrayList<>();
    private final ArrayList<Stick> stickList = new ArrayList<>();
    private final ArrayList<Goal> goalList = new ArrayList<>();

    private static Warehouse instance;

    private Warehouse(){}

    /**
     * Princíp Singletonu - nevytvára sa nový objekt, používa sa stále len 1
     * @return - vráti inštanciu
     */

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    /**
     * Metóda na získanie produktu zo skladu
     * @param ID - ID produktu, ktorý vrátime
     * @return - vrátime produkt
     */

    public Equipment get(int ID){
        for(Equipment eqp: ballList){
            if(eqp.getID() == ID){
                return eqp;
            }
        }
        for(Equipment eqp: stickList){
            if(eqp.getID() == ID){
                return eqp;
            }
        }
        for(Equipment eqp: goalList){
            if(eqp.getID() == ID){
                return eqp;
            }
        }
        return null;
    }

    /**
     * Pridanie pomôcky do skladu
     * @param eqp - pomôcka, ktorú pridávame
     */

    public void addEquipment(Equipment eqp){
        if(eqp instanceof Ball){
            ballList.add((Ball) eqp);
        }
        else if(eqp instanceof Stick){
            stickList.add((Stick) eqp);
        }
        else if(eqp instanceof Goal){
            goalList.add((Goal) eqp);
        }
        else{
            System.out.println("WAREHOUSE FAIL - addEquipment");
        }
    }

    /**
     * Zmení počet produktov na sklade
     * @param ID - ID produktu, ktorého kvantitu zmení
     * @param count - nový počet produktov
     */

    public void setCount(int ID, int count){
        for(Equipment eqp: ballList){
            if(eqp.getID() == ID){
                eqp.setCount(count);
            }
        }
        for(Equipment eqp: stickList){
            if(eqp.getID() == ID){
                eqp.setCount(count);
            }
        }
        for(Equipment eqp: goalList){
            if(eqp.getID() == ID){
                eqp.setCount(count);
            }
        }
    }

    /**
     * Vypíše všetky hokejky na sklade a informácie o nich
     */

    public void printSticks(){
        stickList.forEach(stick->{
            System.out.println("ID: " + stick.getID());
            System.out.println("Blade Side: " + stick.getBladeSide());
            System.out.println("Length: " + stick.getLength());
            System.out.println("Material: " + stick.getMaterial());
            System.out.println("Grip: " + stick.getGrip());
            System.out.println("Flex: " + stick.getFlex());
            System.out.println("Weight: " + stick.getWeight());
            System.out.println("Count: " + stick.getCount());
            System.out.println("Price: " + stick.getPrice());
            System.out.println("----------------------------------------------------------");
        });
    }

    /**
     * Vypíše všetky loptičky na sklade a informácie o nich
     */

    public void printBalls(){
        ballList.forEach(ball->{
            System.out.println("ID: " + ball.getID());
            System.out.println("Color: " + ball.getColor());
            System.out.println("Weight: " + ball.getWeight());
            System.out.println("Count: " + ball.getCount());
            System.out.println("Price: " + ball.getPrice());
            System.out.println("----------------------------------------------------------");
        });
    }

    /**
     * Vypíše všetky bránky na sklade a informácie o nich
     */

    public void printGoals(){
        goalList.forEach(goal->{
            System.out.println("ID: " + goal.getID());
            System.out.println("Height: " + goal.getHeight());
            System.out.println("Width: " + goal.getWidth());
            System.out.println("Material: " + goal.getMaterial());
            System.out.println("Weight: " + goal.getWeight());
            System.out.println("Count: " + goal.getCount());
            System.out.println("Price: " + goal.getPrice());
            System.out.println("----------------------------------------------------------");
        });
    }
}
