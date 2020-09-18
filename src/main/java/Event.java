public class Event extends Task {
    protected String at;


    public Event (String description, String at) {
        super(description);
        this.at = at;
    }

    public Event(String description, String at, Boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "] " + description + " (at: " + at + ")";
    }

    @Override
    public String getTypeIcon(){
        return "[E]";
    }

}
