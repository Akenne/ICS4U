package cartester;

import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * March 31, 2014
 * Purpose: create a CarTester client program
 */
public class CarTester {

    public static void main(String[] args) {
        //make the first car, users choice, get input for variables
        JOptionPane.showMessageDialog(null, "Lets make a bunch of cars!");
        JOptionPane.showMessageDialog(null, "Lets make the first car!");
        String make = JOptionPane.showInputDialog
                ("What is the make of the car?");
        String model = JOptionPane.showInputDialog
                ("What is the model of the car?");
        String colour = JOptionPane.showInputDialog
                ("What is the colour of the car?");
        int year = Integer.parseInt
                (JOptionPane.showInputDialog("What is the year of the car?"));
        int price = Integer.parseInt
                (JOptionPane.showInputDialog("What is the price of the car?"));
        int hp = Integer.parseInt
                (JOptionPane.showInputDialog("What is the horsepower of the car?"));
        //construct the car
        Car car1 = new Car(make, model, colour, year, price, hp);
        //give details and make noise
        System.out.println(car1);
        System.out.println("--------------------------");
        car1.Honk();
        System.out.println("--------------------------");

        //make the second car, a Lamborghini Aventador, get input for some variables
        JOptionPane.showMessageDialog(null,
                "Lets make the second car! It is a Lamborghini Aventador");
        colour = JOptionPane.showInputDialog
                ("What is the colour of the car?");
        year = Integer.parseInt(JOptionPane.showInputDialog
                ("What is the year of the car?"));
        hp = Integer.parseInt(JOptionPane.showInputDialog
                ("What is the horsepower of the car?"));
        //construct the car
        Car car2 = new Car(colour, year, hp);
        //give details and make noise
        System.out.println(car2);
        System.out.println("--------------------------");
        car2.Honk();
        System.out.println("--------------------------");

        //make the last car, using defualt constructor
        JOptionPane.showMessageDialog(null,
                "Lets make the default car!");
        //construct the car
        Car car3 = new Car();
        //give details and make noise
        System.out.println(car3);
        System.out.println("--------------------------");
        car3.Honk();
        System.out.println("--------------------------");
    }
}
