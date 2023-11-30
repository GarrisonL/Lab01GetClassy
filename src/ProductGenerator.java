import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter product data (press Enter for each product, type 'done' to finish):");

            while (true) {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("done")) {
                    break;
                }

                System.out.print("Description: ");
                String description = scanner.nextLine();

                System.out.print("ID: ");
                String ID = scanner.nextLine();

                System.out.print("Cost: ");
                double cost = scanner.nextDouble();
                scanner.nextLine(); // consume the newline

                Product product = new Product(name, description, ID, cost);
                products.add(product);
            }

            saveProductsToFile(products, "products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveProductsToFile(List<Product> products, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                writer.write(product.toCSVDataRecord());
                writer.newLine();
            }
        }
    }
}
