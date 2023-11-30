import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
    public static List<Person> readPersonsFromFile(Path filePath) throws IOException {
        List<Person> people = new ArrayList<>();
        List<String> lines = Files.readAllLines(filePath);

        for (String line : lines) {
            String[] parts = line.split(",");
            String firstName = parts[0];
            String lastName = parts[1];
            String ID = parts[2];
            String title = parts[3];
            int YOB = Integer.parseInt(parts[4]);

            Person person = new Person(firstName, lastName, ID, title, YOB);
            people.add(person);
        }

        return people;
    }
}
