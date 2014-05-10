package dogtester2;

import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * April 3, 2014
 * Purpose: create a Dog class definition
 */
public class Dog {
    String dogName, dogBreed;
    int age, aggression, hunger, choice;

    //constructors
    public Dog(String dgName, String dgBreed) {
        dogName = dgName;
        dogBreed = dgBreed;
        // age aggression and hunger are randomized
        age = (int)(Math.random()*16);
        aggression = (int)(Math.random()*11);
        hunger = (int)(Math.random()*11);
    }

    //method to see if user wants to change a value
    public boolean change(String name, int value, String type) {
        choice = JOptionPane.showConfirmDialog(null,
                name + "'s " + type + ": " + value
                + "\nDo you want to change the " + type + "?", //message,
                "Change?", //title
                JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            return true;
        }
        return false;
    }

    //method to see how angry the dogs are
    public int anger(int value){
        if (value > 8) {
            //dog is very hungry/aggressive
            return 1;
        } else if (value < 2) {
            //dog is not hungry/aggressive at all
            return -1;
        }else{
            // dog is indifferent
            return 0;
        }
    }

    //method for the dogs to interact, so to speak
    public void meeting(int anger, String name1, String name2){
        if (anger == -2){
            System.out.println(name1 + " happily runs at " + name2);
        }else if (anger == -1){
            System.out.println(name1 + " strolls towards " + name2);
        }else if (anger == -1){
            System.out.println(name1 + " carefully approaches " + name2);
        }else if (anger == -1){
            System.out.println(name1 + " charges at " + name2);
        }else{
            System.out.println(name1 + " attempts to viscously jump at " + name2);
        }
    }

    //method to display all info of the Dog
    public String toString() {
        String output = "Name: " + dogName + "\n";
        output += "Breed: " + dogBreed + "\n";
        output += "Age: " + age + "\n";
        output += "Aggression: " + aggression + "\n";
        output += "Hunger: " + hunger;
        //output string is complete, return it
        return output;
    }
}
