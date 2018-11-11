import java.util.Scanner;
/**
 * This is a guessing game that guesses the number you are thinking of using the least possible amount of guesses.
 * @ author Holly Harnack 
 * @ version 10/08/2018 
 */

public class GuessingGame {
    public static void main(String[] args) {
        String ans = "";
        int lowerNumber, higherNumber, average;
        Scanner in = new Scanner(System.in); 

        //number has to be greater than 0 and less than 100
        System.out.print("I will guess your number!\nThink of a number.\nYour number has to be " +
            "within the range 0 and 100.\nMy number is between(enter lower number)...\n"); 
        lowerNumber = in.nextByte();                              

        if ((0 > lowerNumber) || (lowerNumber > 100)) {
            System.out.println("Number is not within range");    //sets limit for lower number       
            System.exit(0);
        }

        System.out.print("and....(enter higher number)\n");
        higherNumber = in.nextByte();                                       

        if ((0 > higherNumber) || (higherNumber > 100)) { 
            System.out.println("Number is not within range.");   //sets limit for higher number 
            System.exit(0);
        }

        average = (higherNumber + lowerNumber)/2;                //takes the average of the two numbers
        
        in .nextLine();                                          //consumes next line so that input in loop works 
        
        while (!(ans.equals("yes")))                                     //while the number isn't guessed correctly 
        {
            System.out.print("Is your number " + average + 
                "? (only answer with 'yes' 'lower' or 'higher')\n"); 
            ans = in.nextLine(); 
            if (ans.equals("higher"))                          
            {
                lowerNumber = average;                    //the previous value for the middle number becomes the new lower limit
                average = (average + higherNumber)/2;
                System.out.print("test");                 //calculating the average of the new range, narrowing down possible answers
            }
            else if (ans.equals("lower"))                      
            {
                higherNumber = average;                   //the previous value for the middle number becomes the new higher limit
                average = (average + lowerNumber)/2;      //calculating the average of the new range, narrowing down possible answers
            } 
        }
        System.out.print("Got it!");
    }
}

