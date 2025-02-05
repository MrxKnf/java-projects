public class JsonConverter {
    public static String convertToJson(Task task){
        return "\"id\":" + task.id + "," +
                "\"status\"" + ":" + task.status +  "," +
                "\"description\":" + "\"" + task.description + "\"" +  "," +
                "\"createdAt\":" + "\"" + task.createdAt + "\"" + "," +
                "\"updatedAt\":" + "\"" + task.updatedAt + "\"";
    }

    public static Task convertFromJson(String json){
        Task task = new Task();

        String[] taskProperties = json.split(",");

        task.id = Integer.parseInt(taskProperties[0].replace("{","").split(":")[1]);
        task.status = Integer.parseInt(taskProperties[1].split(":")[1]);
        task.description = taskProperties[2].split(":")[1].replaceAll("\"","");
        task.createdAt = taskProperties[3].split(":")[1].replaceAll("\"","");
        task.updatedAt = taskProperties[4].split(":")[1].replaceAll("\"","");

        return task;
    }
}
