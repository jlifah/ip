
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        List list = new List();
        list.readOldTextFile();


        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");


        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {

            if (userInput.equals("list")) {
                list.printList();
            } else if(userInput.startsWith("done")){
                list.isComplete(userInput);
            } else if (userInput.startsWith("deadline")) {
                list.addDeadline(getDeadlineDescription(userInput),getStringAfterByAt(userInput));
            } else if (userInput.startsWith("event")) {
                list.addEvent(getEventDescription(userInput),getStringAfterByAt(userInput));
            } else if (userInput.startsWith("todo")) {
                try {
                    if (userInput.length()==4) {
                        throw new Exception();
                    }
                    list.addTodo(userInput.substring(5));
                } catch (Exception e) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.\n");
                }
            } else if (userInput.startsWith("delete")) {
                list.toRemove(userInput.substring(7));
            } else {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
            }

            userInput = in.nextLine(); //read next user input
        }
        list.UpdateTextFile();
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static String getDeadlineDescription (String input) {
        String description = input.substring(9);
        int index = description.indexOf('/');
        description=description.substring(0, index-1);
        return description;
    }

    public static String getStringAfterByAt (String input) {
        String by = input.substring(input.indexOf('/')+4); //keep those after '/'
        return by;
    }

    public static String getEventDescription (String input) {
        String description = input.substring(6);
        int index = description.indexOf('/');
        description=description.substring(0, index-1);
        return description;
    }
}

