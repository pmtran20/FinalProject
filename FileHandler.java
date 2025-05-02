import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void saveData(ArrayList<String> data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : data)
                writer.write(item + "\n");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void saveArray(String[] data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : data)
                writer.write(item + "\n");
        } catch (IOException e) {
            System.out.println("Error saving array: " + e.getMessage());
        }
    }

    public static ArrayList<String> loadData(String filename) {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null)
                data.add(line);
        } catch (IOException e) {
            System.out.println("No existing " + filename + " found.");
        }
        return data;
    }

    public static String[] loadArray(String filename) {
        ArrayList<String> tempList = loadData(filename);
        return tempList.toArray(new String[0]);
    }
}
