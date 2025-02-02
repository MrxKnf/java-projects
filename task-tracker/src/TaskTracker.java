public class TaskTracker {
    public static void main(String[] args) {
        if (args.length > 0){
            switch (args[0]){
                case "add":
                    try{
                        TaskHandler.addTask(0,args[1]);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Usage: task-tracker add [\"description\"]");
                    }
                    break;

                case "update":
                    try{
                       TaskHandler.updateTask(Integer.parseInt(args[1]),args[2]);
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Usage: task-tracker update [id] [\"new_description\"]");
                    }
                    break;
                case "delete":
                    try{
                        TaskHandler.deleteTask(Integer.parseInt(args[1]));
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Usage: task-tracker delete [id]");
                    }
                    break;
                case "mark-in-progress":
                    try{
                        TaskHandler.markInProgress(Integer.parseInt(args[1]));
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Usage: task-tracker mark-in-progress [id]");
                    }
                    break;
                case "mark-done":
                    try{
                        TaskHandler.markDone(Integer.parseInt(args[1]));
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Usage: task-tracker mark-done [id]");
                    }
                    break;
                case "mark-todo":
                    try{
                        TaskHandler.markPending(Integer.parseInt(args[1]));
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Usage: task-tracker mark-todo [id]");
                    }
                    break;
                case "list":

                    if (args.length == 2){
                        if (args[1].equals("todo")){
                            TaskHandler.listTasks(0);
                        } else if (args[1].equals("in-progress")){
                            TaskHandler.listTasks(1);
                        } else if (args[1].equals("done")){
                            TaskHandler.listTasks(2);
                        } else{
                            System.out.println("Usage: task-tracker list [todo | in-progress | done]");
                        }
                    } else{
                        TaskHandler.listAllTasks();
                    }
                    break;
                default:
                    System.out.println("Unrecognized command.\n");
                    System.out.println("Usage:");
                    System.out.println("task-tracker add [\"description\"]");
                    System.out.println("task-tracker update [id] [\"new_description\"]");
                    System.out.println("task-tracker delete [id]");
                    System.out.println("task-tracker mark-in-progress [id]");
                    System.out.println("task-tracker mark-done [id]");
                    System.out.println("task-tracker mark-todo [id]");
                    System.out.println("task-tracker list [todo | in-progress | done]");
            }
        } else{
            System.out.println("Usage:");
            System.out.println("task-tracker add [\"description\"]");
            System.out.println("task-tracker update [id] [\"new_description\"]");
            System.out.println("task-tracker delete [id]");
            System.out.println("task-tracker mark-in-progress [id]");
            System.out.println("task-tracker mark-done [id]");
            System.out.println("task-tracker mark-todo [id]");
            System.out.println("task-tracker list [todo | in-progress | done]");
        }
    }
}
