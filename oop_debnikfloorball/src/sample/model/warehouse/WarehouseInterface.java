package sample.model.warehouse;

import sample.model.equipment.Equipment;

public interface WarehouseInterface {
    Equipment get(int ID);
    void addEquipment(Equipment eqp);
    void setCount(int ID, int count);
    void printSticks();
    void printBalls();
    void printGoals();
}

