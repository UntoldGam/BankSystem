package Frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Base.UserAccount;

public class NewMenuFrame extends MainFrame {

    private UserAccount user;
    private JTextArea outputLabel;
    private JFrame depositFrame;

    public NewMenuFrame(UserAccount user) {
        this.user = user;

        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 0, 10)); // 4 rows, 1 column

        JButton balanceButton = new JButton("Click to view your balance");
        JButton depositButton = new JButton("Click to put money into your account");
        JButton withdrawButton = new JButton("Click to take money from your account");
        JButton logoutButton = new JButton("Click to log out of this account");

        buttonPanel.add(balanceButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(logoutButton);

        outputLabel = new JTextArea();
        outputLabel.setEditable(false);
        outputLabel.setLineWrap(true);
        outputLabel.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputLabel);

        // Add action listeners
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBalance();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDepositFrame();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        // Add components to the frame
        add(buttonPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        pack(); // Automatically size the frame based on components
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void showBalance() {
        outputLabel.setText("Your current balance is £" + user.GetBalance());
    }

    private void showDepositFrame() {
        if (depositFrame == null) {
            depositFrame = new DepositFrame(user);
        }
        depositFrame.setVisible(true);
    }

    private void logout() {
        dispose();
        new LoginFrame();
    }

    public void updateOutputLabel(String message) {
        outputLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserAccount user = new UserAccount();
            user.CreateAccount("TestUser", 1000.0f);
            new NewMenuFrame(user);
        });
    }
}
