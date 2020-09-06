
public class List {
    private Task[] list;
    private static int size;

    public List() {                             //constructor
        this.list = new Task[100];
        this.size = 0;
    }

    public void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < size; i++) {
//            System.out.println((i+1) + ". [" + this.list[i].getStatusIcon() + "]"  + this.list[i].description);
            System.out.println(i+1 + ". " + this.list[i].toString());
        }
        System.out.println("");
    }


//    public void addTask(String description) {
//        this.list[size] = new Task(description);
//        this.size++;
//    }


    public void addDeadline (String description, String by) {
        this.list[this.size] = new Deadline(description, by);
        System.out.println("Got it. I've added this task:");
//        System.out.println("[D][" + this.list[this.size].getStatusIcon() + "] " + description + " (by: " + by + ")");
        System.out.println(list[this.size].toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }


    public void addEvent(String description, String at) {
        this.list[size] = new Event(description, at);
        System.out.println("Got it. I've added this task:");
        System.out.println(list[this.size].toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }

    public void addTodo (String description) {
        this.list[size] = new Todo(description);
        System.out.println("Got it. I've added this task:");
        System.out.println(list[this.size].toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }


    public void isComplete(String command) {
        command = command.replace("done", " ");
        command = command.strip(); //removes white space
        int index;
        index = Integer.parseInt(command);
        index--;

        this.list[index].markTaskAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(this.list[index].toString() + "\n");
    }
}




