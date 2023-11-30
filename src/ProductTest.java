import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testToCSVDataRecord() {
        Product product = new Product("Laptop", "High-performance laptop", "12345", 1200.0);
        assertEquals("Laptop,High-performance laptop,12345,1200.0", product.toCSVDataRecord());
    }
}
