package Psalms;

import java.io.*;
import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * May 7, 2014
 * Purpose: Display psalms from text file
 */
public class Psalms {
    public static int middle;
    public static void main(String[] args) throws IOException {
        //INSERT THE FILE NAME HERE!!!
        String filename = "psalms.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;

        int a=0,b=0,i=0;
        //find how long the file is
        FileInputStream fstream = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = null;
        int count = 0;
        while ((strLine = br.readLine()) != null) {
            count++;
        }
        //half the length of the file is the number of psalms
        String[] psalm = new String[count/2];
        int[] number = new int[count/2];

        while ((line = reader.readLine()) != null) {
            // every second line is the psalm
            if (((i+1)%2)==0){
                psalm[a] = line;
                a++;
            //every first line is the number
            }else{
                number[b] = Integer.parseInt(line);
                b++;
            }
            i++;
        }
        String psnum = JOptionPane.showInputDialog
                ("What psalm would you like to see? (1-150)");
        // if the search finds the psalm, tell it to the user
        if(binarySearch(number, 0,number.length - 1, Integer.parseInt(psnum))){
            System.out.println("Psalm " +psnum+ " is " + psalm[middle]);
        // if not, tell them it's not there
        }else{
            System.out.println("There is no psalm " + psnum + " in our text file :(");
        }
    }
// I changed the binary search to use ints, and to make middle global for displaying
// the psalm back to the user.
    public static boolean binarySearch(int myArray[], int left,
            int right, int searchForColour) {
        if (left > right) {
            return false;
        }
        middle = (left + right) / 2;
        if (myArray[middle]  == (searchForColour)) {
            return true;
        }
        if (searchForColour > myArray[middle]) {
            
            return binarySearch(myArray,  middle + 1, right,
                    searchForColour);
        } else {
            return binarySearch(myArray, left, middle - 1,
                    searchForColour);
        }
    }
}
