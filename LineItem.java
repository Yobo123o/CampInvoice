/**
 * Represents a line item in the invoice, consisting of a product and its quantity.
 */
public class LineItem {
    private Product product;
    private int quantity;

    /**
     * Constructs a LineItem with a product and quantity.
     *
     * @param product  The product being purchased.
     * @param quantity The quantity of the product.
     */
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Retrieves the product associated with this line item.
     *
     * @return The product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Retrieves the quantity of the product.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates the total price for this line item.
     *
     * @return The total cost of the line item.
     */
    public double getTotal() {
        return product.getUnitPrice() * quantity;
    }

    /**
     * Returns a formatted string representation of the line item.
     *
     * @return A formatted string with product details, quantity, and total price.
     */
    @Override
    public String toString() {
        return quantity + " x " + product.getName() + " @ $" + String.format("%.2f", product.getUnitPrice()) +
                " each = $" + String.format("%.2f", getTotal());
    }
}
