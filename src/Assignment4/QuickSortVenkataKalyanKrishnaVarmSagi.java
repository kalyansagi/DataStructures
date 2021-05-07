
/*
Implement the Quick Sort algorithm.
Write a recursive method which is discussed in our class.
Call the program QuickSortYourName.java.
The program prompts the user to enter the number of input values, then reads that many positive integer values and store them in an array of type integer (call it inputs).
Again, the program applies quick sort algorithm we discussed to the values stored in array inputs, and then prints out the content of the array before and after being sorted.
How many integer numbers do you have?: 6          //  <- user input
Enter 6 integer numbers: 213 3465 7 29 541 45    //  <- user input
------------------------------------------------------
Inputs array before sorting (quick):  213, 3465, 7, 29, 541, 45
Inputs array after sorting (quick):   7, 29, 45, 213, 541, 3465
*/

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #4 – Quick Sort
 IDE : 	IntelliJ
*/

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortVenkataKalyanKrishnaVarmSagi {

    public static void main(String args[]) {
        Boolean runQuickSort = true;
        Scanner scanner = new Scanner(System.in);

        while (runQuickSort) {
            System.out.println("How many integer numbers do you have?: ");
            int count = scanner.nextInt();
            int[] inputs = new int[count];
            System.out.println("Enter " + count + " integer numbers:");
            for (int i = 0; i < count; i++) {
                inputs[i] = scanner.nextInt();
            }
            System.out.println("Inputs array before sorting (quick): " + Arrays.toString(inputs));
            //calling sort function logic here.
            quickSort(inputs, 0, inputs.length - 1);
            System.out.println("Inputs array after sorting (quick): " + Arrays.toString(inputs));
            System.out.println("Do you want to re-run code with different inputs (Y/N)?");
            String userDecision = scanner.next();
            if (userDecision.equalsIgnoreCase("N")) {
                runQuickSort = false;
            } else if (userDecision.equalsIgnoreCase("Y")) {
                runQuickSort = true;
            } else {
                System.out.println("Invalid input provided. Terminating the program");
                break;
            }
        }
    }

    private static void quickSort(int[] numbers, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(numbers, first, last);
            quickSort(numbers, first, pivotIndex - 1);//left half
            quickSort(numbers, pivotIndex + 1, last);//right half
        }
    }

    //partition the input array
    private static int partition(int[] numbers, int first, int last) {
        int pivot = numbers[first]; //assume first element in list as pivot
        int low = first + 1;
        int high = last;
        while (high > low) {
            //search from left
            while (low <= high && numbers[low] <= pivot) {
                low++;
            }
            //search from right
            while (low <= high && numbers[high] > pivot) {
                high--;
            }
            //swap elements in list
            if (high > low) {
                int temp = numbers[high];
                numbers[high] = numbers[low];
                numbers[low] = temp;
            }
        }
        while (high > first && numbers[high] >= pivot) {
            high--;
        }
        if (pivot > numbers[high]) {
            numbers[first] = numbers[high];
            numbers[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
}
