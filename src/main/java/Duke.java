import Store.Storage;
import tasks.TaskList;
import java.util.Scanner;

public class Duke {
    private TaskList tasks;
    private Ui ui;
    private Parser parser;
    private Storage storage;


    //creates new set up UI,Parser, Storage and TaskList when duke first runs
    public Duke () {
        ui = new Ui();
        parser= new Parser();
        tasks = new TaskList();
        storage = new Storage();
    }

    //reads the different user input and identifies them accordingly
    public void run() {
        ui.printHelp();
        ui.printGreetings();
        storage.update();
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();

        while (!parser.userInputBye(userInput)) {

            if (parser.userInputTodo(userInput)) {
                try {
                    if (userInput.length()==4) {
                        throw new Exception();
                    }
                    tasks.addTodo(userInput);
                } catch (Exception e) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.\n");
                }
            } else if (parser.userInputDeadline(userInput)) {
                tasks.addDeadline(userInput);
            } else if (parser.userInputEvent(userInput)) {
                tasks.addEvent(userInput);
            } else if (parser.userInputDone(userInput)) {
                tasks.isComplete(parser.taskDone(userInput));
            } else if (parser.userInputDelete(userInput)) {
                tasks.toDelete(parser.taskDelete(userInput));
            } else if (parser.userInputList(userInput)) {
                tasks.printList();
            } else if (parser.userInputFind(userInput)) {
                tasks.findCommon(userInput.substring(5));
            } else if (parser.userInputHelp(userInput)) {
                ui.printHelp();
            } else {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means (/ﾟДﾟ)/\n");
            }

            userInput = in.nextLine();
        }

        ui.printBye();
    }

    //first method Duke goes to when it runs
    public static void main(String[] args) {
        new Duke().run();
    }
}