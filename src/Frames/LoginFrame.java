package Frames;
import java.awt.event.*;

import javax.swing.*;

import Base.UserAccount;

public class LoginFrame extends JFrame implements ActionListener {
   public UserAccount user;
   public UserAccount main() {
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
                  user = new UserAccount().main(name,(float) 0);
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
      this.setSize(500, 600); // 400 width and 500 height
      this.setLayout(null); // using no layout managers
      this.setVisible(true); // making the frame visible
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    
      if (user != null) {
         return user;
      } else {
         return new UserAccount();
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
   }
}