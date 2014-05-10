package Filehandler;

import java.io.*;
import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * April 10, 2014
 * Purpose: create a program that reads a text file and displays its contents
 */

public class TextFileReader {
    public static void main(String[] args) throws IOException {
        //asks the user the file name
        String filename = JOptionPane.showInputDialog
                ("What is the name of the text file");
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        /**
         * ^^This uses the files in the source directory for me
         * use the below buffer reader instead to use a specific directory
         * (replace g:/ with the files folder)
         */
        //BufferedReader reader = new BufferedReader(new FileReader("g:/" + filename));

        //prints each line of the file until we reach the end
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
