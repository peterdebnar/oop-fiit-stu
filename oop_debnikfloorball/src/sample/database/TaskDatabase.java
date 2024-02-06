package sample.database;

import sample.model.task.Task;

import java.util.ArrayList;

/**
 * Databáza úloh s použitím návrhového vzoru Singleton
 */

public class TaskDatabase{

    private final ArrayList<Task> tasks = new ArrayList<>();

    private TaskDatabase(){}

    private static TaskDatabase instance;

    /**
     * Princíp Singletonu - nevytvára sa nový objekt, používa sa stále len 1
     * @return - vráti inštanciu
     */

    public static TaskDatabase getInstance(){
        if(instance == null){
            instance = new TaskDatabase();
        }
        return instance;
    }

    /**
     * metóda na nastavenie úlohy
     * @param ID - ID tovaru, ktorý treba niekam doviesť
     * @param count - počet kusov tovaru, ktoré treba niekam doviesť
     * @param destination - miesto, kam treba tovar doviesť
     */

    public void set(int ID, int count, String destination){
        Task task = new Task(ID, count, destination);
        tasks.add(task);
    }

    /**
     * metóda na vypísanie všetkých úloh
     */

    public void printTasks(){
        tasks.forEach(task->{
            System.out.println("ID: " + task.getID());
            System.out.println("Count: " + task.getCount());
            System.out.println("Destination: " + task.getDestination());
            System.out.println("------------------------------------------------------");
        });
    }
}
