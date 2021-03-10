package Assignment1;/*
Programming #3 (10 points)
Write a java program (name it AverageGradeYourName) as follows: The main method prompts the user to enter number of students in a class (class size is integer value), then prompts the user to enter the grades (between 0 and 100) into an array of type integer. The entered class size determines the array size. Next, the main method passes the filled array to method findAverage(…)to recursively determine and return the class average as a double value. Again, method findAverage(…)is a recursive method.

Format the outputs as follows. Shown input values are just for illustration, user may enter values one per line. Test data does not show input prompts.

Test data:

Class size:		3
Entered grades:	100 100 100
Class average:		100.00

Class size:		7
Entered grades:	50 75 80 80 40 35 85
Class average:		63.57

Class size:		8
Entered grades:	0 100 25 90 55 30 90 35
Class average:		53.13

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

public class AverageGradeVenkataKalyanKrishnaVarmaSagi {

    public static void main(String args[]) {

        //Open Scanner.
        Scanner scanner = new Scanner(System.in);

        //Take class size input and save in size variable.
        System.out.println("Class size:");
        int size = scanner.nextInt();

        //Initialize an array of Double datatype. Size of the array is of the Class size.
        Double[] grades = new Double[size];
        System.out.println("Entered grades:");
        for (int i = 0; i < size; i++) {
            grades[i] = scanner.nextDouble();
        }
        //Call the function to find out average
        Double avgGrade = findAverage(grades, grades.length);
        System.out.println("Average grade:" + avgGrade);
    }

    public static Double findAverage(Double[] grades, int size) {
        //if no more grades are left in the array, return 0.00
        if (size == 0)
            return 0.00;

        //if last one grade value is left in the array, return it.
        if (size == 1)
            return grades[size - 1];
        //recursively call the function
        return (findAverage(grades, size - 1) * (size - 1) + grades[size - 1]) / size;
    }
}
