package Assignment3;

import java.util.Scanner;

/*
Next, develop a simple test program called TestStackYourname, similar to that you developed in the previous assignment, to test each stack operation listed above and defined in your class Stack.
Use integer type stack for the test program. Organize the outputs of this test program similar to that of test linked-list, where you need to show the stack content before and after calling a stack operation.
Use proper labels. Please DO NOT hard-code test data. Make sure to allow the user to enter the stack content using interactive menu (embedded inside the sentinel loop):

-----MAIN MENU-----
0 - Exit Program
1 - Push
2 - Pop
3 – Peek (Top)
4 - Size
5 – Is Empty?
6 - Print Stack
Again, you cannot change method names, return type and parameter types.
To evaluate your Class’s methods, the instructor will use another Test Program and will use your methods.
*/

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #3 – Stack Test Program
 IDE : 	IntelliJ
*/

public class TestStackVenkataKalyanKrishnaVarmaSagi {

    public static void main(String args[]) {

        //Initialize the Stack we implemented.
        StackVenkataKalyanKrishnaVarmaSagi<Integer> stackVenkataKalyanKrishnaVarmaSagi = new StackVenkataKalyanKrishnaVarmaSagi();

        //Setup data in the Stack to verify each method in next steps.
        stackVenkataKalyanKrishnaVarmaSagi.push(1);
        stackVenkataKalyanKrishnaVarmaSagi.push(2);
        stackVenkataKalyanKrishnaVarmaSagi.push(3);
        stackVenkataKalyanKrishnaVarmaSagi.push(4);
        stackVenkataKalyanKrishnaVarmaSagi.push(5);

        System.out.println("-----Main Menu----- \n 0 - Exit Program \n 1 - Push \n 2 - Pop \n 3 - Peek(Top)" +
                "\n 4 - Size \n 5 - Is Empty? \n 6 - Print Stack \n Select Option:");

        Scanner scanner = new Scanner(System.in);

        //Take Option and execute the appropriate function in the Stack.
        int option = scanner.nextInt();
        if (option == 0) {
            System.out.println("Testing Exit program");
            return;
        }
        if (option == 1) {
            System.out.println("Testing method Push");
            System.out.println("Stack contents before calling push--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
            stackVenkataKalyanKrishnaVarmaSagi.push(6);
            System.out.println("Stack contents after calling push--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
        }
        if (option == 2) {
            System.out.println("Testing method Pop");
            System.out.println("Stack contents before calling pop--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
            System.out.println("Element that is popped--> " + stackVenkataKalyanKrishnaVarmaSagi.pop());
            System.out.println("Stack contents after calling pop--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
        }
        if (option == 3) {
            System.out.println("Testing method Peek(Top)");
            System.out.println("Stack contents before calling Peek--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
            System.out.println("Peek element in Stack--> " + stackVenkataKalyanKrishnaVarmaSagi.peek());
            System.out.println("Stack contents after calling Peek--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
        }
        if (option == 4) {
            System.out.println("Testing method Size");
            System.out.println("Stack contents before calling size--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
            System.out.println("Size of stack--> " + stackVenkataKalyanKrishnaVarmaSagi.size());
            System.out.println("Stack contents after calling size--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
        }
        if (option == 5) {
            System.out.println("Testing method IsEmpty");
            System.out.println("Stack contents before calling IsEmpty--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
            System.out.println("Is stack empty ? " + stackVenkataKalyanKrishnaVarmaSagi.isEmpty());
            System.out.println("Stack contents after calling IsEmpty--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
        }
        if (option == 6) {
            System.out.println("Testing toString to print Stack");
            System.out.println("Printing Stack contents--> " + stackVenkataKalyanKrishnaVarmaSagi.toString());
        }
    }
}
