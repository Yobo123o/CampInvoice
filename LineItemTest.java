import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the LineItem class.
 */
public class LineItemTest {

    /**
     * Tests the total price calculation of a line item.
     */
    @Test
    void testTotalCalculation() {
        Product product = new Product("Mouse", 25.50);
        LineItem item = new LineItem(product, 4);

        assertEquals(102.00, item.getTotal(), 0.001);
    }
}
