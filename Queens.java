package javaapplication4;

import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * 18/02/2014
 * Purpose: Place queens
 * on a chessboard
 */

public class Queens {
    public static void queens(String[] args) {
        int board[][] = new int[8][8]; // Initialize chess board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }
        JOptionPane.showMessageDialog(
                null, "Place 8 queens on a chess board!");
        for(int q = 0; q<8; q++){ // each iteration of the loop is a new queen
            // reset x and y values at beginning of loop
            int x = 0;
            int y = 0;
            JOptionPane.showMessageDialog( // tell user what queen they are placing
                    null, "Lets place queen number " + (q+1));
            while(y<1 || y>8){ // find the vertical position
                y = Integer.parseInt(JOptionPane.showInputDialog
                    ("What is the vertical location of the queen(bottom to top,"
                    + " 1 to 8)"));
            }
            while (x < 1 || x > 8) { // find the horizontal position
                x = Integer.parseInt(JOptionPane.showInputDialog
                    ("What is the horizontal location of the queen(left to right,"
                    + " 1 to 8)"));
            }
            board[8-y][x-1] = 1; // Place the queen on the board
            System.out.println("~~~~~~~~~~~"); // print the board
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
}
