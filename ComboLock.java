package ComboLock;

/**
 * Adam Kenneweg
 * April 3, 2014
 * Purpose: create a class that models a combo lock
 */
public class ComboLock {
    String code;
    int number1, number2, number3;

    //default constructor(random combo)
    public ComboLock(){
        // combo is randomized
        number1 = (int)(Math.random()*3 + 1);
        number2 = (int)(Math.random()*3 + 1);
        number3 = (int)(Math.random()*3 + 1);
        //combo in string form for easy comparison
        code = "" + number1 + "-" + number2 + "-" + number3;
    }

    //user input combo constructor
    public ComboLock(int num1, int num2, int num3){
        number1 = num1;
        number2 = num2;
        number3 = num3;
        //combo in string form for easy comparison
        code = "" + number1 + "-" + number2 + "-" + number3;
    }
}
