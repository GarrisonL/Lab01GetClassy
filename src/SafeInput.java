import java.util.Scanner;

public class SafeInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getPositiveInt(String prompt) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next(); // consume the invalid input
            }
            input = scanner.nextInt();
            if (input <= 0) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        } while (input <= 0);
        scanner.nextLine(); // consume the newline
        return input;
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
