import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskHandler {
    private static final Path TASKS_FILE = Path.of("tasks.json");
    private static ArrayList<String> tasks;

    //Function to load tasks from JSON file
    public static void loadTasks(){
        if (!Files.exists(TASKS_FILE)){
            FileHandling.createFile(TASKS_FILE);
            tasks = new ArrayList<>();
        } else if(FileHandling.readString(TASKS_FILE).equals("")) {
            tasks = new ArrayList<String>();
        } else{
                tasks = new ArrayList<>(Arrays.asList(FileHandling.readString(TASKS_FILE).replaceAll("\\[|\\]","").split("},")));
                removeBrackets();
        }
    }

    //Function to storage tasks in the JSON file
    public static void storageTasks(){
        StringBuilder sb = new StringBuilder();

        if (tasks.isEmpty()){
            FileHandling.writeString(TASKS_FILE,"");
            return;
        }

        sb.append("[");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("{");
            sb.append(tasks.get(i));
            sb.append("}");
            if (i != tasks.size() - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        FileHandling.writeString(TASKS_FILE, sb.toString());
    }

    //Function to remove "{}" after loading the tasks
    private static void removeBrackets(){
        for (int i = 0; i < tasks.size(); i++){
            String cleanTask = tasks.get(i).replaceAll("\\{|\\}", "");
            tasks.remove(i);
            tasks.add(i, cleanTask);
        }
    }

    public static void addTask(int status, String description){
        loadTasks();
        Task task = new Task(status,description);

        if (!tasks.isEmpty()){
            task.id = JsonConverter.convertFromJson(tasks.getLast()).id + 1;
        }

        tasks.add(JsonConverter.convertToJson(task));
        storageTasks();
        System.out.println("Task added succesfully! (ID: " + task.id + ")");
    }

    public static void deleteTask(int id){
        loadTasks();
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = JsonConverter.convertFromJson(tasks.get(i));
            if (task.id == id){
                tasks.remove(i);
                break;
            }
            if (i == tasks.size() - 1){
                System.out.println("Task with ID: " + id + ", does not exist");
                return;
            }
        }
        storageTasks();
        System.out.println("Task deleted succesfully!");
    }

    public static void updateTask(int id, String newDescription){
        loadTasks();
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = JsonConverter.convertFromJson(tasks.get(i));
            if (task.id == id){
                task.description = newDescription;
                task.updatedAt = new Date().toString();
                tasks.remove(i);
                tasks.add(i,JsonConverter.convertToJson(task));
                break;
            }
            if (i == tasks.size() - 1){
                System.out.println("Task with ID: " + id + ", does not exist");
                return;
            }
        }
        storageTasks();
        System.out.println("Task description updated succesfully!");

    }

    public static void markInProgress(int id){
        loadTasks();
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = JsonConverter.convertFromJson(tasks.get(i));
            if (task.id == id){
                task.status = 1;
                task.updatedAt = new Date().toString();
                tasks.remove(i);
                tasks.add(i,JsonConverter.convertToJson(task));
                break;
            }
            if (i == tasks.size() - 1){
                System.out.println("Task with ID: " + id + ", does not exist");
                return;
            }
        }
        storageTasks();
        System.out.println("Task status updated succesfully!");

    }

    public static void markDone(int id){
        loadTasks();
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = JsonConverter.convertFromJson(tasks.get(i));
            if (task.id == id){
                task.status = 2;
                task.updatedAt = new Date().toString();
                tasks.remove(i);
                tasks.add(i,JsonConverter.convertToJson(task));
                break;
            }
            if (i == tasks.size() - 1){
                System.out.println("Task with ID: " + id + ", does not exist");
                return;
            }
        }
        storageTasks();
        System.out.println("Task status updated succesfully!");
    }

    public static void markPending(int id){
        loadTasks();
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = JsonConverter.convertFromJson(tasks.get(i));
            if (task.id == id){
                task.status = 0;
                task.updatedAt = new Date().toString();
                tasks.remove(i);
                tasks.add(i,JsonConverter.convertToJson(task));
                break;
            }
            if (i == tasks.size() - 1){
                System.out.println("Task with ID: " + id + ", does not exist");
                return;
            }
        }
        storageTasks();
        System.out.println("Task status updated succesfully!");
    }

    public static void listTasks(int status){
        loadTasks();
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
            return;
        }

        for (String t : tasks){
            Task task = JsonConverter.convertFromJson(t);
            if (task.status == status){
                System.out.println(task);
                System.out.println("----------------------------------------------");
            }
        }
    }

    public static void listAllTasks(){
        loadTasks();
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
            return;
        }

        for (String t : tasks){
            Task task = JsonConverter.convertFromJson(t);
            System.out.println(task);
            System.out.println("----------------------------------------------");
        }
    }
}
