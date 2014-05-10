
public class WordPyramid {

    public static void main(String[] args) {
        String mySortedArray[] = {"black", "blue", "green", "orange",
            "peach", "purple", "red", "salmon", "tan", "yellow"};
        System.out.println("Binary Search: purple " + binarySearch(
                mySortedArray, 0, mySortedArray.length - 1, "purple"));
        System.out.println("Binary Search: green " + binarySearch(
                mySortedArray, 0, mySortedArray.length - 1, "green"));
        System.out.println("Binary Search: pink " + binarySearch(
                mySortedArray, 0, mySortedArray.length - 1, "pink"));

    }

    public static boolean binarySearch(String myArray[], int left,
            int right, String searchForColour) {
        //Temporary print for learning purposes
        System.out.print("Searching array: ");
        for (int i = left; i <= right; i++) {
            System.out.print("[" + myArray[i] + "]");
        }
        System.out.println(" for " + searchForColour);
        //end temporary print

        int middle;
        if (left > right) {
            return false;
        }
        middle = (left + right) / 2;
        if (myArray[middle].equals(searchForColour)) {
            return true;
        }
        System.out.println(searchForColour.compareTo(myArray[middle]));
        if (searchForColour.compareTo(myArray[middle]) < 0) {
            
            return binarySearch(myArray,  middle + 1, ,
                    searchForColour);
        } else {
            return binarySearch(myArray, middle + 1, right,
                    searchForColour);
        }
    }
}
