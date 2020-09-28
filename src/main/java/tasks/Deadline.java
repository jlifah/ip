package tasks;

import tasks.Task;

//Todo inherits attributes of Task
public class Deadline extends Task {
    protected String by;

    //first method is adding new Todo to ArrayList and second method is to add existing Todo from duke.txt to ArrayList
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, String by, Boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    //combines all required resulting info into a single string for easy access
    @Override
    public String getTypeIcon(){
        return "[D]";
    }

    @Override
    public String toString() {
        return "[D][" + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }
}