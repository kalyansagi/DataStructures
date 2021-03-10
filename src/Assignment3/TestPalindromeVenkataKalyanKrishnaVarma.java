package Assignment3;

import java.util.Scanner;

/*
Using class StackYourname above, implement another short and simple program, call it TestPalindromeYourname,
which prompts the user to enter a string value of any length. Using class StackYourname,
the TestPalindrome program creates one stack object and uses the object to check whether the entered input string is a palindrome or not.
The program displays both the input string and the judgment statement (Palindrome or Not Palindrome).
This program is case insensitive. Also, it ignores whitespaces.
Enter a string: Race car
Input String:	Race car
Judgment:		Palindrome

 Enter a string: CS5040
Input String:	CS5040
Judgment:		Not Palindrome

You can use a sentinel loop to run the program again and again. But it is not mandatory, it is good even if your program runs only one time.

*/

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #3 – Palindrome using stack
 IDE : 	IntelliJ
*/
public class TestPalindromeVenkataKalyanKrishnaVarma {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String userInput = scanner.nextLine(); //Capture a string from user.
        String input = ""; //We will clean the user entered string and save it in this in next steps.
        String output = ""; //This is for building the reserve of the cleaned string using stack functions.
        System.out.println("Input string: " + userInput);
        StackVenkataKalyanKrishnaVarmaSagi stackVenkataKalyanKrishnaVarmaSagi = new StackVenkataKalyanKrishnaVarmaSagi();
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            //check if there is any empty space in user entered string. Ignore such and clean the input to avoid spaces.
            if (c != ' ') {
                input = input + c;
                stackVenkataKalyanKrishnaVarmaSagi.push(c); //calling push method in my implementation.
            }
        }
        while (!stackVenkataKalyanKrishnaVarmaSagi.isEmpty()) {
            output = output + stackVenkataKalyanKrishnaVarmaSagi.peek(); //build the output string by taking each element from top of stack.
            stackVenkataKalyanKrishnaVarmaSagi.pop(); //pop out element on the top of stack.
        }
        //using equalsIgnoreCase function in String class to make sure we are verifying the strings irrespective of the case sensitivity.
        if (input.equalsIgnoreCase(output)) {
            System.out.println("Judgement: Palindrome");
        } else
            System.out.println("Judgement: Not Palindrome");
    }
}
