package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Base.UserAccount;

public class DepositFrame extends MainFrame {
    DepositFrame(UserAccount user) {
        JFrame f = this;
        /*
         * Create the field + submit etc
         */

        // Components

        JLabel TextLabel = new JLabel("How much do you wish to deposit? ");
        TextLabel.setBounds(150, 160, 220, 50);

        JTextField TextField = new JTextField(null, "", ABORT);
        TextField.setBounds(150, 200, 220, 25);

        JButton DepositButton = new JButton("Deposit");
        DepositButton.setBounds(150, 225, 220, 25);

        JTextArea OutputLabel = new JTextArea();
        OutputLabel.setEditable(false);
        OutputLabel.setLineWrap(true);
        OutputLabel.setWrapStyleWord(true);
        OutputLabel.setVisible(false);
        OutputLabel.setBounds(150, 350, 220, 50);

        DepositButton.addActionListener(
                (ActionListener) new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (TextField.getText() != null) {
                            Float amount = Float.parseFloat(TextField.getText());
                            if (amount instanceof Float) {
                                if (amount <= 3000 && amount > 0) {
                                    float balance = user.GetBalance();
                                    float oldBalance = balance;
                                    float newBalance = balance + amount;
                                    user.Deposit(amount);
                                    OutputLabel.setText(
                                            "Your old balance was £" + oldBalance + "\nYour new balance is £"
                                                    + newBalance);
                                    OutputLabel.setVisible(true);
                                } else {
                                    OutputLabel.setText("Amount must not be over 3000 or below 1");
                                    OutputLabel.setVisible(true);
                                }

                            }
                        }
                    }
                });

        JButton ReturnButton = new JButton("Return to menu");
        ReturnButton.setBounds(150, 415, 220, 25);

        ReturnButton.addActionListener(
                (ActionListener) new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                    }
                });
        this.add(TextLabel);
        this.add(TextField);
        this.add(DepositButton);
        this.add(OutputLabel);
        this.add(ReturnButton);
        // Do not touch
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(this.width, this.height);
        /*
         * Get balance
         * Take the amount the user wants to deposit
         * Use a variable to hold the old balance
         * Add the amount to the balance
         * Show new balance
         * Return button
         */
    }
}
