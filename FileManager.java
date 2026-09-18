import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "students.dat";

    public static void saveStudents(ArrayList<Student> students) {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            output.writeObject(students);

        } catch (IOException e) {

            System.out.println(
                    "Unable to save student data.");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            return (ArrayList<Student>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(
                    "Unable to load saved data.");

            return new ArrayList<>();
        }
    }
}