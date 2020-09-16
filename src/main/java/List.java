import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class List {
    ArrayList<Task> tasks =new ArrayList<>();
    private static int size;

    public List() {                             //initial constructor
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


    public void addEvent(String description, String at) {
        tasks.add(new Event(description, at));
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(this.size).toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }

    public void addTodo (String description) {
        tasks.add(new Todo(description));
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(this.size).toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
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

//    public void createTextFile () {
//        String filename = "/users/jenny/Desktop/Duke.txt";
//        FileWriter fstream;
//        try {
//            fstream = new FileWriter(filename);
//            BufferedWriter out = new BufferedWriter(fstream);
//            out.write("");
//            out.newLine();
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private static String PATH = new File("").getAbsolutePath();
    static File filePath = new File(PATH + "/duke.txt");

    public void UpdateTextFile () {
        FileWriter fstream;
        try {
//            BufferedWriter out = new BufferedWriter(fstream);
            String content="";
            for (int i=0;i<tasks.size();i++) {
                content=content.concat(tasks.get(i)+"\n");
            }
            fstream = new FileWriter(filePath);
            fstream.write(content);
            fstream.close();

//            out.write(content);
//            out.newLine();
//            out.flush();
//            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}




