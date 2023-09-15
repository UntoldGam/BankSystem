// This works, do not edit
public class UserAccount {
    private Float balance = (float) 0;
    private String name = "";
    
    public UserAccount main(String Name,Float balanceNumber) {
        this.name = Name;
        this.balance = balanceNumber;
        return this;
    }


    public String GetName() {
        System.out.println("Your name is "+this.name);
        return this.name;
    }

    public Float GetBalance() {
        System.out.println("Your current balance is "+this.balance);
        return this.balance;
    }
    public Float Deposit(Float amount) {
        System.out.println("Your current balance is "+this.balance);
        this.balance += amount;
        System.out.println("Your new balance is "+this.balance);
        return this.balance;
    }
    public Float Withdraw(Float amount) {
        System.out.println("Your current balance is "+this.balance);
        this.balance -= amount;
        System.out.println("Your new balance is "+this.balance);
        return this.balance;
    }

    public String ChangeName(String newName) {
        System.out.println("Your current name is "+this.name);
        this.name = newName;
        System.out.println("Your new name is "+this.name);
        return this.name;
    }
}