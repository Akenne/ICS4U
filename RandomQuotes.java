package RandomQuotes;

import java.io.*;

/**
 * Adam Kenneweg
 * April 10, 2014
 * Purpose: create a program that prints a random quote from a text file
 */

public class RandomQuotes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("quotes.txt"));
        /**
         * !!Add the directory above if necessary!!
         */
        //create the array to put the quotes in
        String quotes[] = new String[10];
        //put the quotes in each index of the array
        for(int i = 0; i<10; i++){
            String line = reader.readLine();
            quotes[i] = line;
        }
        //print a random quote
        System.out.println(quotes[(int)(Math.random()*10)]);
    }
}
