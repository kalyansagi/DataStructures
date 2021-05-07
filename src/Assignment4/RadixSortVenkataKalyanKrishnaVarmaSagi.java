/*
Use given class Queue.java to implement the Radix Sort algorithm using queues we discussed in class.
Call the program RadixSortYourName.java.
The program prompts the user to enter the number of input values, then reads that many positive integer values and store them in an array of type integer (call it inputs).
Again, the program applies radix sort algorithm we discussed to the values stored in array inputs, and then prints out the content of the array before and after being sorted.
(There is no limitation of the number of digits of each integer. For example, your program must available on any integer possible number such as 492195 or 9817352)
How many integer numbers do you have?: 6          //  <- user input
Enter 6 integer numbers: 213 3465 7 29 541 45    //  <- user input
------------------------------------------------------
Inputs array before sorting (radix):  213, 3465, 7, 29, 541, 45
Inputs array after sorting (radix):   7, 29, 45, 213, 541, 3465

Notice that we are using ONLY one array (inputs).
Radix sort requires digit extraction. To do so, implement a separate method in class RadixSort (call it ExtractDigit(…)) to do this function. See class notes on how to do digit extraction from a numeric value. You also need to implement another method to do digit count in a number.
*/


import java.util.Arrays;
import java.util.Scanner;

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #4 – Radix Sort
 IDE : 	IntelliJ
*/
public class RadixSortVenkataKalyanKrishnaVarmaSagi {
    public static void main(String args[]) {
        Boolean runRadixSort = true;
        Scanner scanner = new Scanner(System.in);
        while (runRadixSort) {
            System.out.println("How many integer numbers do you have?: ");
            int count = scanner.nextInt();
            int[] numbers = new int[count];
            System.out.println("Enter " + count + " integer numbers:");
            for (int i = 0; i < count; i++) {
                numbers[i] = scanner.nextInt();
            }
            System.out.println("Inputs array before sorting (radix): " + Arrays.toString(numbers));

            //process array with radix sort
            radixSort(numbers);
            System.out.println("Inputs array after sorting (radix): " + Arrays.toString(numbers));
            System.out.println("Do you want to re-run code with different inputs (Y/N)?");
            String userDecision = scanner.next();
            if (userDecision.equalsIgnoreCase("N")) {
                runRadixSort = false;
            } else if (userDecision.equalsIgnoreCase("Y")) {
                runRadixSort = true;
            } else {
                System.out.println("Invalid input provided. Terminating the program");
                break;
            }
        }
    }

    //radix sort function
    public static void radixSort(int[] inputNumbers) {
        int n = findHighestNumberDigits(inputNumbers);
        //repeat the process until the size of highest digit number.
        for (int i = 0; i < n; i++) {
            extractDigitsFromNumbers(inputNumbers, i);
        }
    }

    public static void extractDigitsFromNumbers(int[] array, int position) {
        Queue<Integer> queue1 = new Queue<>();
        Queue<Integer> queue2 = new Queue<>();
        Queue<Integer> queue3 = new Queue<>();
        Queue<Integer> queue4 = new Queue<>();
        Queue<Integer> queue5 = new Queue<>();
        Queue<Integer> queue6 = new Queue<>();
        Queue<Integer> queue7 = new Queue<>();
        Queue<Integer> queue8 = new Queue<>();
        Queue<Integer> queue9 = new Queue<>();
        Queue<Integer> queue10 = new Queue<>();

        //read each digit from the input numbers and load into queue.
        for (int index = 0; index < array.length; index++) {
            int number = (int) ((array[index] % (Math.pow(10, position + 1))) / (Math.pow(10, position)));
            if (number == 0) {
                queue1.enqueue(array[index]);
            } else if (number == 1) {
                queue2.enqueue(array[index]);
            } else if (number == 2) {
                queue3.enqueue(array[index]);
            } else if (number == 3) {
                queue4.enqueue(array[index]);
            } else if (number == 4) {
                queue5.enqueue(array[index]);
            } else if (number == 5) {
                queue6.enqueue(array[index]);
            } else if (number == 6) {
                queue7.enqueue(array[index]);
            } else if (number == 7) {
                queue8.enqueue(array[index]);
            } else if (number == 8) {
                queue9.enqueue(array[index]);
            } else if (number == 9) {
                queue10.enqueue(array[index]);
            }
        }

        for (int index = 0; index < array.length; index++) {
            if (queue1.isEmpty() == false) {
                array[index] = queue1.front();
                queue1.dequeue();
            } else if (queue2.isEmpty() == false) {
                array[index] = queue2.front();
                queue2.dequeue();
            } else if (queue3.isEmpty() == false) {
                array[index] = queue3.front();
                queue3.dequeue();
            } else if (queue4.isEmpty() == false) {
                array[index] = queue4.front();
                queue4.dequeue();
            } else if (queue5.isEmpty() == false) {
                array[index] = queue5.front();
                queue5.dequeue();
            } else if (queue6.isEmpty() == false) {
                array[index] = queue6.front();
                queue6.dequeue();
            } else if (queue7.isEmpty() == false) {
                array[index] = queue7.front();
                queue7.dequeue();
            } else if (queue8.isEmpty() == false) {
                array[index] = queue8.front();
                queue8.dequeue();
            } else if (queue9.isEmpty() == false) {
                array[index] = queue9.front();
                queue9.dequeue();
            } else if (queue10.isEmpty() == false) {
                array[index] = queue10.front();
                queue10.dequeue();
            }
        }
    }

    public static int findHighestNumberDigits(int[] array) {
        int k = 0;
        //iterate the array
        for (int index = 0; index < array.length; index++) {
            int temp = 0;
            while (((int) (array[index] / (Math.pow(10, temp)))) != 0) {
                temp++;
            }
            if (k < temp)
                k = temp;
        }
        return k;
    }
}
