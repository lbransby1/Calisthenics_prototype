import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;

public class FileHandler {
    public static LinkedHashMap csvToLHM(String file) throws FileNotFoundException {
        // TODO: have a selection process for all progressions
        // do this with a tree
        BufferedReader reader = null;
        String line = "";
        LinkedHashMap Progression = new LinkedHashMap<String, Integer>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                int reps = Integer.valueOf((row[1]));
                Progression.put(row[0], reps);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(Collections.singletonList(Progression));
        }
        return Progression;
    }

    public void LHMtoCsv(LinkedHashMap LHM){

    }
}
