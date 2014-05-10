package cartester;

import java.util.Random;

/**
 * Adam Kenneweg
 * March 31, 2014
 * Purpose: create a Car class definition
 */
public class Car{
    //variables for characteristics
    private String carMake, carModel, colour;
    private int year, price, horsepower;

    //default constructor(most popular car ever)
    public Car () {
        carMake = "Toyota";
        carModel = "Corolla";
        colour = "Blue";
        year = 1974 ;
        price = 4000;
        horsepower = 60 ;
    }

    //Users choice constructor
    public Car(String crMake, String crModel, String clr, int yr, int pric, int hp){
        carMake = crMake;
        if(carMake.equals("")){carMake = "Unknown Make";}//check to see if they entered nothing
        carModel = crModel;
        if(carModel.equals("")){carModel = "Unknown Model";}
        colour = clr;
        if(colour.equals("")){colour = "Unknown Colour";}
        year = yr;
        price = pric;
        horsepower = hp;
    }

    //Lamborghini Aventador constructor
    public Car(String clr, int yr, int hp){
        carMake = "Lamborghini";
        carModel = "Aventador";
        colour = clr;
        if(colour.equals("")){colour = "Unknown Colour";}
        year = yr;
        price = 400000;
        horsepower = hp;
    }

    //randomized car noises
    public void Honk() {
        Random rand = new Random();
        int random = rand.nextInt(3);
        if(random == 0){
            System.out.println("Beep! Beep!");
        }else if(random == 1) {
            System.out.println("Honk! Honk!");
        }else{
            System.out.println("Toot! Toot!");
        }
        
    }

    //method to display all info of the car
    public String toString() {
        String output = "Make: " + carMake + "\n";
        output += "Model: " + carModel + "\n";
        output += "Colour: " + colour + "\n";
        output += "Year: " + year + "\n";
        output += "Price: " + price + "\n";
        output += "Horsepower: " + horsepower;
        //output string is complete, return it
        return output;
    }
}
