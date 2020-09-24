package parser;

import tasks.*;

public class Parser2{

    public static Task stringToTask (String input) {

        if (input.startsWith("[T]")) {
            return Parser2.addNewTodo2(input);
        } else if (input.startsWith("[D]")) {
            return Parser2.addNewDeadline2(input);
        } else if (input.startsWith("[E]")) {
            return Parser2.addNewEvent2(input);
        }

        return null;
    }

    private static Todo addNewTodo2 (String input) {
        boolean isDone;
        String description=input.substring(7);
        String symbol = input.substring(4,5);
        isDone= symbol.equals("\u2713");
        TaskList.addPreviousTodo(description,isDone);
        return new Todo(description, isDone);
    }

    private static Deadline addNewDeadline2 (String input) {
        String description = input.substring(7,input.indexOf("by")-2);
        String by = input.substring(input.indexOf("by")+4,input.length()-1);
        String status = input.substring(4,5);
        boolean isDone;
        isDone= !status.equals("\u2718");
        TaskList.addPreviousDeadline(description,by,isDone);
        return new Deadline(description, by, isDone);
    }

    private static Event addNewEvent2 (String input) {
        String description = input.substring(7,input.indexOf("at")-2);
        String by = input.substring(input.indexOf("at")+4,input.length()-1);
        String status = input.substring(4,5);
        boolean isDone;
        isDone= !status.equals("\u2718");
        TaskList.addPreviousEvent(description,by,isDone);
        return new Event(description, by, isDone);
    }
}