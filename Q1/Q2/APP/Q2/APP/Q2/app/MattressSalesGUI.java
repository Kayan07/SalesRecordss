package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;

public class MattressSalesGUI extends JFrame {
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JLabel lblVat;
    private JLabel lblCommission;
    private JLabel lblTotal;

    public MattressSalesGUI() {
        setTitle("Mattress Sales");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem mnuProcess = new JMenuItem("Process");
        JMenuItem mnuClear = new JMenuItem("Clear");
        JMenuItem mnuExit = new JMenuItem("Exit");
        fileMenu.add(mnuProcess);
        fileMenu.add(mnuClear);
        fileMenu.add(mnuExit);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField("Joe Bloggs");
        add(txtCustomerName);

        add(new JLabel("Product:"));
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        add(cmbProduct);

        add(new JLabel("Price:"));
        txtPrice = new JTextField("3500");
        add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        add(btnProcess);
        add(new JLabel(""));

        add(new JLabel("VAT Amount:"));
        lblVat = new JLabel("R 0.0");
        add(lblVat);

        add(new JLabel("Commission Amount:"));
        lblCommission = new JLabel("R 0.0");
        add(lblCommission);

        add(new JLabel("Total Sale Amount:"));
        lblTotal = new JLabel("R 0.0");
        add(lblTotal);

        btnProcess.addActionListener(e -> processSale());
        mnuProcess.addActionListener(e -> processSale());
        mnuClear.addActionListener(e -> clearForm());
        mnuExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void processSale() {
        try {
            String customer = txtCustomerName.getText();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            lblVat.setText("R " + vat);
            lblCommission.setText("R " + commission);
            lblTotal.setText("R " + total);

            FileWriter writer = new FileWriter("data.txt");
            writer.write("DATA LOG\n");
            writer.write("Customer: " + customer + "\n");
            writer.write("Product: " + product + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.close();

            JOptionPane.showMessageDialog(null, "Sale processed and saved to data.txt");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid price!");
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
        lblVat.setText("R 0.0");
        lblCommission.setText("R 0.0");
        lblTotal.setText("R 0.0");
    }

    public static void main(String[] args) {
        new MattressSalesGUI();
    }
}
