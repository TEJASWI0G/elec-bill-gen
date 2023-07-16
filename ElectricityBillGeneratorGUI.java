import javax.swing.*;
import java.awt.event.*;

public class ElectricityBillGeneratorGUI {
    
    // Declare GUI components
    private JFrame frame;
    private JLabel nameLabel, idLabel, previousReadingLabel, currentReadingLabel;
    private JTextField nameField, idField, previousReadingField, currentReadingField;
    private JButton generateButton;
    
    public ElectricityBillGeneratorGUI() {
        // Initialize GUI components
        frame = new JFrame("Electricity Bill Generator");
        frame.setLayout(null);
        
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        frame.add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(100, 10, 160, 25);
        frame.add(nameField);
        
        idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 40, 80, 25);
        frame.add(idLabel);
        
        idField = new JTextField();
        idField.setBounds(100, 40, 160, 25);
        frame.add(idField);
        
        previousReadingLabel = new JLabel("Previous Reading:");
        previousReadingLabel.setBounds(10, 70, 120, 25);
        frame.add(previousReadingLabel);
        
        previousReadingField = new JTextField();
        previousReadingField.setBounds(130, 70, 130, 25);
        frame.add(previousReadingField);
        
        currentReadingLabel = new JLabel("Current Reading:");
        currentReadingLabel.setBounds(10, 100, 120, 25);
        frame.add(currentReadingLabel);
        
        currentReadingField = new JTextField();
        currentReadingField.setBounds(130, 100, 130, 25);
        frame.add(currentReadingField);

        generateButton = new JButton("Generate Bill");
        generateButton.setBounds(60, 170, 140, 25);
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });
        frame.add(generateButton);
        
        // Set frame properties
        frame.setSize(300, 240);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    // Generate bill function
    private void generateBill() {
        String name = nameField.getText();
        String id = idField.getText();
        double previousReading = Double.parseDouble(previousReadingField.getText());
        double currentReading = Double.parseDouble(currentReadingField.getText());

        


        double unitsConsumed = currentReading - previousReading;
        double rate = 0;
        if (unitsConsumed <= 100) {
            rate = 1.20;
        } else if (unitsConsumed <= 300) {
            rate = 2.00;
        } else if (unitsConsumed <= 500) {
            rate = 3.00;
        } else {
            rate = 4.00;
        }
        double amount = unitsConsumed * rate;

       

        // Display bill information
        if (previousReading>currentReading)
        {
            System.out.println("The current reading value CANNOT lesser than previous reading value");
            System.exit(0);
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Customer Name: " + name + "\nCustomer ID: " + id + "\nUnits Consumed: " + unitsConsumed + "kWh\nRate: " + rate + "per kWh\nAmount Payable: $" + amount);
        }
        
    }
    
    public static void main(String[] args) {
        new ElectricityBillGeneratorGUI();
    }
}