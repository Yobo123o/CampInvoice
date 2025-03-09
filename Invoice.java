import java.util.ArrayList;

/**
 * Represents an invoice containing multiple line items.
 */
public class Invoice {
    private String storeName;
    private String address;
    private ArrayList<LineItem> items;

    /**
     * Constructs an Invoice for "Brendan's School of IT" with a default address.
     */
    public Invoice() {
        this("Brendan's School of IT", "100 Main Street\nAnytown, CA 98765");
    }

    /**
     * Constructs an Invoice with a specified store name and address.
     *
     * @param storeName The name of the store.
     * @param address   The store address.
     */
    public Invoice(String storeName, String address) {
        this.storeName = storeName;
        this.address = address;
        this.items = new ArrayList<>();
    }

    /**
     * Adds a line item to the invoice.
     *
     * @param item The line item to add.
     */
    public void addItem(LineItem item) {
        items.add(item);
    }

    /**
     * Calculates the total amount due for the invoice.
     *
     * @return The total invoice amount.
     */
    public double calculateTotal() {
        double total = 0;
        for (LineItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    /**
     * Generates a formatted text representation of the invoice.
     *
     * @return A string representing the invoice details.
     */
    public String generateInvoiceText() {
        StringBuilder sb = new StringBuilder();

        int maxItemLength = "Item".length();
        int maxQtyLength = "Qty".length();
        int maxPriceLength = "Price".length();
        int maxTotalLength = "Total".length();

        for (LineItem item : items) {
            maxItemLength = Math.max(maxItemLength, item.getProduct().getName().length());
            maxQtyLength = Math.max(maxQtyLength, String.valueOf(item.getQuantity()).length());
            maxPriceLength = Math.max(maxPriceLength, String.format("$%.2f", item.getProduct().getUnitPrice()).length());
            maxTotalLength = Math.max(maxTotalLength, String.format("$%.2f", item.getTotal()).length());
        }

        int padding = 2;
        maxItemLength += padding;
        maxQtyLength += padding;
        maxPriceLength += padding;
        maxTotalLength += padding + 3;
        int tableWidth = maxItemLength + maxQtyLength + maxPriceLength + maxTotalLength + 5;

        sb.append("\n").append("=".repeat(tableWidth)).append("\n");
        sb.append("          INVOICE\n");
        sb.append("=".repeat(tableWidth)).append("\n");
        sb.append(storeName).append("\n").append(address).append("\n");
        sb.append("=".repeat(tableWidth)).append("\n");
        sb.append(String.format("%-" + maxItemLength + "s %" + maxQtyLength + "s %" + maxPriceLength + "s %" + maxTotalLength + "s\n", "Item", "Qty", "Price", "Total"));
        sb.append("-".repeat(tableWidth)).append("\n");

        for (LineItem item : items) {
            sb.append(String.format("%-" + maxItemLength + "s %" + maxQtyLength + "d %" + maxPriceLength + "s %" + maxTotalLength + "s\n",
                    item.getProduct().getName(), item.getQuantity(),
                    String.format("$%.2f", item.getProduct().getUnitPrice()),
                    String.format("$%.2f", item.getTotal())));
        }

        sb.append("-".repeat(tableWidth)).append("\n");
        sb.append(String.format("AMOUNT DUE: $%.2f\n", calculateTotal()));
        sb.append("=".repeat(tableWidth)).append("\n");

        return sb.toString();
    }

    /**
     * Returns a formatted invoice text representation.
     *
     * @return The formatted invoice.
     */
    @Override
    public String toString() {
        return generateInvoiceText();
    }
}
