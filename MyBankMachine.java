package atmmachine;

import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * March 31, 2014
 * Purpose: create a menu which allows you to interact with the ATM object.
 */
public class MyBankMachine {

    public static void main(String[] args) {
        // Name our atm object atm
        ATM atm;
        // Ask for name of bank
        String choice = JOptionPane.showInputDialog(
                "Generating account information:\n"
                + "1 - Enter the name of the bank\n"
                + "2 - Generate a random bank name");
        if (choice.equals("2")) {
            // If they enter 2 give a random name
            atm = new ATM();
        } else if (choice.equals("1")) {
            // Ask user bank name if they enter 1
            String bank = JOptionPane.showInputDialog("");
            atm = new ATM(bank);
        } else { 
            // If they dont put the correct value give a random one
            System.out.println("Invalid selection! Generating random"
                    + " bank name.");
            atm = new ATM();
        }

        // Get the initial balance of the bank account
        while (true){
            String initial = JOptionPane.showInputDialog(
                    "What is the initial balance of the account?\n"
                    + "Enter your balance in dollars please!\n"
                    + "This bank machine has phased out change!");
            // Check if the number is valid
            if(ATM.check(initial)){
                int initial2 = Integer.parseInt(initial);
                if (initial2 < 0) {
                    JOptionPane.showMessageDialog(null,
                            "Enter a positive value!");
                    continue;
                }
                // If so, deposit the money and break the loop
                atm.deposit(initial2);
                break;
            }
        }

        // Menu to interact with account
        while(true){
            int choice2;
            // Use user input and cases to interact
            choice = JOptionPane.showInputDialog(
                    "Welcome user!\n"
                    + "What do you want to do?:\n"
                    + "1 - Deposit money\n"
                    + "2 - Withdraw money\n"
                    + "3 - Display balance\n"
                    + "4 - Add daily interest\n"
                    + "5 - Exit");
            // check if their choice is valid, if not restart the loop
            if (ATM.check(choice)){
                choice2 = Integer.parseInt(choice);
                if (choice2 < 1 && choice2 > 5){
                    JOptionPane.showMessageDialog(null,
                            "Enter a correct number!");
                    continue;
                }
            }else{
                continue;
            }

            // if it is valid it gets stored as choice 2
            switch (choice2) {
                case 1:// case 1 is depositing money
                    while (true){
                        // display balance for users sake
                        atm.balance();
                        // find how much they want to deposit
                        String amount = JOptionPane.showInputDialog
                            ("How much do you want to deposit?\n"
                            + "Enter your balance in dollars please!\n"
                            + "This bank machine has phased out change!\n"
                                + "Enter 0 to quit");
                        // check if the amount is valid, if not, restart loop
                        if (ATM.check(amount)){
                            int amount2 = Integer.parseInt(amount);
                            // if the amount is 0, go back a screen
                            if (amount2 == 0){break;}
                            if (amount2 < 0) {
                                JOptionPane.showMessageDialog
                                        (null, "Enter a positive value!");
                                continue;
                            }
                            // if the number is valid, deposit the money
                            atm.deposit(amount2);
                            // say how much user deposits
                            System.out.println
                               ("You deposit " + amount2 + "$ into " + ATM.bankName);
                        }else{
                            continue;
                        }
                        break;
                    }
                    break;

                case 2:// case 2 is withdrawing money
                    while (true) {
                        // display balance for users sake
                        atm.balance();
                        // find how much they want to withdraw
                        String amount = JOptionPane.showInputDialog
                                ("How much do you want to withdraw?\n"
                                + "Enter your balance in dollars please!\n"
                                + "This bank machine has phased out change!\n"
                                + "Enter 0 to quit");
                        // check if the amount is valid, if not, restart loop
                        if (ATM.check(amount)) {
                            int amount2 = Integer.parseInt(amount);
                            // if the amount is 0, go back a screen
                            if (amount2 == 0){break;}
                            if (amount2 > ATM.money) {
                                JOptionPane.showMessageDialog(null,
                                 "You are trying to withdraw more than you have!");
                                continue;
                            }
                            if (amount2 < 0) {
                                JOptionPane.showMessageDialog(null,
                                        "Enter a positive value!");
                                continue;
                            }
                            // if the number is valid, withdraw the money
                            atm.withdraw(amount2);
                        } else {
                            continue;
                        }
                        break;
                    }
                    break;

                case 3:// case 3 is checking balance
                    // display balance
                    atm.balance();
                    break;

                case 4:// case 3 is checking balance
                    while (true) {
                        double interest2;
                        int days2;
                        // show balance for users sake
                        atm.balance();
                        // find how much the interest is annually
                        String interest = JOptionPane.showInputDialog
                                ("What is the annual interest rate?\n"
                                + "Write as an integer please(17% would be 17)\n"
                                + "Enter 0 to quit");
                        // check if this number is valid, else restart loop
                        if (ATM.check(interest)) {
                            interest2 = Double.parseDouble(interest);
                            // if the amount is 0, go back a screen
                            if (interest2 == 0) { break; }
                            if (interest2 < 1) {
                                JOptionPane.showMessageDialog(null,
                                        "Enter a positive value!");
                                continue;
                            }
                        } else {
                            continue;
                        }

                        // find how many days to get interest for
                        String days = JOptionPane.showInputDialog
                                ("How many days to leave the balance invested?\n"
                                + "Enter your days in integer form please(17)\n"
                                + "Enter 0 to quit");
                        // check if this number is valid
                        if (ATM.check(days)) {
                            days2 = Integer.parseInt(days);
                            // if the amount is 0, go back a screen
                            if (days2 == 0) {
                                break;
                            }
                            if (days2 < 0) {
                                JOptionPane.showMessageDialog(null,
                                        "Enter a positive value!");
                                continue;
                            }
                            // if both numbers are valid, do the interest calcs
                            atm.interest(interest2, days2);
                        } else {
                            continue;
                        }
                        break;
                    }
                    break;
                    
                case 5:// case 5 is exit
                    System.exit(0);
            }
        }
    }
}
