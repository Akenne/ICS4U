package Eratosthenes;
import javax.swing.JOptionPane;
/**
 * Adam Kenneweg
 * February 27, 2014
 * Purpose: Find prime numbers using Sieve of Eratosthenes
 */

public class Eratosthenes {
    public static void main(String[] args) {
        // Tell the user what the program does
        JOptionPane.showMessageDialog(null,
		"This program will find all prime numbers between 1 and an integer"
                + "of your choice using the Sieve of Eratosthenes");
        // Get them to enter the prime ceiling
        int max = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter the prime number max as an integer"));
        // Initialize our boolean array of all primes
        boolean[] primes = new boolean[max];
        // Make all true by default(1 is not prime)
        for(int i = 1; i<max; i++){
            primes[i] = true;
        }
        System.out.print("The prime numbers from 1 - " + max + " are:");

        // Check every number greater than and including 2 to see if they are prime
        for(int j = 2; j<= max; j++){
            // If it is a prime than continue, otherwise go to the next number
            if(primes[j-1] == true){
                // Since it's prime then print it to the user
                System.out.print(j + " ");
                /**
                 * Need to eliminate all the multiples of the prime from the list
                 * Start at the number we are on+1, we already know it is prime
                 * Check all subsequent numbers as well
                 * (This is sort of ineffecient but since we are only going up to
                 * 1000 it doesn't realy matter)
                 */

                for(int k = j+1; k<= max; k++){
                    // If the subsequent number divided by our new prime has a
                    // remainder of 0, than it is not a prime number
                    if(k%j == 0){
                        // Put it in the boolean array as false, repeat
                        primes[k-1] = false;
                    }
                }
            }
        }
    }
}
