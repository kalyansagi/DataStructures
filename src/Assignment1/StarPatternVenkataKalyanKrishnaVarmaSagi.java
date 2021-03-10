package Assignment1;/*
Programming #1 (10 points)
Write your Java program named StarPatternYourName as follows. The main method prompts the user to enter a number of rows. Then passes the input string to method printStars(…) to recursively print the pyramid stars. You can use recursive helper method if you need it.
Please carefully think about the number of spaces and stars. There is a space between stars.

Format the outputs as follows. Not only for 20, your program should run correctly with the other integers.

*/


/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment1 Programming 3
 IDE : 	IntelliJ
*/



import java.util.Scanner;

public class StarPatternVenkataKalyanKrishnaVarmaSagi {

    //main program to execute.
    public static void main(String[] args) {
        //Open Scanner.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prompting user to enter no of rows :");

        //Take input from user.
        int rows = scanner.nextInt();
        System.out.println("Entered rows: " + rows);

        //Call the function to print star pattern
        printStars(rows, rows);
    }

    // function to print the pattern
    public static void printStars(int n, int m) {

        //base case. last line completed.
        if (n == 0)
            return;
        //print spaces in a loop
        for (int i = n; i > 0; i--) {
            System.out.print(" ");
        }
        //print stars in a loop
        for (int i = m - n + 1; i > 0; i--) {
            System.out.print("* ");
        }
        //go to next line
        System.out.println();

        //repeat the process until all rows are printed.
        printStars(n - 1, m);
    }
}

