package atmmachine;

import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * March 31, 2014
 * Purpose: create an ATM class which will mimic a bank machine in the real world
 */
public class ATM {
    public static int money; // total money is global
    public static String bankName;

    //default atm constructor if no name is sent
    public ATM() {
        money = 0;
        // No bank name was sent - pick random
        int randType = (int)(Math.random() * 3);
        if(randType == 0){
            bankName = "BMO";
        }else if(randType == 1) {
            bankName = "Royal Bank";
        }else {
            bankName = "Scotiabank";
        }
    }

    // constructor if name is sent
    public ATM(String bankN){
        money = 0;
        bankName = bankN;
    }

    // method to deposit
    public void deposit(int amount){
        // add the amount to deposit to total and 
        money += amount;
    }

    // method to withdraw
    public void withdraw(int amount){
        // subtract the amount to deposit from total and say how much user withdraws
        money -= amount;
        System.out.println("You withdraw " + amount + "$ from " + bankName);
    }

    // method to check balance
    public void balance(){
        System.out.println("Your account at " + bankName + " has " + money + "$");
    }

    // method to add interest
    public void interest(double interest, int days) {
        // save how much money you start with
        int moneyinit = money;
        /**
         * convert the interest to daily interest(divide by 365 for daily, divide
         * by 100 to get a decimal
         */
        interest = interest/36500;
        // do the formula to get the new amount of money
        money = (int) (money * (Math.pow(1 + interest, days)));
        // find how much the user earned from interest
        int earned = money-moneyinit;
        // tell the user how much they earned
        System.out.println("You earn " + earned + "$ over " + days + " days!");
    }

    // This method checks if an int was input
    public static boolean check(String test) {
        try {
            int test2 = Integer.parseInt(test);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You didn't enter a number!");
            return false;// if not return false
        }
        return true;// if so return true
    }
}