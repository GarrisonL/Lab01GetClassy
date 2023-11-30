import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Generate persons and write to file
        PersonGenerator.main(args);

        // Read persons from file and display information
        readPersonsFromFileAndDisplay();
    }

    private static void readPersonsFromFileAndDisplay() {
        try {
            List<Person> people = PersonReader.readPersonsFromFile(Paths.get("people.csv"));

            // Display information about each person
            for (Person person : people) {
                System.out.println("Full Name: " + person.fullName());
                System.out.println("Formal Name: " + person.formalName());
                System.out.println("Age: " + person.getAge());
                System.out.println("CSV Data Record: " + person.toCSVDataRecord());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
