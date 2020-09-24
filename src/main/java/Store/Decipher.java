package Store;

import tasks.*;
import java.util.ArrayList;

public class Decipher {
    public static ArrayList<String> eTaskList(ArrayList<Task> taskList) {
        final ArrayList<String> encodedTasks = new ArrayList<>();

        for(Task task : taskList) {
            encodedTasks.add(eTaskToString(task));
        }

        return encodedTasks;
    }

    private static String eTaskToString(Task task) {
        if (task instanceof Todo) {
            Todo todo = (Todo) task;
            return todo.toString();
        } else if (task instanceof Deadline) {
            Deadline deadline = (Deadline) task;
            return deadline.toString();
        } else if (task instanceof Event) {
            Event event = (Event) task;
            return event.toString();
        }
        return null;
    }
}