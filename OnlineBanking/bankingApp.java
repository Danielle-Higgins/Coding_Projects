package OnlineBanking;

import java.util.Scanner;

/**
 * Project: Simple online banking system that does basic operations such as deposit and withdraw
 * @author Danielle Higgins
 */
public class bankingApp {

    // instance fields
    private int balance;
    private String name;
    private String cardNum;
    private int prevTran;

    /**
     * Constructor
     * @param name The name of the user
     * @param cardNum The card number of the user
     */
    public bankingApp(String name, String cardNum) {
        this.name = name;
        this.cardNum = cardNum;
    }

    /**
     * Adds money to the users account
     * @param money The amount the user wants to add to their account
     */
    public void deposit(int money) {
        if (money < 0) {
            System.out.println("Invalid! Try again!");
        } else {
            this.balance += money;
            this.prevTran = money;
        }
    }

    /**
     * Substracts money from the users account
     * @param money The amount the user wants to withdraw
     */
    public void withdraw(int money) {
        if (money < 0) {
            System.out.println("Invalid! Try again!");
        } else {
            this.balance -= money;
            this.prevTran = -money; // Make the value of money negative to represent withdrawn
        }
    }

    /**
     * Shows the user previous transaction depending on if they deposited or withdrew
     */
    public void getPrevTran() {
        if (this.prevTran > 0) {
            System.out.println("Deposited: " + this.prevTran);
        } else if (this.prevTran < 0) {
            System.out.println("Withdrawn: " + Math.abs(this.prevTran)); // Make the withdrawn amount positive
        } else {
            System.out.println("No transaction occured!");
        }
    }

    /**
     * Where the user interaction takes place
     */
    public void menu() {
        Scanner key = new Scanner(System.in);

        System.out.println("Welcome to our online banking system!");
        System.out.println("Nice to see you " + this.name);
        System.out.println("Your card number is: " + this.cardNum);
        System.out.println("============================================================================================"
        + "================================================================");
        System.out.println("How much money do you have in your account?");
        int balance = key.nextInt();
        this.balance = balance;

        do {
            System.out.println("Would you like to: ");
            System.out.println("A: Deposit" + "\nB: Withdraw" + "\nC: View Balance" + "\nD: View Previous Transaction" + "\nE: Exit System");
            System.out.println("NOTE: NEEDS TO BE UPPERCASE");
            String response = key.next();

            switch (response) {
                case "A":
                    System.out.println("Before transaction: \nBalance = " + this.balance);
                    System.out.println("How much would you like to deposit?");
                    int add = key.nextInt();
                    deposit(add);
                    System.out.println("After transaction: \nBalance = " + this.balance);
                    System.out.println("Deposit complete!");
                    System.out.println("============================================================================================"
                    + "================================================================");
                    break;
                case "B":
                    System.out.println("Before transaction: \nBalance = " + this.balance);
                    System.out.println("How much would you like to withdraw?");
                    int remove = key.nextInt();
                    withdraw(remove);
                    System.out.println("After transaction: \nBalance = " + this.balance);
                    System.out.println("Withdraw complete!");
                    System.out.println("============================================================================================"
                    + "================================================================");
                    break;
                case "C":
                    System.out.println("Balance = " + this.balance);
                    System.out.println("============================================================================================"
                    + "================================================================");
                    break;
                case "D":
                    getPrevTran();
                    break;
                case "E":
                    System.out.println("Thank you for you service! Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid! Try again!");
                    System.out.println("============================================================================================"
                    + "================================================================");
                    break;
            }
        } while (true);
    }
}