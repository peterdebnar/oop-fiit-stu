package sample.controller;

import sample.model.warehouse.Warehouse;

/**
 * premostenie medzi view a model
 */

public class WarehouseController {
    Warehouse warehouse;

    /**
     * konštruktor pre  controller
     */

    public WarehouseController(){
        warehouse = Warehouse.getInstance();
    }

    public void print(String equipment){
        if(equipment.equals("sticks")){
            warehouse.printSticks();
        }
        else if(equipment.equals("balls")){
            warehouse.printBalls();
        }
        else if(equipment.equals("goals")){
            warehouse.printGoals();
        }
        else{
            System.out.println("WAREHOUSECONTROLLER print error!");
        }
    }
}
