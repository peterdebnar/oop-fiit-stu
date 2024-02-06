package sample.model.user;

import sample.model.equipment.Ball;
import sample.model.equipment.Goal;
import sample.model.equipment.Stick;
import sample.model.warehouse.Warehouse;

public class Designer extends User {
    Warehouse warehouse;

    /**
     * Dva konštruktory - použitý overloading
     * @param ID - ID dizajnera
     * @param username - uživateľské meno dizajnera
     * @param password - heslo dizajnera
     * @param name - meno dizajnera
     * @param surname - priezvisko dizajnera
     */

    public Designer(int ID, String username, String password, String name, String surname){
        warehouse = Warehouse.getInstance();
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Designer(String username, String password, String name, String surname){
        warehouse = Warehouse.getInstance();
        this.ID = nextID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    /**
     * metóda na vytvorenie hokejky
     * @param weight - váha hokejky
     * @param price - cena hokejky
     * @param count - počet hokejok
     * @param length - dĺžka hokejky
     * @param material - materiál, z ktorého je hokejka vyrobená
     * @param bladeSide - strana čepele
     * @param grip - úchyt hokejky
     * @param flex - ohybnosť hokejky
     */

    public void createStick(float weight, float price, int count, int length, String material, String bladeSide, String grip, int flex){
        Stick stick = new Stick(weight, price, count, length, material, bladeSide, grip, flex);
        warehouse.addEquipment(stick);
    }

    /**
     * metóda na vytvorenie bránky
     * @param weight - váha bránky
     * @param price - cena bránky
     * @param count - počet bránok
     * @param height - výška bránky
     * @param width - šírka bránky
     * @param material - materiál, z ktorého je bránka vyrobená
     */

    public void createGoal(float weight, float price, int count, float height, float width, String material){
        Goal goal = new Goal(weight, price, count, height, width, material);
        warehouse.addEquipment(goal);
    }

    /**
     * metóda na vytvorenie loptičky
     * @param weight - váha loptičky
     * @param price - cena loptičky
     * @param count - počet loptičiek
     * @param color - farba loptičky
     */

    public void createBall(float weight, float price, int count, String color){
        Ball ball = new Ball(weight, price, count, color);
        warehouse.addEquipment(ball);
    }
}
