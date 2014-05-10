package Cancer;

import java.io.*;

/**
 * Adam Kenneweg
 * April 30, 2014
 * Purpose: find how many cancer cells are in a grid
 */
public class Cancer {
    //Make global variables (grid&blobSize) which are accessible
    //from anywhere inside the class FloodIntro
    public static String grid[][];
    public static int blobSize = 0;
    public static boolean cancer;

    public static void main(String[] args) throws IOException {
         //INSERT THE FILE NAME HERE!!!
        String filename = "cancer.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        int row = 0, col;
        //put the text file into array form
        grid = new String[15][15];
        while ((line = reader.readLine()) != null) {
            for (col = 0; col < 15; col++) {
                grid[row][col] =  Character.toString(line.charAt(col));
            }
            row++;
        }

        displayGrid();

        // search for cancer
        for (row = 0; row < 15; row++) {
          for (col = 0; col < 15; col++) {
              // use a boolean start it false
              // if we find a cancer blob it changes to true, and blob size increases
              cancer = false;
              floodFill(row, col);
              if(cancer){
                  blobSize++;
              }
          }
        }
        // print out info to user
        System.out.println("The file had " + blobSize +
          " cancer spots in it");
        System.out.println("The new grid is:");
        displayGrid();
    }

    public static void floodFill(int row, int col) {
        if (grid[row][col].equals("-")) {
            cancer = true;
            grid[row][col] = " ";
            floodFill(row - 1, col - 1);
            floodFill(row - 1, col);
            floodFill(row - 1, col + 1);
            floodFill(row, col - 1);
            floodFill(row, col + 1);
            floodFill(row + 1, col - 1);
            floodFill(row + 1, col);
            floodFill(row + 1, col + 1);
        }
    }

    public static void displayGrid() {
        String output = "";
        for (int row = 0; row < 15; row++) {
          for (int col = 0; col < 15; col++) {
            output += grid[row][col];
          }
          output += "\n";
        }
        System.out.println(output);
    }
}

