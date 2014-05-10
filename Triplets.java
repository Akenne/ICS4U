package Triplets;
import java.util.ArrayList;
/**
 * Adam Kenneweg
 * February 27, 2014
 * Purpose: Create triplet poems in ABA format
 */

public class Triplets {
  public static void main(String[] args) {
    // This program will use a dynamic arrays
    // The words are added to the arrays
    ArrayList<String> nouns = new ArrayList<String>();
    nouns.add("bear");
    nouns.add("reindeer");
    nouns.add("elephant");
    nouns.add("moose");
    nouns.add("panda");
    nouns.add("cat");
    nouns.add("zebra");

    ArrayList<String> verbs = new ArrayList<String>();
    verbs.add("sprinted");
    verbs.add("jumped");
    verbs.add("raced");
    verbs.add("ran");
    verbs.add("walked");
    verbs.add("leaped");
    verbs.add("hopped");

    ArrayList<String> rhymingNouns = new ArrayList<String>();
    rhymingNouns.add("shoe");
    rhymingNouns.add("stew");
    rhymingNouns.add("screw");
    rhymingNouns.add("bamboo");
    rhymingNouns.add("kazoo");
    rhymingNouns.add("shampoo");
    rhymingNouns.add("canoe");

    String noun, noun2;
    String verb1, verb2, verb3;
    String rhymingNoun1, rhymingNoun2;
    int randomNum;

    //get a random noun from the nouns array
    //use .size() to get the # of elements
    randomNum = (int) (Math.random() * nouns.size());
    noun = nouns.get(randomNum);

    //get the second noun from the nouns array
    randomNum = (int) (Math.random() * nouns.size());
    noun2 = nouns.get(randomNum);

    //get the first random verb from the verbs array &
    // remove from ArrayList
    randomNum = (int) (Math.random() * verbs.size());
    verb1 = verbs.get(randomNum);
    verbs.remove(randomNum);

    //get the second random verb from verbs array and remove it
    randomNum = (int) (Math.random() * verbs.size());
    verb2 = verbs.get(randomNum);
    verbs.remove(randomNum);

    //get the third random verb from verbs array and remove it
    randomNum = (int) (Math.random() * verbs.size());
    verb3 = verbs.get(randomNum);
    verbs.remove(randomNum);

    //get the first rhyming noun and remove it
    randomNum = (int) (Math.random() * rhymingNouns.size());
    rhymingNoun1 = rhymingNouns.get(randomNum);
    rhymingNouns.remove(randomNum);

    //get the second rhyming noun and remove it
    randomNum = (int) (Math.random() * rhymingNouns.size());
    rhymingNoun2 = rhymingNouns.get(randomNum);
    rhymingNouns.remove(randomNum);

    //Display the poem
    System.out.println("The " + noun + " almost " + verb1 + " to the " +
      rhymingNoun1 + "\nBut instead it " + verb2 + " into the " + noun2
      + "\nThen it " + verb3 + " on the " + rhymingNoun2);
    }
}
