/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductApp extends JFrame implements ActionListener {

    // Components
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    // Menu
    private JMenuBar menuBar;
    private JMenu menuFile, menuTools;
    private JMenuItem miExit, miProcess, miClear;

    public ProductApp() {
        setTitle("Product App");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ===== Menu Bar ===== for showing the user options
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuTools = new JMenu("Tools");

        miExit = new JMenuItem("Exit");
        miProcess = new JMenuItem("Process");
        miClear = new JMenuItem("Clear");

        menuFile.add(miExit);
        menuTools.add(miProcess);
        menuTools.add(miClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // ===== Input Panel ===== where the user inputs the information
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        panel.add(new JLabel("Select Product:"));
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct);

        panel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        btnProcess = new JButton("PROCESS");
        panel.add(btnProcess);

        add(panel, BorderLayout.CENTER);

        // Event listeners
        btnProcess.addActionListener(this);
        miProcess.addActionListener(this);
        miClear.addActionListener(this);
        miExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnProcess || e.getSource() == miProcess) {
            processSale();
        } else if (e.getSource() == miClear) {
            clearForm();
        } else if (e.getSource() == miExit) {
            System.exit(0);
        }
    }

    private void processSale() {
        try {
            String customer = txtCustomerName.getText().trim();
            String product = (String) cmbProduct.getSelectedItem();
            String priceText = txtPrice.getText().trim();

            if (customer.isEmpty() || priceText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter customer name and price.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price = Double.parseDouble(priceText);

            if (price <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Price must be greater than zero.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calculations
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Works to show Message Box
            String message = String.format(
                    "Customer Name: %s%n" +
                    "Product: %s%n" +
                    "VAT: R %.1f%n" +
                    "COMMISSION: R %.1f%n" +
                    "TOTAL: R %.1f",
                    customer, product, vat, commission, total);

            JOptionPane.showMessageDialog(this, message, "Message",
                    JOptionPane.INFORMATION_MESSAGE);

            // Necessary for to save the file
            saveToFile(customer, product, vat, commission, total);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number for the price.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile(String customer, String product,
                            double vat, double commission, double total) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data.txt", true))) {
            pw.println("****************************************");
            pw.println("DATA LOG");
            pw.println("****************************************");
            pw.println("Customer Name: " + customer);
            pw.println("Product: " + product);
            pw.printf("VAT: R %.1f%n", vat);
            pw.printf("COMMISSION: R %.1f%n", commission);
            pw.printf("TOTAL: R %.1f%n", total);
            pw.println("****************************************");
            pw.println();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error writing to data.txt",
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        cmbProduct.setSelectedIndex(0);
        txtPrice.setText("");
        txtCustomerName.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}