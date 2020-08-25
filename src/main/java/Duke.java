
import java.util.Scanner;
import java.util.ArrayList;

//level 3
public class Duke {
    static String[] descriptions = new String[100];
    static boolean[] isDone = new boolean[100];
    static int listCount = 0;

    public static void main(String[] args) {
        String greetings = "\nHello! I'm Duke\n"
                + "What can I do for you?\n";
        System.out.println(greetings);


        ArrayList<String> list = new ArrayList<String>();
        Scanner readLine = new Scanner(System.in); //creates new read user input
        for (int i=0;;i++){
            String userInput = readLine.nextLine();

            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n");
                break;
            }

            else if (userInput.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                listLoan();
                System.out.println("");
            }

            else if (userInput.startsWith("done")) {
                int numDone = Integer.parseInt(userInput.substring(5,userInput.length())) - 1;
//                               System.out.println(numDone);
                markAsDone(numDone);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + getStatusIcon(numDone) + "] " + descriptions[numDone]);
                System.out.println("");
            }

            else {
                System.out.println("added: " + userInput + "\n");
                addTask(userInput);
            }
        }
    }
    public static void addTask (String description) {
        descriptions[listCount]=description;
        isDone[listCount]=false;
        listCount++;
    }

    public static String getStatusIcon (int num1) {
        return (isDone[num1] ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public static void markAsDone (int num) {
        isDone[num]=true;
    }

    public static void listLoan () {
        for (int i=0;i<listCount;i++) {
            System.out.println(i+1 + ". [" + getStatusIcon(i) +"] " + descriptions[i]);
        }
    }
}





















































































//public class Duke {
//    public static void main(String[] args) {
//        String greetings = "\nHello! I'm Duke\n"
//                + "What can I do for you?\n";
//        System.out.println(greetings);
//
////        //level 2
//        ArrayList<String> list = new ArrayList<String>();
//        Scanner add = new Scanner(System.in); //creates new read user input
//        for (int i=0;;i++){
//            String addString = add.nextLine();
//
//            if (addString.equals("bye")) {
//                System.out.println("Bye. Hope to see you again soon!\n");
//                break;
//            }
//
//            else if (addString.equals("list")) {
//                for (int j=0;j<list.size();j++) {
//                    System.out.println(j+1+". "+ list.get(j));
//                }
//                System.out.println("");
//            }
//
//            else {
//                System.out.println("added: " + addString + "\n");
//                list.add(addString);
//            }
//        }
//    }
//}


//level 1
//        Scanner echo = new Scanner(System.in); //creates new read user input
//        for (int i = 0; ; i++) {
//            String echoString = echo.nextLine();
//            if (!echoString.equals("bye")) {
//                System.out.println(echoString + "\n");
//            } else {
//                break;
//            }
//        }
//        System.out.println("Bye. Hope to see you again soon!");
//    }
//}



//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);