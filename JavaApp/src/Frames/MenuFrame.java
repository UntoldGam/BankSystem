package Frames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Base.UserAccount;
public class MenuFrame extends MainFrame {
    JFrame Deposit = null;
    MenuFrame(UserAccount user) {
        //MenuFrame mf = this;
        JButton BalanceButton = new JButton("Click to view your balance");
        BalanceButton.setBounds(150,150,220,50);
        JButton DepositButton = new JButton("Click to put money into your account");
        DepositButton.setBounds(150,200,220,50);
        JButton WithdrawButton = new JButton("Click to take money from your account");
        WithdrawButton.setBounds(150,250,220,50);
        JButton LogoutButton = new JButton("Click to log out of this account");
        LogoutButton.setBounds(150,300,220,50);
        // TODO: Remove and move to BalanceFrame
        
        JTextArea OutputLabel = new JTextArea();
        OutputLabel.setEditable(false);
        OutputLabel.setLineWrap(true);
        OutputLabel.setWrapStyleWord(true);
        OutputLabel.setVisible(false);
        OutputLabel.setBounds(150,350,220,50);
        BalanceButton.addActionListener(
            new ActionListener(){ 
                public void actionPerformed(ActionEvent e){  
                    OutputLabel.setText("Your current balance is £"+user.GetBalance());
                    OutputLabel.setVisible(true);
                }  
            }
        );
        
        DepositButton.addActionListener(
            new ActionListener(){ 
                public void actionPerformed(ActionEvent e){  
                    OutputLabel.setText("Deposit something into this balance: "+user.GetBalance());
                    //if (Deposit != null) {
                    //    mf.remove(Deposit);
                    //} else {
                    Deposit = new DepositFrame(user);
                    //}
                }  
            }
        );
        this.add(BalanceButton);
        this.add(DepositButton);
        this.add(WithdrawButton);
        this.add(LogoutButton);
        this.add(OutputLabel);
        // Do not touch
        this.setSize(500, 600); // 400 width and 500 height
        this.setLayout(null); // using no layout managers
        this.setVisible(true); // making the frame visible
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    
    }
}
