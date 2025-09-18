import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Customer {
    private String name;
    private String address;
    private long phoneNumber;
    private int balance;

    public Customer(String name, String address, long phoneNumber, int initialDeposit) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = initialDeposit;
    }

    public String getName() { return name; }
    public long getPhoneNumber() { return phoneNumber; }
    public int getBalance() { return balance; }

    public void deposit(int amount) { balance += amount; }
    public void withdraw(int amount) {
        if (balance >= amount) balance -= amount;
        else JOptionPane.showMessageDialog(null, "⚠ Insufficient Balance!");
    }

    public String getDetails() {
        return "Name: " + name + "\nPhone: " + phoneNumber + "\nBalance: " + balance;
    }
}

public class Bank {
    private static java.util.List<Customer> customers = new java.util.ArrayList<>();


    // Bank Dashboard
    public static void openBankDashboard() {
        JFrame frame = new JFrame("ABC Bank");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton createBtn = new JButton("Create Account");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton balanceBtn = new JButton("Check Balance");
        JButton viewAllBtn = new JButton("View All Customers");

        JTextArea output = new JTextArea(12, 40);
        output.setEditable(false);
        JScrollPane scroll = new JScrollPane(output);

        createBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Name:");
            String address = JOptionPane.showInputDialog("Enter Address:");
            long phone = Long.parseLong(JOptionPane.showInputDialog("Enter Phone:"));
            int deposit = Integer.parseInt(JOptionPane.showInputDialog("Enter Initial Deposit:"));
            Customer c = new Customer(name, address, phone, deposit);
            customers.add(c);
            output.setText("✅ Account Created!\n\n" + c.getDetails());
        });

        depositBtn.addActionListener(e -> {
            long phone = Long.parseLong(JOptionPane.showInputDialog("Enter Phone:"));
            int amount = Integer.parseInt(JOptionPane.showInputDialog("Enter Deposit Amount:"));
            for (Customer c : customers) {
                if (c.getPhoneNumber() == phone) {
                    c.deposit(amount);
                    output.setText("💰 Deposit Successful!\n\n" + c.getDetails());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "❌ Customer Not Found!");
        });

        withdrawBtn.addActionListener(e -> {
            long phone = Long.parseLong(JOptionPane.showInputDialog("Enter Phone:"));
            int amount = Integer.parseInt(JOptionPane.showInputDialog("Enter Withdraw Amount:"));
            for (Customer c : customers) {
                if (c.getPhoneNumber() == phone) {
                    c.withdraw(amount);
                    output.setText("💸 Withdraw Successful!\n\n" + c.getDetails());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "❌ Customer Not Found!");
        });

        balanceBtn.addActionListener(e -> {
            long phone = Long.parseLong(JOptionPane.showInputDialog("Enter Phone:"));
            for (Customer c : customers) {
                if (c.getPhoneNumber() == phone) {
                    output.setText("💳 Balance Check\n\n" + c.getDetails());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "❌ Customer Not Found!");
        });

        viewAllBtn.addActionListener(e -> {
            if (customers.isEmpty()) {
                output.setText("⚠ No customers yet!");
            } else {
                StringBuilder sb = new StringBuilder("📋 All Customers:\n\n");
                for (Customer c : customers) {
                    sb.append(c.getDetails()).append("\n-------------------\n");
                }
                output.setText(sb.toString());
            }
        });

        frame.add(createBtn);
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(balanceBtn);
        frame.add(viewAllBtn);
        frame.add(scroll);

        frame.setVisible(true);
    }

    // Login Page
    public static void main(String[] args) {
        JFrame loginFrame = new JFrame("Bank Login");
        loginFrame.setSize(300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        loginFrame.add(userLabel);
        loginFrame.add(userField);
        loginFrame.add(passLabel);
        loginFrame.add(passField);
        loginFrame.add(new JLabel()); // empty space
        loginFrame.add(loginBtn);

        // Dummy username & password
        String validUser = "admin";
        String validPass = "1234";

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals(validUser) && password.equals(validPass)) {
                JOptionPane.showMessageDialog(null, "✅ Login Successful!");
                loginFrame.dispose(); // close login window
                openBankDashboard(); // open main bank system
            } else {
                JOptionPane.showMessageDialog(null, "❌ Invalid Username/Password!");
            }
        });

        loginFrame.setVisible(true);
    }
}
