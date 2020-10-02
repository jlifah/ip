public class Ui {

    //prints this greeting message when duke first runs
    public void printGreetings () {
        System.out.println("\nHello! I'm Duke,\n" +
                " ____        _        \n" +
                "|  _ \\ _   _| | _____ \n" +
                "| | | | | | | |/ / _ \\\n" +
                "| |_| | |_| |   <  __/\n" +
                "|____/ \\__,_|_|\\_\\___|\n" );
        System.out.println("What can I do for you? :)\n");
    }

    //prints message after user inputs bye
    public void printBye () {
        System.out.println("Bye. Hope to see you again soon! (^-^)v");
    }

    public void printHelp () {
        System.out.println("Here are all the available commands and their respective formats:");
        System.out.println("Adding a deadline: deadline **DESCRIPTION** /by **TASK_DEADLINE**");
        System.out.println("Adding an event: event **DESCRIPTION** /at **TASK_START_DATE**");
        System.out.println("Adding an item in todo: todo **DESCRIPTION**");
        System.out.println("Listing all tasks: list");
        System.out.println("Marking task as done: done **INDEX_OF_TASK**");
        System.out.println("Deleting a task: delete **INDEX_OF_TASK**");
        System.out.println("Using keyword to find recorded tasks: find **KEYWORD**");
        System.out.println("Terminating Duke: bye\n");
    }
}
