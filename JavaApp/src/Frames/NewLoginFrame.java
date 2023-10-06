package Frames;
import java.awt.event.*;

import javax.swing.*;

import Base.UserAccount;
public class NewLoginFrame extends MainFrame implements ActionListener {
    public UserAccount user;
    private JTextField textField;

    public NewLoginFrame() {
        // Components
        JLabel textLabel = new JLabel("What is your name?");
        textField = new JTextField();

        JButton textButton = new JButton("Log-in");
        textButton.addActionListener(this);

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout
        panel.add(textLabel);
        panel.add(textField);
        panel.add(textButton);

        // Set up the frame
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Add the panel to the frame
        getContentPane().add(panel);

        // Pack the frame to let components determine their preferred sizes
        pack();

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Log-in")) {
            String name = textField.getText();
            if (name != null) {
                user = new UserAccount().CreateAccount(name, (float) 0);
                dispose();
                new MenuFrame(user);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}