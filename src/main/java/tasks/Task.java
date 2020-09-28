package tasks;

//initialise all new task
public class Task {
    protected String description;
    protected boolean isDone;

    //chnage task from not done to done
    public void markTaskAsDone() {
        this.isDone = true;
    }

    //first method is a new Task and second method is for an existing Task in duke.txt
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    //combines all required resulting info into a single string for easy access
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getTypeIcon() {
        return null;
    }

    @Override
    public String toString(){
        return  getTypeIcon() + getStatusIcon() + description;
    }
}
