import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class BankSystem {
    public static ArrayList<UserAccount> Users = new ArrayList<UserAccount>();
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Bank System opening");
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String Name = consoleScanner.nextLine();
        System.out.println("Locating your UserFile...");
        FileManagement FileManager = new FileManagement();
        File UserFile = FileManager.LocateFile(Name);
        List<String> UserDataString = FileManager.GetFileData(UserFile);
        System.out.println(UserDataString.size());
        String[] UserSplit = UserDataString.get(0).split(",");
        String name = UserSplit[0];
        Double balance = Double.parseDouble(UserSplit[1]);
        UserAccount User = new UserAccount();
        User = User.main(name, balance);
        /*
        System.out.println(User.GetBalance());
        System.out.println(User.Deposit((float) 50000));
        System.out.println(User.Withdraw((float) 200));
        */
        
        Users.add(User);
        String Answer = "";
        while (Answer != "1" || Answer != "2" || Answer != "3" || Answer != "4") {
            System.out.println("Please enter the number of the action you would like to do: ");
            p("1. View your balance");
            p("2. Deposit money into your account");
            p("3. Withdraw money from your account");
            p("4. Log out");
            Answer = consoleScanner.nextLine();
            try {
                switch (Answer) {
                    case "1":
                        User.GetBalance();
                        Answer = "";
                        continue;
                    case "2":
                        p("Enter the amount that you wish to deposit into your account: ");
                        Float depositAmount = (float) consoleScanner.nextFloat();
                        User.Deposit(depositAmount);
                        depositAmount = null;
                        Answer = "";
                        continue;
                    case "3":
                        p("Enter the amount that you wish to withdraw from your account: ");
                        Float withdrawalAmount = (float) consoleScanner.nextFloat();
                        User.Deposit(withdrawalAmount);
                        withdrawalAmount = null;
                        Answer = "";
                        continue;
                    case "4":
                        Answer = "";
                        continue;
                    default:
                        if (Answer == "1" || Answer == "2" || Answer == "3" || Answer == "4") {
                            continue;
                        } else {
                            p("Incorrect number entered, please try again");
                            continue;
                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        

        consoleScanner.close();
    }

    private static void p(String message) {
        System.out.println(message);
    }
}