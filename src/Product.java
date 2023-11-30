import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSVDataRecord() {
        return String.join(",", name, description, ID, String.valueOf(cost));
    }

    public static void generateProducts(List<Product> products) {
        // Implement product generation logic as needed
    }

    public static void writeProductsToFile(List<Product> products, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                writer.write(product.toCSVDataRecord());
                writer.newLine();
            }
        }
    }

    public static List<Product> readProductsFromFile(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines.map(Product::parseProduct).collect(Collectors.toList());
        }
    }

    private static Product parseProduct(String line) {
        String[] parts = line.split(",");
        String name = parts[0];
        String description = parts[1];
        String ID = parts[2];
        double cost = Double.parseDouble(parts[3]);
        return new Product(name, description, ID, cost);
    }
}
