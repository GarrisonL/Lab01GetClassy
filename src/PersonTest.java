import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void testFullName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("Jane", "Smith", "67890", "Ms.", 1995);
        assertEquals("Ms. Jane Smith", person.formalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("Alice", "Johnson", "54321", "Dr.", 1975);
        // Assuming the current year is 2023
        assertEquals("48", person.getAge());
    }

    @Test
    public void testGetAgeWithYear() {
        Person person = new Person("Bob", "Williams", "98765", "Mr.", 1988);
        assertEquals("35", person.getAge(2023));
    }

    @Test
    public void testToCSVDataRecord() {
        Person person = new Person("Eve", "Taylor", "11111", "Mrs.", 2000);
        assertEquals("Eve,Taylor,11111,Mrs.,2000", person.toCSVDataRecord());
    }
}
