import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void addOldDeadline (String description, String by) {
        tasks.add(new Deadline(description,by));
        this.size++;
    }


    public void addEvent(String description, String at) {
        tasks.add(new Event(description, at));
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(this.size).toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }

    public void addOldEvent (String description, String at) {
        tasks.add(new Event(description,at));
        this.size++;
    }

    public void addTodo (String description) {
        tasks.add(new Todo(description));
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(this.size).toString());
        this.size++;
        System.out.println("Now you have " + this.size + " tasks in the list.\n");
    }

    public void addOldTodo (String description) {
        tasks.add(new Todo(description));
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

    public void readOldTextFile () {
        //1. read old task list
        //2. split into T/E/D, done and description and at/by
        //3. add as new task into tasks arraylist

       try {
           Scanner s = new Scanner(filePath);
           while (s.hasNext()) {
               String line = s.nextLine();

               if (line.startsWith("[T]")) {
                    String description = line.substring(7);
                   addOldTodo(description);
               } else if (line.startsWith("[D]")) {
                   String description = line.substring(7);
                   String by = line.substring(line.indexOf("by")+4,line.length()-1);
                   addOldDeadline(description,by);
               } else if (line.startsWith("[E]")) {
                   String description = line.substring(7);
                   String at = line.substring(line.indexOf("at")+4, line.length()-1);
                   addOldEvent(description,at);
               }

           }
       } catch (FileNotFoundException e) {
           System.out.println("File not found");
       }
    }

//
//    public void readOldTextFile () throws FileNotFoundException {
//        String dataPath = new File("data").getAbsolutePath();
//        File file = new File(dataPath + "/tasks.txt");
//        Scanner sc = new Scanner(file);
//        String dataString = sc.nextLine();
//
//        final String[] data = dataString.trim().split("\\|", 3);
//        String description;
//        int i=0;
//
//        switch(data[0]) {
//        case "[T]":
//            data[1]=tasks.get(i).getStatusIcon();
//            i++;
//            description = data[2];
//            tasks.add(new Todo(description));
//            break;
//        case "[D]":
//            data[1]=tasks.get(i).getStatusIcon();
//            i++;
//            String[] deadlineInfo = data[2].trim().split("\\|", 2);
//            description = deadlineInfo[0];
//            String by = deadlineInfo[1];
//            tasks.add(new Deadline(description, by));
//            break;
//        case "[E]":
//            data[1]=tasks.get(i).getStatusIcon();
//            i++;
//            String[] eventInfo = data[2].trim().split("\\|", 2);
//            description = eventInfo[0];
//            String at = eventInfo[1];
//            tasks.add(new Event(description, at));
//            break;
//        }
//    }

    public void UpdateTextFile () {
        FileWriter fstream;
        try {
            fstream = new FileWriter(filePath);
            String content="";
            for (int i=0;i<tasks.size();i++) {
                content=content.concat(tasks.get(i)+"\n");
            }
            fstream.write(content);
            fstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




