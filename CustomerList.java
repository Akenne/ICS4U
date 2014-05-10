package CustomerList;
/**
 * Adam Kenneweg
 * April 14, 2014
 * Purpose: store customer information in a text file
 */
import java.io.*;
import javax.swing.JOptionPane;

public class CustomerList {

    public static void main(String[] args) throws IOException {
        String name, address, filename, province, postal;
        int customers;

        // !!Change the below file name to the location of the text file!!
        filename = "information.txt";

        // create a buffered reader to show the contents of file
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        // prints each line of the file until we reach the end
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        //PrintWriter class is used to open a file for output
        //It is used in conjunction with the FileWriter class
        PrintWriter fileOut = new PrintWriter(new FileWriter(
                filename, true));

        // check how many customers they want to add
        // check if it is a number as well, if it isnt ask again
        while (true){
            try {
                customers = Integer.parseInt(JOptionPane.showInputDialog
                        ("How many customers do you want to add?"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                          "Please input an integer!");
                continue;
            }
            break;
        }

        // for each customer we do a loop of inputting data
        for (int i = 1; i <= customers; i++) {
            JOptionPane.showMessageDialog(null, "Lets input customer " + i);
            // store the name,address,province as strings
            name = JOptionPane.showInputDialog
                ("What is the name of the customer?");
            address = JOptionPane.showInputDialog
                ("What is the address of the customer?");
            province = JOptionPane.showInputDialog
                ("What province is the customer from?");

            // get the postal code, and check if it is in valid format
            while (true){
                postal = JOptionPane.showInputDialog
                        ("What is the customer's postal code?");
                // strips unnecessary characters(spaces, tabs etc)
                postal.replaceAll("\\s+","");
                // checks if it has 6 characers, and if they are in the right spots
                // if it does break out of the while loop, otherwise do it again
                if ((postal.length() == 6)
                        && Character.isLetter(postal.charAt(0))
                        && Character.isDigit(postal.charAt(1))
                        && Character.isLetter(postal.charAt(2))
                        && Character.isDigit(postal.charAt(3))
                        && Character.isLetter(postal.charAt(4))
                        && Character.isDigit(postal.charAt(5))) {
                    break;
                } else {
                        JOptionPane.showMessageDialog(null,
                          "Please input the postal code correctly! EX: L4N 7X3");
                }
            }

            // append the new information to the file
            fileOut.println("Name: " + name);
            fileOut.println("Address: " + address);
            fileOut.println("Province: " + province);
            fileOut.println("Postal code: " + postal);
            fileOut.println();
        }
        //close the file
        fileOut.close();
    }
}
