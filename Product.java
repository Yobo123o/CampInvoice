/**
 * Represents a product with a name and unit price.
 */
public class Product {
    private String name;
    private double unitPrice;

    /**
     * Constructs a Product with a name and unit price.
     *
     * @param name      The name of the product.
     * @param unitPrice The price per unit of the product.
     */
    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    /**
     * Retrieves the product name.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the unit price of the product.
     *
     * @return The unit price of the product.
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return Formatted string with name and price.
     */
    @Override
    public String toString() {
        return name + " ($" + String.format("%.2f", unitPrice) + ")";
    }
}
