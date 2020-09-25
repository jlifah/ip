public class Parser extends Ui {

    public boolean userInputBye (String input) {
        return input.startsWith("bye");
    }

    public boolean userInputTodo (String input) {
        return input.startsWith("todo");
    }

    public boolean userInputDone (String input) { return  input.startsWith("done"); }

    public boolean userInputDelete (String input) {return input.startsWith("delete"); }

    public boolean userInputList (String input) {return input.startsWith("list"); }

    public boolean userInputDeadline (String input) { return input.startsWith("deadline");}

    public boolean userInputEvent (String input) { return input.startsWith("event");}

//    public boolean userInputFind (String input) {return input.startsWith("find");}

    public int taskDone (String input) {
        return Integer.parseInt(input.substring(5));
    }

    public int taskDelete (String input) {
        return Integer.parseInt(input.substring(7));
    }

}
