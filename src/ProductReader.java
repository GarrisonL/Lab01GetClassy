import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductReader {

    public static List<Product> readProductsFromFile(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();

        List<String> lines = Files.readAllLines(Path.of(filePath));

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String name = parts[0];
                String description = parts[1];
                String ID = parts[2];
                double cost = Double.parseDouble(parts[3]);

                Product product = new Product(name, description, ID, cost);
                products.add(product);
            }
        }

        return products;
    }
}
