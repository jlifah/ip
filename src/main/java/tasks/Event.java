package tasks;

import tasks.Task;

//Todo inherits attributes of Task
public class Event extends Task {
    protected String at;

    //first method is adding new Todo to ArrayList and second method is to add existing Todo from duke.txt to ArrayList
    public Event (String description, String at) {
        super(description);
        this.at = at;
    }

    public Event(String description, String at, Boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    //combines all required resulting info into a single string for easy access
    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "] " + description + " (at: " + at + ")";
    }

    @Override
    public String getTypeIcon(){
        return "[E]";
    }

}
