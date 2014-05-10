package ComboLock;

import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * April 3, 2014
 * Purpose: create a program simulating a combo lock
 */
public class ComboLockDriver {
    public static void main(String[] args) {
        //make our numbers negative for the while loops
        String guess;
        int num1 = -1, num2 = -1, num3 = -1;
        JOptionPane.showMessageDialog(null, "Lets simulate a 3 digit combo lock!");

        //get user to input the 3 lock numbers, checking to make sure they
        //are 0-60, to simulate a real lock
        while (num1 <0 || num1>60){
            num1 = Integer.parseInt(JOptionPane.showInputDialog
                    ("What is the first number of the combo?"
                    + "\n Please use a number from 0 to 60"));
        }
        while (num2 <0 || num2>60){
            num2 = Integer.parseInt(JOptionPane.showInputDialog
                    ("What is the second number of the combo?"
                    + "\n Please use a number from 0 to 60"));
        }
        while (num3 <0 || num3>60){
            num3 = Integer.parseInt(JOptionPane.showInputDialog
                    ("What is the third number of the combo?"
                    + "\n Please use a number from 0 to 60"));
        }
        //create the first lock
        ComboLock lock1 = new ComboLock(num1, num2, num3);

        //try to get user to open it
        JOptionPane.showMessageDialog(null, "Now lets try to open it!");
        num1 = Integer.parseInt(JOptionPane.showInputDialog
                    ("What is the first number of the combo?"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog
                    ("What is the second number of the combo?"));
        num3 = Integer.parseInt(JOptionPane.showInputDialog
                    ("What is the third number of the combo?"));
        //put guess in same form combo is stored in
        guess = "" + num1 + "-" + num2 + "-" + num3;
        //compare strings
        if (guess.equals(lock1.code)){
            JOptionPane.showMessageDialog(null, "You open the lock!");
        }else{
            //if they get it wrong tell them what it is
            JOptionPane.showMessageDialog(null,
                    "You put the combo in wrong :("
                    + "\n you put " + guess + " and it's actually " + lock1.code);
        }

        //create a random lock with numbers from 1-3
        ComboLock lock2 = new ComboLock();
        JOptionPane.showMessageDialog(null, "I made a new lock for you!"
                    + "\nThe numbers are only from 1 to 3 to make it easier"
                    + "\nTry to guess it! You get 3 chances");
        //user gets 3 chances to guess, so for loop with 3 iterations
        for(int i = 0; i<3; i++){
            num1 = Integer.parseInt(JOptionPane.showInputDialog
                        ("What is the first number of the combo?"));
            num2 = Integer.parseInt(JOptionPane.showInputDialog
                        ("What is the second number of the combo?"));
            num3 = Integer.parseInt(JOptionPane.showInputDialog
                        ("What is the third number of the combo?"));
            guess = "" + num1 + "-" + num2 + "-" + num3;
            //user guesses, if wrong they can try again
            if (guess.equals(lock2.code)){
                //if right just end the program, nothing else to do
                JOptionPane.showMessageDialog(null, "You open the lock!");
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(null,
                        "You put the combo in wrong :(");
            }
        }
        //if they got it wrong all 3 times tell them what it is
        JOptionPane.showMessageDialog(null,
                "You put " + guess + " and it's actually " + lock2.code);
    }
}
