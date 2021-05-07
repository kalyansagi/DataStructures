
/*
Assignment Description:
The goal of this assignment is to work with hash functions and understand the performance of the Division method(key mod m OR key % m) using open addressing techniques discussed in the slides.

Write one simple program named HashTableYourname that uses a fixed set of 50 unique keys stored in an array as follows (Important: hard-code the array content in your program and make sure you have same exact key values below in the same order):

 int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
               5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
               5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
               5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
               5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

The program allows the user to select a hash function, from the menu, to be invoked on the set of keys. Keep it simple as follows:

-----MAIN MENU-----
0 - Exit Program
1 – Run HF1 (Division with Linear Probing)
2 – Run HF2 (Division with Quadratic Probing)
3 – Run HF3 (Division with Double Hashing)
4 – Run HF4 (Student-Designed Function)

The hash functions are defined below.
To keep the implementation simple, design the hash table (call it table) (of size 50) as a 2D array (50 rows and 2 columns) (int[][] table = new int[50][2];) The first column stores the keys while the second column stores number of probes used to resolve collisions.

After calling the hash function from the menu, the output of the program should display the hash table followed by the sum of all probe values in the table. Declare a separate method in your class, say sumProbes(), to perform this calculation and return the sum of all probes in the table (second column of the table).
Note that the total number of probes a hashing function generates indicates the performance level of the function - The smaller the sum of probes the better the hash function.

HF1: Linear Probing
Declare a separate method HF1() that implements the Division method with Linear Probing for collision resolution.
-	Division method should be H(x) = (x mod m) +1 in the slide, but the index of array start from 0. So, please use hashing key % 50 (key mod m while m is the size of the array).
-	For Linear Probing, use d+i (while i is the number of probes) which is explained in the class.
-	If the index is exceed current array’s maximum index, use mod m for circular array.

HashFunction 2:
Declare a separate method HF2() that implements the Division method with Quadratic Probing for collision resolution.
-	Use hashing key % 50 while m is the size of the array.
-	For Quadratic Probing, use d+i2 (while i is the number of probes) which is explained in the class.
-	If the index is exceed current array’s maximum index, use mod m for circular array.

HashFunction 3:
Declare a separate method HF3() that implements the Division method discussed in the slides with Double Hashing for collision resolution.  For the second hashing function, use the following function and increment (see example in slides)
Hash(key) = key % 50;
Hash2(key) = 30 – key % 25;
Increment is (key % 50) + j * Hash2(key)     for j=1, 2, 3, 4, … (j is number of probes)

Note: It is possible that HF3 will not be able to determine and empty index in the hash table for a give key, especially when very few empty entries remain in the hash table. In this case and to avoid entering into an infinite loop, limit number of attempts to locate a key in the hash table to no more than 50 tries.
In such case, printout a message like “Unable to store key 43654 to the table”.
Note this phenomenon happens due to not applying Load Factoring to our table.


HashFunction 4:
Declare a separate method HF4() that implements a hash function of your own design. The sky is your limit. You can come up with your own hash function or take and improve one of the above three functions by either using a different hashing method (other than Division method) or a different collision resolution method. Aim to come up with a function that beats the above three function (i.e., your function generates smallest number of probes for the given set of keys).
Note: See the note in HF3 and apply it to your HF4 if necessary.

The assignment is very specific, and it must be implemented as specified.
Any deviation from these requirements is not acceptable and receives no points. No exceptions.

Only complete and correct code receives credit. Code must compile and run on its own as received. Using code from outside sources receives NO credit.

Format the output following the sample run below.
Sample output for format illustration purpose only (Our table is of size 50 elements)
Hash table resulted from HF2:

Index		Key		probes
------------------------------
  0		4576		0
  1		9876		2
  2		2341		0
  3		8722		3
  4		9988		4
  5		1111		0
  6		3443		1
  7		4444		0
  8		7788		1
  9		2321		0
------------------------------
Sum of probe values = 11 probes.

*/

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #5 – HashTable
 IDE : 	IntelliJ
*/

import java.util.Scanner;

public class HashTableVenkataKalyanKrishnaVarmaSagi {

    public static void main(String args[]) {
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
        int size = 50;
        int[][] table = new int[size][2];
        int option = 0;

        Boolean runHashTable = true;
        Scanner scanner = new Scanner(System.in);
        while (runHashTable) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 2; j++)
                    table[i][j] = 0; //empty out the table.
            }
            System.out.println("-----MAIN MENU-----\n" +
                    "0 - Exit Program\n" +
                    "1 – Run HF1 (Division with Linear Probing)\n" +
                    "2 – Run HF2 (Division with Quadratic Probing)\n" +
                    "3 – Run HF3 (Division with Double Hashing)\n" +
                    "4 – Run HF4 (Student-Designed Function)\n");

            System.out.println("Select a hash function:");
            option = scanner.nextInt();
            if (option == 0) {
                return;
            }
            if (option == 1) {
                for (int i = 0; i < keys.length; i++) {
                    int mod = keys[i] % 50;
                    runHF1(table, keys[i], 0, mod);
                }
                printTable(option, table);
            }
            if (option == 2) {
                for (int i = 0; i < keys.length; i++) {
                    int mod = keys[i] % 50;
                    runHF2(table, keys[i], 0, mod);
                }
                printTable(option, table);
            }
            if (option == 3) {
                for (int i = 0; i < keys.length; i++) {
                    int mod = keys[i] % 50;
                    runHF3(table, keys[i], 0, doubleHash(keys[i], 1), 1, mod);
                }
                printTable(option, table);
            }
            if (option == 4) {
                for (int i = 0; i < keys.length; i++) {
                    int mod = keys[i] % 50;
                    runHF4(table, keys[i], 0, customHash(keys[i], 1), 1, mod);
                }
                printTable(option, table);
            }
            System.out.println("Do you want to re-run code with different inputs (Y/N)?");
            String userDecision = scanner.next();
            if (userDecision.equalsIgnoreCase("N")) {
                runHashTable = false;
            } else if (userDecision.equalsIgnoreCase("Y")) {
                runHashTable = true;
            } else {
                System.out.println("Invalid input provided. Terminating the program");
                break;
            }
        }
    }

    //function to perform Division with a Custom Hashing
    private static void runHF4(int[][] table, int key, int probe, int hash, int count, int mod) {

        if (table[mod % 50][0] == 0) {
            table[mod % 50][0] = key;
            table[mod % 50][1] = probe;
            count = 1;
        } else {

            if (table[customHash(key, count) % 50][0] == 0) {
                table[customHash(key, count) % 50][0] = key;
                table[customHash(key, count) % 50][1] = probe + 1;
                count++;
            } else if (probe < 50)
                runHF4(table, key, probe + 1, customHash(key, count), count + 1, mod);
            else
                System.out.println("Unable to store key " + key + " to the table");
        }
    }


    //function to perform Division with Double Hashing
    private static void runHF3(int[][] table, int key, int probe, int hash, int count, int mod) {
        if (table[mod % 50][0] == 0) {
            table[mod % 50][0] = key;
            table[mod % 50][1] = probe;
            count = 1;
        } else {
            //populate table using second hash function.
            if (table[doubleHash(key, count) % 50][0] == 0) {
                table[doubleHash(key, count) % 50][0] = key;
                table[doubleHash(key, count) % 50][1] = probe + 1;
                count++;
            } else if (probe < 50)
                runHF3(table, key, probe + 1, doubleHash(key, count), count + 1, mod);
            else
                System.out.println("Unable to store key " + key + " to the table");
        }
    }


    //function to perform Division with Quadratic Probing
    private static void runHF2(int[][] table, int key, int probe, int mod) {
        if (table[mod % 50][0] == 0) {
            table[mod % 50][0] = key;
            table[mod % 50][1] = probe;
        } else {
            runHF2(table, key, probe + 1, (mod + 1) ^ 2);
        }
    }

    //function to perform Division with linear Probing
    private static void runHF1(int[][] table, int key, int probe, int mod) {
        if (table[mod % 50][0] == 0) {
            table[mod % 50][0] = key;
            table[mod % 50][1] = probe;
        } else {
            runHF1(table, key, probe + 1, mod + 1);
        }
    }


    //function to print the table data
    public static void printTable(int option, int[][] table) {
        System.out.println("\nHash table resulted from HF" + option + ":\n");
        System.out.println("Index\t Key\t probes");
        System.out.println("-----------------------\n");
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] == 0)
                System.out.print("  " + i + " \t\t " + table[i][0]);
            else
                System.out.print("  " + i + " \t " + table[i][0]);
            for (int j = 1; j < table[0].length; j++) {
                System.out.println(" \t " + table[i][j]);
            }
        }
        System.out.println("-----------------------\n");
        System.out.println("Sum of probe values = " + sumProbes(table) + " probes");
    }

    //function to find the sum of probes
    private static int sumProbes(int[][] table) {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            for (int m = 1; m < table[0].length; m++)
                sum = sum + table[i][m];
        }
        return sum;
    }

    //function to find the double hash
    private static int doubleHash(int key, int count) {
        int mod = key % 50;
        int hash = mod + count * (30 - key % 25);
        return hash;
    }

    //function to find the custom hash(own collision)
    private static int customHash(int key, int count) {
        int mod = key % 50;
        int hash = (mod + count * (55 + (key % 50)));
        return hash;
    }

}
