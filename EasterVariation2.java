package eastervariation2;
import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * 16/02/2014
 * Purpose: Find the date of Easter in any given year
 */

public class EasterVariation2 {
    public static void main(String[] args) {
        String month2;
        // Get user input for the year they want to find easter for
        int year = Integer.parseInt(JOptionPane.showInputDialog
                ("Input the year for which you want to find the date of easter"));
        // Divide the year by 100 to get the quotient a, and the remainder b
        int a = year/100;
        int b = year%100;
        // Divide (3 * (a + 25)) by 4 to get the quotient c, and the remainder d
        int c = (3 * (a + 25))/4;
        int d = (3 * (a + 25))%4;
        // Divide (8 * (a + 11) by 25 to get the quotient q
        int q = (8 * (a + 11)/25);
        // Divide (5*a + b) by 19 to get the remainder f
        int f = (5*a + b)%19;
        // Divide (19*f + c - q) by 30 to get the remainder g
        int g = (19*f + c - q)%30;
        // Divide (f + 11*g) by 319 to get the quotient h
        int h = (f + 11*g)/319;
        // Divide (60 * (5 - d) + b) by 4 to get the quotient j, and the remainder k
        int j = (60 * (5 - d) + b)/4;
        int k = (60 * (5 - d) + b)%4;
        // Divide (2*j - k - g + h) by 7 to get the remainder n
        int n = (2*j - k - g + h)%7;
        // Divide (g - h + n + 114) by 31 to get the divisor which is the month, and the remainder + 1 which is the day
        int month = (g - h + n + 114)/31;
        int day = ((g - h + n + 114)%31)+1;

        // Convert the month from an integer to the correct month name
        // Easter is only in March or April, so if it is not in March then it must be in april
        if (month == 3){
            month2 = "March";
        } else {
            month2 = "April";
        }

        // Print the date of Easter to the user
        JOptionPane.showMessageDialog(null, "Easter is on " + month2 + " " + day + " in the year " + year);
    }
}

