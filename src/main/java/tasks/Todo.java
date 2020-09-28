package tasks;

//Todo inherits attributes of Task
public class Todo extends Task {

    //first method is adding new Todo to ArrayList and second method is to add existing Todo from duke.txt to ArrayList
    public Todo (String description) {
        super(description);
    }
    public Todo (String description, boolean isDone) {
        super (description, isDone);
    }

    //combines all required resulting info into a single string for easy access
    @Override
    public String toString() {
        return "[T][" + getStatusIcon() + "] " + description;
    }

    @Override
    public String getTypeIcon(){
        return "[T]";
    }
}
