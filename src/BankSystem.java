import java.io.IOException;
import java.util.ArrayList;

import Base.*;
import Frames.LoginFrame;


public class BankSystem {
    public static ArrayList<UserAccount> Users = new ArrayList<UserAccount>();
    public static UserAccount User;
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Bank System opening");
        
        new LoginFrame();
        

        /* 
         Proposed order of panels:
         - LoginPanel 
         - If logged in:
         - - MenuPanel
         - - - BalancePanel (Button -> BalancePanel)
         - - - WithdrawPanel (Button -> WithdrawPanel)
         - - - DepositPanel (Button -> DepositPanel)
         - - - LoginPanel (Button -> LoginPanel)
         - If not:
         - - LoginPanel
        */

        /*
         final JPanel panel = new JPanel(new GridLayout(0, 1));
        JTextField field1 = new JTextField();
        field1.setSize(150, 20);
        field1.setLocation(200, 150);

        JLabel label1 = new JLabel("What is your name?");
        label1.setSize(100, 20);
        label1.setLocation(100, 100);
        panel.add(label1);
        panel.add(field1);

        int result = JOptionPane.showConfirmDialog(null, panel, "Bank System",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String name = field1.getText();
            System.out.println("Locating your UserFile...");
            FileManagement FileManager = new FileManagement();
            File UserFile = FileManager.LocateFile(name);
            List<String> UserDataString = FileManager.GetFileData(UserFile);
            String[] UserSplit = UserDataString.get(0).split(",");
            Float balance = Float.parseFloat(UserSplit[1]);
            User = new UserAccount().main(name, balance);
            Users.add(User);

            final JPanel ChoicePanel = new JPanel(new GridLayout(0,1));
            JButton button1 = new JButton("View balance");
            button1.addActionListener(new ActionListener(){ 
                public void actionPerformed(ActionEvent e){  
                      User.GetBalance();
                      //ChoicePanel.add(new JLabel());
                      JOptionPane.showMessageDialog(null, 
                      new JPanel(new GridLayout(0,1)).add(new JLabel("Your current balance is "+User.GetBalance())),
                      "Bank System", 0);
                }  
            });
            JButton button2 = new JButton("Withdraw from your balance");
            JTextField field2 = new JTextField();
            JLabel label2 = new JLabel("Provide an amount to withdraw");
            
            button2.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                    JPanel wPanel = new JPanel(new GridLayout(1,1));
                    wPanel.setName("Bank System");
                    wPanel.add(label2);
                    wPanel.add(field2);
                    int result = JOptionPane.showConfirmDialog(null, 
                        wPanel,"Bank System - Withdraw",JOptionPane.OK_OPTION,JOptionPane.PLAIN_MESSAGE                   
                    );
                    if (result == JOptionPane.OK_OPTION) {
                        if (field2.getText() != null) {
                            Float amount = Float.parseFloat(field2.getText());
                            User.Withdraw(amount);
                            //JOptionPane.showMessageDialog(null, new JPanel(new GridBagLayout()).add(),"Bank System", (Integer) null);
                            wPanel.add(new JLabel("Your new balance is "+User.GetBalance()));
                            wPanel.updateUI();
                            wPanel.revalidate();
                        }
                    } else {
                        System.out.println("Cancelled");
                    }
                    //JButton buttonToWithdraw = new JButton("Withdraw");
                    //buttonToWithdraw.addActionListener(new ActionListener() {
                    //    public void actionPerformed(ActionEvent e) {
                    //        
                    //    }
                    //});
                    //wPanel.add(buttonToWithdraw);
                }  
            });
            ChoicePanel.add(button1);
            ChoicePanel.add(button2);
            JOptionPane.showMessageDialog(null,ChoicePanel);
        } else {
            System.out.println("Cancelled");
        }
         */
        
        //} else {
        //    
        //}

        /*
         * Scanner consoleScanner = new Scanner(System.in);
         * System.out.println("Enter your name: ");
         * String Name = consoleScanner.nextLine();
         * 
         * System.out.println(User.GetBalance());
         * System.out.println(User.Deposit((float) 50000));
         * System.out.println(User.Withdraw((float) 200));
         * 
         * 
         * 
         * String Answer = "";
         * while (Answer != "1" || Answer != "2" || Answer != "3" || Answer != "4") {
         * System.out.
         * println("Please enter the number of the action you would like to do: ");
         * p("1. View your balance");
         * p("2. Deposit money into your account");
         * p("3. Withdraw money from your account");
         * p("4. Log out");
         * Answer = consoleScanner.nextLine();
         * try {
         * switch (Answer) {
         * case "1":
         * User.GetBalance();
         * Answer = "";
         * continue;
         * case "2":
         * p("Enter the amount that you wish to deposit into your account: ");
         * Float depositAmount = (float) consoleScanner.nextFloat();
         * User.Deposit(depositAmount);
         * depositAmount = null;
         * Answer = "";
         * continue;
         * case "3":
         * p("Enter the amount that you wish to withdraw from your account: ");
         * Float withdrawalAmount = (float) consoleScanner.nextFloat();
         * User.Deposit(withdrawalAmount);
         * withdrawalAmount = null;
         * Answer = "";
         * continue;
         * case "4":
         * Answer = "";
         * continue;
         * default:
         * if (Answer == "1" || Answer == "2" || Answer == "3" || Answer == "4") {
         * continue;
         * } else {
         * p("Incorrect number entered, please try again");
         * continue;
         * }
         * }
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         * 
         * }
         * 
         * 
         * consoleScanner.close();
         */

    }
}