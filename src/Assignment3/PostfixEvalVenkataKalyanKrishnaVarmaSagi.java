package Assignment3;
/*
Using class StackYourname above, implement another short and simple program, call it PostfixEvalYourname, which prompts the user to enter a string value of postfix expression. Using class StackYourname, the program should evaluate the postfix expression and get the correct calculated result. The program displays both the input
Assumption:
Input postfix string doesn’t have whitespaces.
All input number is one-digit number. (positive digit 0 to 9)
Operator ^ + - * / can be used.
	If postfix input is not calculatable, show the result

Enter a string: 	562^2-*
Result value:	170

Enter a string: 	562^2-
Result value:	The input Postfix expression is not valid.
*/

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #3 – Postfix Evaluation
 IDE : 	IntelliJ
*/

import java.util.Scanner;

public class PostfixEvalVenkataKalyanKrishnaVarmaSagi {

    public static void main(String args[]) {

        //Initialize the Stack we implemented.
        StackVenkataKalyanKrishnaVarmaSagi<Integer> stackVenkataKalyanKrishnaVarmaSagi = new StackVenkataKalyanKrishnaVarmaSagi();

        //Take input
        System.out.println("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*' || input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '^') {
                char operator = input.charAt(i);
                int a = stackVenkataKalyanKrishnaVarmaSagi.pop();
                int b = stackVenkataKalyanKrishnaVarmaSagi.pop();
                if (operator == '+')
                    stackVenkataKalyanKrishnaVarmaSagi.push(b + a);
                if (operator == '-')
                    stackVenkataKalyanKrishnaVarmaSagi.push(b - a);
                if (operator == '*')
                    stackVenkataKalyanKrishnaVarmaSagi.push(b * a);
                if (operator == '/' && a != 0) //make sure you are not performing division with 0
                    stackVenkataKalyanKrishnaVarmaSagi.push(b / a);
                if (operator == '^')
                    stackVenkataKalyanKrishnaVarmaSagi.push((int) Math.pow(b, a));
            } else {
                int operand = Character.getNumericValue(input.charAt(i));
                stackVenkataKalyanKrishnaVarmaSagi.push(operand);
            }
        }
        if (stackVenkataKalyanKrishnaVarmaSagi.size() > 1)
            System.out.println("The input Postfix expression is not valid.");
        else
            System.out.println("Result value: " + stackVenkataKalyanKrishnaVarmaSagi.pop());
    }
}
