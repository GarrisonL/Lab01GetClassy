import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter person data (press Enter for each person, type 'done' to finish):");

            while (true) {
                System.out.print("First Name: ");
                String firstName = scanner.nextLine();

                if (firstName.equalsIgnoreCase("done")) {
                    break;
                }

                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("ID: ");
                String ID = scanner.nextLine();

                System.out.print("Title: ");
                String title = scanner.nextLine();

                System.out.print("Year of Birth: ");
                int YOB = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                Person person = new Person(firstName, lastName, ID, title, YOB);
                people.add(person);
            }

            writePersonsToFile(people, "people.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writePersonsToFile(List<Person> people, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Person person : people) {
                writer.write(person.toCSVDataRecord());
                writer.newLine();
            }
        }
    }
}
