
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list = new List();


        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");


        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) {
                list.printList();
            }

            else if(userInput.startsWith("done")){   //cannot use command.equals since user is entering more than just "done"
                list.isComplete(userInput);
            }



            else if (userInput.startsWith("deadline")) {

                String description = userInput.substring(9);
                int index = description.indexOf('/');
                description=description.substring(0, index-1);

                String by = userInput.substring(userInput.indexOf('/')+4); //keep those after '/'

                list.addDeadline(description,by);
            }


            else if (userInput.startsWith("event")) {
                String description = userInput.substring(6);
                int index = description.indexOf('/');
                description=description.substring(0, index-1);
                String at = userInput.substring(userInput.indexOf('/')+4); //keep those after '/'
                list.addEvent(description,at);
            }

            else if (userInput.startsWith("todo")) {

                list.addTodo(userInput.substring(5));
            }

            else {
                list.addTask(userInput);
                System.out.println("added: " + userInput + "\n");
            }

            userInput = in.nextLine(); //read next user input
        }

        System.out.println("Bye. Hope to see you again soon!");

    }
}

