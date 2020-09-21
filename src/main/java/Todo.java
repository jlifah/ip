public class Todo extends Task{

    public Todo (String description) {
        super(description);
    }

    public Todo (String description, boolean isDone) {
        super (description, isDone);
    }

    @Override
    public String toString() {
        return "[T][" + getStatusIcon() + "] " + description;
    }

    @Override
    public String getTypeIcon(){
        return "[T]";
    }
}
