import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskHandler {
    private static final Path TASKS_FILE = Path.of("tasks.json");
    private static ArrayList<String> tasks;

    public static void loadTasks() throws IOException {
        if (!Files.exists(TASKS_FILE)){
            Files.createFile(TASKS_FILE);
            tasks = new ArrayList<>();
        } else{
            if(Files.readString(TASKS_FILE).equals("")){
                tasks = new ArrayList<String>();
            } else{
                tasks = new ArrayList<>(Arrays.asList(Files.readString(TASKS_FILE).replaceAll("\\[|\\]","").split("},")));
            }
        }

    }

    public static void storageTasks() throws IOException{
        StringBuilder sb = new StringBuilder();

        if (tasks.isEmpty()){
            Files.writeString(TASKS_FILE,"");
            return;
        }

        sb.append("[");
        for (int i = 0; i < tasks.size(); i++) {
            if (i == tasks.size() - 1){
                if (!tasks.get(i).endsWith("}")){
                    sb.append(tasks.get(i) + "}" + "]");
                } else{
                    sb.append(tasks.get(i) + "]");
                }
            } else{
                if (!tasks.get(i).endsWith("}")){
                    sb.append(tasks.get(i) + "}" + ",");
                } else{
                    sb.append(tasks.get(i) + ",");
                }
            }
        }
        Files.writeString(TASKS_FILE, sb.toString());
    }

    public static void addTask(int status, String description){
        try{
            loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Task task = new Task(status,description);

        if (!tasks.isEmpty()){
            task.id = JsonConverter.convertFromJson(tasks.getLast()).id + 1;
        }

        tasks.add(JsonConverter.convertToJson(task));

        try{
            storageTasks();
            System.out.println("Task added succesfully! (ID: " + task.id + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTask(int id){
        try{
            loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        try {
            storageTasks();
            System.out.println("Task deleted succesfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateTask(int id, String newDescription){
        try{
            loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        try{
            storageTasks();
            System.out.println("Task description updated succesfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void markInProgress(int id){
        try{
            loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        try{
            storageTasks();
            System.out.println("Task status updated succesfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void markDone(int id){
        try{
            loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        try{
            storageTasks();
            System.out.println("Task status updated succesfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void markPending(int id){
        try{
            loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        try{
            storageTasks();
            System.out.println("Task status updated succesfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listTasks(int status){
        try{
            loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        try{
            loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
