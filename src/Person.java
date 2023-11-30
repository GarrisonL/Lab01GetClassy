import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    public String toCSVDataRecord() {
        return String.join(",", firstName, lastName, ID, title, String.valueOf(YOB));
    }
}
