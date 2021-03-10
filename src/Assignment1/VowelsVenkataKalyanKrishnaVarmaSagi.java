package Assignment1;/*
Write your Java program named VowelsYourName as follows. The main method prompts the user to enter a string. The main method then passes the input string to method countVowels(…)to recursively count and then return number of vowels (a, e, i, o, u) in the passed string. Again, method countVowels(…) is a recursive method.

Format the outputs as follows. Test data shows values for illustration, user may enter values one per line. Test strings does not show input prompts. User will input it.

Test data:

Entered string:	This is a test input
Number of vowels:	6

Entered string:	Hello world
Number of vowels:	3

Entered string:	My list of Objects
Number of vowels:	4

Document your code, use proper prompts for input, format outputs as shown above, use sound coding practices we learned thus far, do not hard code inputs, allow program re-runs, and test your code thoroughly.
 */

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment1 Programming 3
 IDE : 	IntelliJ
*/

import java.util.Scanner;

public class VowelsVenkataKalyanKrishnaVarmaSagi {

    public static void main(String args[]) {
        //Open Scanner.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prompting user to enter a string:");

        //Take input from user.
        String name = scanner.nextLine();
        System.out.println("Entered string: " + name);
        /*
            Now, call countVowels method passing the input taken from user.
            while calling countVowels method, we are converting the string to lowercase
            to avoid conflicts between capital letters and small letters.
         */
        System.out.println("Number of vowels: " + countVowels(name.toLowerCase()));
    }

    static int countVowels(String name) {
        int count = 0;
        //check if the string has no characters.
        if (name.length() < 1) {
            return 0;
        }
        //check if the first character in string is vowel. if yes, count it.
        else if (name.charAt(0) == 'a' || name.charAt(0) == 'e' || name.charAt(0) == 'i' || name.charAt(0) == 'o' || name.charAt(0) == 'u') {
            ++count;
        }
        //recursively call the same method with a substring after verifying the first character in string.
        return count + countVowels(name.substring(1));
    }
}


