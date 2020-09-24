package Store;

import tasks.Task;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Storage {
    private static final String PATH = new File("").getAbsolutePath();
    private static final String FILE_PATH = PATH + "/duke.txt";

    public static ArrayList<Task> update() {
        if(Files.exists(Path.of(PATH))){
            File file = new File(FILE_PATH);
            ArrayList<String> data = new ArrayList<>();
            try {
                file.createNewFile();
                Scanner s = new Scanner(file);
                while(s.hasNext()) {
                    String dataString = s.nextLine();
                    data.add(dataString);
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return converter.convert(data);

        } else {
            try {
                createDataFile();
            } catch (IOException e) {
                System.out.println("IO Exception found");
            }
            return new ArrayList<>();
        }
    }

    private static void createDataFile() throws IOException {
        File file = new File(Storage.PATH);
        boolean isDirCreated = file.mkdir();

        if(isDirCreated) {
            file = new File(Storage.PATH + "/duke.txt");
            file.createNewFile();
        }
    }

    public void save(ArrayList<Task> taskList) throws IOException {
        List<String> taskToString_TaskList = Decipher.eTaskList(taskList);
        Files.write(Path.of(FILE_PATH), taskToString_TaskList);
    }
}