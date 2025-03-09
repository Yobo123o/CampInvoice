import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Invoice class.
 */
public class InvoiceTest {

    /**
     * Tests adding an item to the invoice and verifying the total calculation.
     */
    @Test
    void testAddItemAndTotalCalculation() {
        Invoice invoice = new Invoice();
        Product product = new Product("Laptop", 1000);
        LineItem item = new LineItem(product, 2);

        invoice.addItem(item);

        assertEquals(2000, invoice.calculateTotal(), 0.001);
    }
}
