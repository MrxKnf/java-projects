import java.util.Date;

public class Task {
    public static int lastId = 0;
    public int id;
    public int status;
    public String description;
    public String createdAt;
    public String updatedAt;

    public Task(){
        this.id = 0;
        this.status = 0;
        this.description = "";
        this.createdAt = new Date().toString();
        this.updatedAt = new Date().toString();
    }

    public Task(int status, String description){
        this.id = lastId + 1;
        this.status = status;
        this.description = description;
        this.createdAt = new Date().toString();
        this.updatedAt = new Date().toString();
        lastId++;
    }

    @Override
    public String toString(){
        String status = "";
        switch (this.status){
            case 0:
                status = "Pending";
                break;
            case 1:
                status = "In progress";
                break;
            case 2:
                status = "Done";
                break;
        }

        return "ID: " + this.id + "\n" +
                "DESCRIPTION: " + this.description + "\n" +
                "STATUS: " + status + "\n" +
                "CREATED AT: " + this.createdAt + "\n" +
                "UPDATED AT: " + this.updatedAt;
    }
}