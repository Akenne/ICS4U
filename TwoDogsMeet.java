package dogtester2;

import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * April 3, 2014
 * Purpose: create a program where two dogs meet
 */
public class TwoDogsMeet {
    public static void main(String[] args) {
        String name, breed;
        int anger1 = 0, anger2 = 0;
        JOptionPane.showMessageDialog(null, "Lets make two dogs!");
        
        //make dog 1
        name = JOptionPane.showInputDialog
                ("What is the name of the first dog?");
        breed = JOptionPane.showInputDialog
                ("What is the breed of the first dog?");
        Dog dog1 = new Dog(name, breed);
        
        //make dog 2
        name = JOptionPane.showInputDialog
                ("What is the name of the second dog?");
        breed = JOptionPane.showInputDialog
                ("What is the breed of the second dog?");
        Dog dog2 = new Dog(name, breed);
        System.out.println(dog1);
        System.out.println("--------------------------");
        System.out.println(dog2);

        /**
         * Check if user wants to change values
         * the if statements asks if they want to, and returns true if they do
         * and then the value is changed
         */
        if (dog1.change(dog1.dogName, dog1.aggression, "aggression")){
            dog1.aggression = Integer.parseInt(JOptionPane.showInputDialog
                    ("What number is the new aggression?"));
        }
        if (dog2.change(dog2.dogName, dog2.aggression, "aggression")){
            dog2.aggression = Integer.parseInt(JOptionPane.showInputDialog
                    ("What number is the new aggression?"));
        }
        if (dog1.change(dog1.dogName, dog1.hunger, "hunger")){
            dog1.hunger = Integer.parseInt(JOptionPane.showInputDialog
                    ("What number is the new hunger?"));
        }
        if (dog2.change(dog2.dogName, dog2.hunger, "hunger")){
            dog2.hunger = Integer.parseInt(JOptionPane.showInputDialog
                    ("What number is the new hunger?"));
        }

        /**
         * if any of the attributes of the dog are cause for anger, anger goes up
         * if they are lower values, the anger goes down
         * if neither, anger stays the same.
         */
        JOptionPane.showMessageDialog(null, "The two dogs see eachother!");
        // we run the method to see if the attribute causes anger
        // if it does it returns 1, if not 0, if it reduces anger than -1
        anger1 += dog1.anger(dog1.aggression) + dog1.anger(dog1.hunger);
        anger2 += dog2.anger(dog2.aggression) + dog2.anger(dog2.hunger);

        System.out.println("--------------------------");
        
        //what dog1 does
        dog1.meeting(anger1, dog1.dogName, dog2.dogName);
        
        //what dog2 does
        dog2.meeting(anger2, dog2.dogName, dog1.dogName);
    }
}