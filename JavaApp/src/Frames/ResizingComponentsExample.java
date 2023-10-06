package Frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResizingComponentsExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Resizing Components Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel contentPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;

            // Create and add some components (e.g., buttons) to the panel
            for (int i = 1; i <= 9; i++) {
                JButton button = new JButton("Button " + i);
                contentPanel.add(button, gbc);
            }

            // Add a component listener to handle resizing events
            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    // Reposition and resize components based on the frame's size
                    Component[] components = contentPanel.getComponents();
                    int numRows = (int) Math.ceil(components.length / 3.0);

                    int newWidth = frame.getWidth() / 3; // Divide frame width into 3 columns
                    int newHeight = frame.getHeight() / numRows; // Adjust for number of rows

                    for (Component component : components) {
                        GridBagConstraints gbc = ((GridBagLayout) contentPanel.getLayout()).getConstraints(component);
                        gbc.gridwidth = 1; // Ensure each component spans only one column
                        gbc.ipadx = newWidth;
                        gbc.ipady = newHeight;
                    }

                    // Repaint the panel to update the components' sizes and positions
                    contentPanel.revalidate();
                    contentPanel.repaint();
                }
            });

            frame.add(contentPanel);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

