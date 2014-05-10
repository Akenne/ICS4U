package assignment4;
import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * February 23, 2014
 * Purpose: Conway's Game of Life
 */
public class GameOfLife {
    public static void main(String[] args) {
        // The board 2d array is created
        String board[][] = new String[20][20];
        // A similar array is created to store whether cells are alive or dead
        int on[][] = new int[20][20];
        // We start at generation one
        int generation = 0;

        //initialize the board to spaces
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                board[i][j] = ".";
            }
        }

        //Determine the number of cells to start with
        int cells = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the game of life!\n"
        + "Please enter how many cells you wish to start the game with."));

        //Place random cells on the board
        int randCol, randRow;
        int newCells = 0;
        // keep picking random cell locations until we've created the correct number of new cells
        while (newCells < cells) {
            randCol = (int) (Math.random() * 20);
            randRow = (int) (Math.random() * 20);
            // check that this location is still empty before putting a new cell in it
            if (board[randCol][randRow].equals(".")) {
                board[randCol][randRow] = "O";
                newCells++;
            }
        }
        // We initially check what cells are alive or dead
        for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if(board[i][j].equals("O")){
                        on[i][j] = 1;
                    }else{
                        on[i][j] = 0;
                    }
                }
       }
        int reply = 1;
        // A while loop is used, each loop is a generation
        while (reply != 0){
            // The board is printed
            System.out.println("\n~~~~GENERATION " + generation + "~~~~");
            generation += 1;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            // If the reply is one the user has to choose whether to continue or exit
            if (reply == 1){
                reply += Integer.parseInt (JOptionPane.showInputDialog
                    ("How many generations do you want to advance? (0 to exit)"));
            }
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    /**
                     * n is the number of neighbour alive cells
                     * We check each cell to see how many neighbours it has, sometimes
                     * the checking causes us to go out of bound(of the array), so
                     * we catch the exception and ignore it(out of bounds is dead)
                     */
                    int n = 0;
                    try{n += on[i+1][j+1];}catch(IndexOutOfBoundsException e){}
                    try{n += on[i+1][j];}catch(IndexOutOfBoundsException e){}
                    try{n += on[i+1][j-1];}catch(IndexOutOfBoundsException e){}
                    try{n += on[i][j+1];}catch(IndexOutOfBoundsException e){}
                    try{n += on[i][j-1];}catch(IndexOutOfBoundsException e){}
                    try{n += on[i-1][j+1];}catch(IndexOutOfBoundsException e){}
                    try{n += on[i-1][j];}catch(IndexOutOfBoundsException e){}
                    try{n += on[i-1][j-1];}catch(IndexOutOfBoundsException e){}

                    if(on[i][j] == 1){// if the cell is alive
                        if(n != 2 && n != 3){// if it doesnt have 2 or 3 neighbours it dies
                            on[i][j] = 0;
                            board[i][j] = ".";
                        }// otherwise it stays alive
                    }else{// if the cell is dead
                        if(n == 3){// if it has 3 neighbours, it comes to life
                            on[i][j] = 1;
                            board[i][j] = "O";
                        }// otherwise it stays dead
                    }
                }
           }
            reply -= 1;// The amount of times the user wanted us to advance goes down by 1
            try {// We delay the next generation 300ms to make it look prettier
                Thread.sleep(300);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.exit(0);// if the user entered 0 we exit
    }
}
