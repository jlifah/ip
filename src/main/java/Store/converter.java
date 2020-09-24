package Store;

import tasks.Task;
import parser.Parser2;
import java.util.ArrayList;

public class converter  {
    public static ArrayList<Task> convert (ArrayList<String> previousList) {
        final ArrayList<Task> updateWithPreviousList = new ArrayList<>();

        for (String s : previousList) {
            updateWithPreviousList.add(decodeTaskFromString(s));
        }

        return updateWithPreviousList;
    }

    private static Task decodeTaskFromString (String s) {
        return Parser2.stringToTask(s);
    }
}
