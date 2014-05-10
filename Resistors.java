package Resistors;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 * Adam Kenneweg
 * February 27, 2014
 * Purpose: Find resistance when given colours
 */

public class Resistors {
    public static void main(String[] args) {
        // The end array is initialized for use in the final formula
        String[] end = new String[3];
        // The colours of all the resistors is initialized
        String[] resistors = {"black", "brown", "red", "orange", "yellow", "green"
         , "blue", "violet", "gray", "white"};
        // The user inputs the resistor colours which is stored as a string sentence
        String res = JOptionPane.showInputDialog(
                "What is the resistors colour code?"
                + "\nSeperate the colours by hypens"
                + "\nEx: Red-Orange-Black");
        // Spaces are removed, and the string is made lowercase
        res = res.replace(" ", "");
        res = res.toLowerCase();
        // The colours are split into an array, by the hyphens
        String[] colours = res.split("-");
        // For each colour in the array, the resistance value is found
        for(int i = 0; i<3; i++){
            /**
             * Where the colour is located in the array is found(this also is
             * the resistance value)
             * This is turned into a string so the numbers can be put together
             * (this is required by the formula), and then put into the end array
             */
            end[i] = Integer.toString(Arrays.asList(resistors).indexOf(colours[i]));
        }
        // (The first two resistance numbers merged) * 10^(third resistance value)
        // The first two resistance numbers are merged
        double x1 = Double.parseDouble(end[0] + end[1]);
        // The third is converted to a double
        double x2 = Double.parseDouble(end[2]);
        // The formula to find resistance is done
        double resist = x1 * Math.pow(10, x2);
        // The resistance is outputted to the user
        JOptionPane.showMessageDialog(null, "The resistance is: " + resist + " ohms");
    }
}
