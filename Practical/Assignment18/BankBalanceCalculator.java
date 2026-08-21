package Practical.Assignment18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceCalculator extends JFrame implements ActionListener {

    JTextField initialBalanceField;
    JTextField transactionField;
    JTextField updatedBalanceField;

    JButton depositButton;
    JButton withdrawButton;

    BankBalanceCalculator() {

        setTitle("Bank Balance Calculator");
        setSize(450, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Initial Balance:"));

        initialBalanceField = new JTextField();
        add(initialBalanceField);

        add(new JLabel("Transaction Amount:"));

        transactionField = new JTextField();
        add(transactionField);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        add(depositButton);
        add(withdrawButton);

        add(new JLabel("Updated Balance:"));

        updatedBalanceField = new JTextField();
        updatedBalanceField.setEditable(false);
        add(updatedBalanceField);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double balance =
                    Double.parseDouble(initialBalanceField.getText());

            double amount =
                    Double.parseDouble(transactionField.getText());

            if (e.getSource() == depositButton) {

                balance = balance + amount;

            } else if (e.getSource() == withdrawButton) {

                if (amount > balance) {

                    JOptionPane.showMessageDialog(this,
                            "Insufficient Balance!");

                    return;
                }

                balance = balance - amount;
            }

            updatedBalanceField.setText(String.valueOf(balance));

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new BankBalanceCalculator();
    }
}
