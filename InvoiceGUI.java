import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * InvoiceGUI provides a graphical user interface for creating and displaying invoices.
 */
public class InvoiceGUI extends JFrame {
    private JTextField productNameField, priceField, quantityField;
    private JTextArea invoiceTextArea;
    private JLabel totalLabel;
    private Invoice invoice;

    /**
     * Constructs the Invoice GUI and initializes components.
     */
    public InvoiceGUI() {
        invoice = new Invoice();

        setTitle("Invoice System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        inputPanel.add(productNameField);

        inputPanel.add(new JLabel("Unit Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Item");
        inputPanel.add(addButton);

        totalLabel = new JLabel("Total: $0.00");
        inputPanel.add(totalLabel);

        add(inputPanel, BorderLayout.NORTH);

        invoiceTextArea = new JTextArea();
        invoiceTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        invoiceTextArea.setEditable(false);
        add(new JScrollPane(invoiceTextArea), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        setVisible(true);
    }

    /**
     * Adds an item to the invoice based on user input and updates the display.
     */
    private void addItem() {
        String name = productNameField.getText();
        double price;
        int quantity;

        try {
            price = Double.parseDouble(priceField.getText());
            quantity = Integer.parseInt(quantityField.getText());

            if (name.isEmpty() || price <= 0 || quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter valid product details.");
                return;
            }

            Product product = new Product(name, price);
            LineItem lineItem = new LineItem(product, quantity);
            invoice.addItem(lineItem);

            invoiceTextArea.setText(invoice.generateInvoiceText());
            totalLabel.setText("Total: $" + String.format("%.2f", invoice.calculateTotal()));

            productNameField.setText("");
            priceField.setText("");
            quantityField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers for price and quantity.");
        }
    }

    /**
     * Main method to launch the Invoice GUI.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new InvoiceGUI();
    }
}
