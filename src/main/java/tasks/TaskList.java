package tasks;
import Store.Storage;
import java.io.IOException;
import java.util.ArrayList;


//TaskList will inherit attributes from Storage
public class TaskList extends Storage {
    private static int size;
    private static ArrayList<Task> taskList;

    public TaskList () {
        taskList = new ArrayList<>();
    }

    //adds a new todo to ArrayList
    public void addTodo (String userInput) {
        taskList.add (new Todo(userInput.substring(5)));
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(size).toString());
        size++;
        System.out.println("Now you have " + size + " tasks in the list.\n");
        TaskList.save();
    }

    //adds a todo that was saved in the duke.txt file into the ArrayList
    public static void addPreviousTodo (String description, boolean isDone) {
        taskList.add(new Todo(description,isDone));
        size++;
        TaskList.save();
    }

    //adds a new deadline to ArrayList
    public void addDeadline (String userInput) {
        taskList.add(new Deadline(getDeadlineDescription(userInput),getStringAfterByAt(userInput)));
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(size).toString());
        size++;
        System.out.println("Now you have " + size + " tasks in the list.\n");
        TaskList.save();
    }

    //adds a deaadline that was saved in the duke.txt file into the ArrayList
    public static void addPreviousDeadline (String description, String by, boolean isDone) {
        taskList.add(new Deadline(description, by, isDone));
        size++;
        TaskList.save();
    }

    //adds a new event to ArrayList
    public void addEvent (String userInput) {
        taskList.add(new Event(getEventDescription(userInput),getStringAfterByAt(userInput)));
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(size).toString());
        size++;
        System.out.println("Now you have " + size + " tasks in the list.\n");
        TaskList.save();
    }

    //adds an event that was saved in the duke.txt file into the ArrayList
    public static void addPreviousEvent (String description, String by, boolean isDone) {
        taskList.add(new Event(description, by, isDone));
        size++;
        TaskList.save();
    }

    //mark task (either todo/deadline/event) as done
    public void isComplete (int taskNum) {
        taskList.get(taskNum-1).markTaskAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskList.get(taskNum-1).toString() + "\n");
        TaskList.save();
    }

    //deletes a task from ArrayList
    public void toDelete (int taskNum) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskList.get(taskNum-1).toString());
        taskList.remove(taskNum-1);
        size--;
        System.out.println("Now you have "+ size+ " tasks in the list.\n");
        TaskList.save();
    }

    //looks through all the task description inb teh ArrayList and prints out any that includes the keyword stated
    public void findCommon (String keyword) {
        int index=1;
        for (Task task : taskList) {
            if (task.toString().contains(keyword)) {
                System.out.println(index + ". " + task.toString());
                index++;
            }
        }
        System.out.println();
    }

    //prints all tasks in the ArrayList
    public void printList() {
        for (int i=0;i<taskList.size();i++) {
            System.out.println(i+1+". " +taskList.get(i).toString());
        }
        System.out.println();
    }

    //saves tasks into duke.txt file
    public static void save() {
        Storage storage = new Storage();
        try {
            storage.save(taskList);
        } catch (IOException e) {
            System.out.println("error saving");
        }
    }

    //gets deadline description from the whole user input string
    public static String getDeadlineDescription (String input) {
        String description = input.substring(9);
        int index = description.indexOf('/');
        description=description.substring(0, index-1);
        return description;
    }

    //gets event description from the whole user input string
    public static String getEventDescription (String input) {
        String description = input.substring(6);
        int index = description.indexOf('/');
        description=description.substring(0, index-1);
        return description;
    }

    //gets deadline/event day from user input
    public static String getStringAfterByAt (String input) {
        return input.substring(input.indexOf('/')+4);
    }
}
