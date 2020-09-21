import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class List {
    ArrayList<Task> tasks =new ArrayList<>();
    private static int size;

    public List() {
        this.size = 0;
    }

    public void printList() {
        for (int i=0;i<tasks.size();i++) {
            System.out.println(i+1+". " +tasks.get(i).toString());
        }
        System.out.println("");
    }

    public void addDeadline (String description, String by) {
        tasks.add(new Deadline(description,by));
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(this.size).toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }

    public void addOldDeadline (String description, String by, Boolean isDone) {
        tasks.add(new Deadline(description,by,isDone));
        this.size++;
    }

    public void addEvent(String description, String at) {
        tasks.add(new Event(description, at));
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(this.size).toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }

    public void addOldEvent (String description, String at, Boolean isDone) {
        tasks.add(new Event(description,at, isDone));
        this.size++;
    }

    public void addTodo (String description) {

            tasks.add(new Todo(description));
            System.out.println("Got it. I've added this task:");
            System.out.println(tasks.get(this.size).toString());
            this.size++;
            System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }

    public void addOldTodo (String description, boolean isDone) {
        tasks.add(new Todo(description,isDone));
        this.size++;
    }


    public void isComplete(String command) {
        command = command.replace("done", " ");
        command = command.strip(); //removes white space
        int index;
        index = Integer.parseInt(command);
        index--;
        tasks.get(index).markTaskAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks.get(index).toString() + "\n");
    }

    public void toRemove (String taskRemove) {
        int index;
        index= Integer.parseInt(taskRemove)-1;
        System.out.println("Noted. I've removed this task:");
        System.out.println(tasks.get(index).toString());
        tasks.remove(index);
        this.size--;
        System.out.println("Now you have "+ this.size+ " tasks in the list.\n");
    }

    private static String PATH = new File("").getAbsolutePath();
    static File filePath = new File(PATH + "/duke.txt");

    //1. read old task list
    //2. split into T/E/D, done and description and at/by
    //3. add as new task into tasks arraylist
    public void readOldTextFile () {
        try {
            filePath.createNewFile();
            Scanner s = new Scanner(filePath);
            while (s.hasNext()) {
                String line = s.nextLine();

                if (line.startsWith("[T]")) {
                    String description = line.substring(7);
                    String outcome = line.substring(4,5);
                    Boolean isDone;

                    if (outcome.equals("\u2713")) {
                        isDone=true;
                    } else {
                        isDone=false;
                    }

                    addOldTodo(description,isDone);
                }

                else if (line.startsWith("[D]")) {
                    String description = line.substring(7,line.indexOf("by")-2);
                    String by = line.substring(line.indexOf("by")+4,line.length()-1);
                    String status = line.substring(4,5);
                    Boolean isDone;

                    if (status.equals("\u2718")) {
                        isDone=false;
                    } else {
                        isDone=true;
                    }

                    addOldDeadline(description,by,isDone);
                }

                else if (line.startsWith("[E]")) {
                    String description = line.substring(7,line.indexOf("at")-2);
                    String at = line.substring(line.indexOf("at")+4, line.length()-1);
                    String status = line.substring(4,5);

                    Boolean isDone;
                    if (status.equals("\u2718")) {
                        isDone=false;
                    }
                    else {
                        isDone=true;
                    }
                    addOldEvent(description,at, isDone);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UpdateTextFile () {
        FileWriter fstream;
        try {
            fstream = new FileWriter(filePath);
            String content="";
            for (int i=0;i<tasks.size();i++) {
                content+=tasks.get(i)+"\n";
            }
            fstream.write(content);
            fstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}