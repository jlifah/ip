import java.io.File;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list = new List();


        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");




//        File f = new File("/users/jenny/Desktop/Duke.txt");
//        if(!f.exists() && !f.isDirectory()) {
//            list.createTextFile();
//        }

        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) {
                list.printList();
            }

            else if(userInput.startsWith("done")){   //cannot use command.equals since user is entering more than just "done"
                list.isComplete(userInput);
            }

            else if (userInput.startsWith("delete")) {
                list.toRemove(userInput.substring(7));
            }


            else if (userInput.startsWith("deadline")) {
                list.addDeadline(getDeadlineDescription(userInput),getStringAfterByAt(userInput));
            }


            else if (userInput.startsWith("event")) {
                list.addEvent(getEventDescription(userInput),getStringAfterByAt(userInput));
            }

            else if (userInput.startsWith("todo")) {
                try {
                    if (userInput.substring(5).equals("")) {
                        throw new Exception();
                    }
                    list.addTodo(userInput.substring(5));
                } catch (Exception e) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.\n");
                }
            }




            else {
              try {
                   throw new Exception();
                } catch (Exception e) {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                }
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
        String by = input.substring(input.indexOf('/') + 4);
        return by;
    }

    public static String getEventDescription (String input) {
        String description = input.substring(6);
        int index = description.indexOf('/');
        description=description.substring(0, index-1);
        return description;
    }


}

