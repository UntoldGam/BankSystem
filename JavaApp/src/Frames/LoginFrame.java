package Frames;
import java.awt.event.*;

import javax.swing.*;

import Base.UserAccount;

public class LoginFrame extends MainFrame implements ActionListener {
   public UserAccount user;
   public LoginFrame() {
      JFrame f = this;
      /*
       * Create the field + submit etc
       */

      // Components

      JLabel TextLabel = new JLabel("What is your name?");
      TextLabel.setBounds(150,160,220,50);

      JTextField TextField = new JTextField(null, "", ABORT);
      TextField.setBounds(150, 200, 220,25);

      JButton TextButton = new JButton("Log-in");
      TextButton.setBounds(150, 225, 220,25);

      TextButton.addActionListener(
         new ActionListener(){ 
            public void actionPerformed(ActionEvent e){  
               String name = TextField.getText();
               if (name != null) {
                  user = new UserAccount().CreateAccount(name,(float) 0);
                  f.dispose();
                  new MenuFrame(user);
               }
               
            }  
        }
      );

      this.add(TextLabel);
      this.add(TextField);
      this.add(TextButton);
      // Do not touch
      this.setSize(500, 600);
      this.setLayout(null);  
      this.setVisible(true); 
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
   }
}