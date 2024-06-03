import java.util.*;

// Define an interface for money transfer operations
interface moneyTransfer {
    abstract void sendmoney(); // Abstract method for sending money
}

// Implement the moneyTransfer interface with the UPI class
class upi implements moneyTransfer {
    public void sendmoney() {
        // This function actually connects with a payment gateway
        // and uses the swift code to transfer money between accounts
    }
}

// Abstract class representing a generic Bank Account
abstract class BankAccount {
    // Protected member variables, accessible to derived classes
    protected String name;
    protected String city;
    protected float accountBalance;

    // Default constructor
    BankAccount() {  
        name = "None";
        city = "not defined";
        accountBalance = 0;
    }

    // Parameterized constructor
    BankAccount(String name, String city, float accountBalance) {  
        this.name = name;
        this.city = city;
        this.accountBalance = accountBalance;
    }

    // Getter method for account balance
    public float getBalance() {
        return accountBalance;
    }

    // Abstract methods to be implemented by derived classes
    abstract void calculateInterest();
    abstract void FundTransfer();
    abstract void setBalance(float money);

    // Display method to show bank details
    void display() {
        System.out.println("The name of the Bank is " + name + " located at " + city);
    }
}

// Derived class representing a Savings Account
class Savings extends BankAccount {
    private String type;
    private float rateOfInterest;
    private final int maxWithdrals = 3; // Maximum withdrawals allowed per month
    private int withdrawals = 0; // Current number of withdrawals

    // Default constructor
    Savings() {
        super();
        rateOfInterest = (float) 6.5;
        type = "Savings";
    }

    // Constructor with interest rate parameter
    Savings(float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    // Parameterized constructor
    Savings(String name, String city, float accountbalance, float rateOfInterest) {
        super(name, city, accountbalance);
        this.rateOfInterest = rateOfInterest;
    }

    // Method to set the interest rate
    public void setRate(float rate) {
        if (rate < 0 || rate > 100)
            System.out.println("Enter a rate of interest between 1 to 100");
        else
            rateOfInterest = rate;
    }

    // Calculate and add interest to the account balance
    public void calculateInterest() {
        accountBalance += rateOfInterest * accountBalance / 100;
    }

    // Method to transfer funds using UPI
    public void FundTransfer() {
        upi phonepe = new upi();
        phonepe.sendmoney();
    }

    // Method to set or withdraw balance with rules specific to savings accounts
    public void setBalance(float money) {
        if (withdrawals > maxWithdrals && money < 0) // money < 0 indicates it is a withdrawal
            System.out.println("withdrawal limit exceeded for this month");
        else if (money < -1000 || money > 1000)
            System.out.println("This account can be set or withdrawn max of Rs. 1000 only");
        else if (money < 0 && accountBalance + money < 0)
            System.out.println("Insufficient account balance");
        else {
            this.accountBalance += money;
            withdrawals++;
        }
    }

    // Display method to show account details
    void display() {
        System.out.println("The name of the Bank is " + name + " located at " + city);
        System.out.println("Account Balance: " + accountBalance);
    }
}

// Derived class representing a Current Account
class Current extends BankAccount {
    private String type;
    private float rateOfInterest;
    private final int maxWithdrals = 10000; // Higher withdrawal limit for current accounts
    private int withdrawals = 0; // Current number of withdrawals

    // Default constructor
    Current() {
        super();
        rateOfInterest = 0; // No interest for current accounts
        type = "Current";
    }

    // Parameterized constructor
    Current(String name, String city, float accountbalance) {
        super(name, city, accountbalance);
        this.rateOfInterest = 0; // No interest for current accounts
    }

    // Method to transfer funds using UPI
    public void FundTransfer() {
        upi phonepe = new upi();
        phonepe.sendmoney();
    }

    // No interest calculation for current accounts
    public void calculateInterest() {
        accountBalance += 0;
    }

    // Method to set or withdraw balance with rules specific to current accounts
    public void setBalance(float money) {
        if (withdrawals > maxWithdrals && money < 0) // money < 0 indicates it is a withdrawal
            System.out.println("withdrawal limit exceeded for this month");
        else if (money < -100000 || money > 100000) // Higher transaction limit for current accounts
            System.out.println("This account can be set or withdrawn max of Rs. 100000 only");
        else if (money < 0 && accountBalance + money < 0)
            System.out.println("Insufficient account balance");
        else {
            this.accountBalance += money;
            withdrawals++;
        }
    }

    // Display method to show account details
    void display() {
        System.out.println("The name of the Bank is " + name + " located at " + city);
        System.out.println("Account Balance: " + accountBalance);
    }
}

// Main class to test the Bank Account functionality
public class Main {
    public static void main(String[] args) {
        int choice = 0;
        BankAccount sbi = null;
        Scanner sc = new Scanner(System.in);

        // Prompt user to choose between a current or savings account
        do {
            System.out.println("Do you want to open a check_in[1] or savings account[2]?");
            choice = sc.nextInt();
        } while (choice != 1 && choice != 2);

        // Create account based on user choice
        switch (choice) {
            case 1:
                sbi = new Current("SBI Current", "Coimbatore", (float) 3000);
                break;
            case 2:
                sbi = new Savings("SBI Savings", "Coimbatore", (float) 10000, (float) 7.5);
                break;
        }

        // Display account details
        sbi.display();
        // Set balance by adding Rs. 10000
        sbi.setBalance(10000);
        // Withdraw Rs. 1000
        sbi.setBalance(-1000);
        // Perform fund transfer
        sbi.FundTransfer();
        // Print account balance
        System.out.println("Printing account balance from Main: ");
        System.out.println(sbi.getBalance());
        sc.close();
    }
}


/*
--- OOP Concepts in the Code ---
Encapsulation: Data members like name, city, and accountBalance are encapsulated within the BankAccount class and its derived classes. They are accessed and modified through methods.

Inheritance: The Savings and Current classes inherit from the BankAccount class, reusing its properties and methods.

Abstraction: The BankAccount class is abstract, providing a template with abstract methods calculateInterest, FundTransfer, and setBalance that must be implemented by derived classes.

Polymorphism: The FundTransfer method is defined in the moneyTransfer interface and implemented differently in the upi class. The BankAccount class uses this polymorphic behavior to call the sendmoney() method.

Interfaces: The moneyTransfer interface is used to define a contract for money transfer operations. The upi class implements this interface, providing a specific implementation of the sendmoney() method.

*/