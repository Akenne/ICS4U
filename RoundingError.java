package roundingerror;
import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * 16/02/2014
 * Purpose: Find the rounding error due to the result of squaring the square root of a number
 */

public class RoundingError {
    public static void main(String[] args) {
        // Get the user input of the number, store as number
        double number = Double.parseDouble(JOptionPane.showInputDialog
                ("Please enter the number for which you want to find the rounding error"));
        // Square root the number and store it as sqrt
        double sqrt = Math.sqrt(number);
        // Square the square root of the number
        double square = Math.pow(sqrt, 2);
        // Print the result of squaring the square root of the number
        System.out.println("The square of the square root = " + square);
        // Find the rounding error by subtracting the square of the square root of the number from the number
        double error = number-square;
        // Print the rounding error
        System.out.println("The round off error = " + error);
    }
}
