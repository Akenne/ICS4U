
package WordJumble;

import javax.swing.JOptionPane;

/**
 * Adam Kenneweg
 * April 30, 2014
 * Purpose: list all of the “word” possibilities from a set of letters
 */

public class WordJumble {
    public static void main(String[] args) {
        String letters = JOptionPane.showInputDialog
                ("Please enter a word");
        jumbleWords(letters, "");
    }

    //input parameters
    //word - the remaining letters in the word still to jumble
    //jumbLet - the letters already used to create
    //the jumbled word
    public static void jumbleWords(String word, String jumbLet) {
        int pos;
        String remainingLetters;
        String origWord = word;
        String origJumbledLetters = jumbLet;
        if (word.length() == 1) {
            System.out.println(jumbLet + word);
        } else {
          for (pos = 0; pos < origWord.length(); pos++) {
            remainingLetters = origWord.substring(0, pos)
              + origWord.substring(pos + 1, origWord.length());
            //recursive call to jumbleWords()
            jumbleWords(remainingLetters,
              origJumbledLetters + origWord.charAt(pos));
          }
        }
    }
}