package Assignment2;

import java.util.Scanner;

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #2 – Linked List Test Program
 IDE : 	IntelliJ
*/

public class ListTestVenkataKalyanKrishnaVarmaSagi {

    public static void main(String args[]) {

        //Initialize the LinkedList we are implemented.
        LinkedListVenkataKalyanKrishnaVarmaSagi linkedListVenkataKalyanKrishnaVarmaSagi = new LinkedListVenkataKalyanKrishnaVarmaSagi();

        //Setup data in the List to verify each method in next steps.
        linkedListVenkataKalyanKrishnaVarmaSagi.addFirst(50);
        linkedListVenkataKalyanKrishnaVarmaSagi.addFirst(40);
        linkedListVenkataKalyanKrishnaVarmaSagi.addFirst(30);
        linkedListVenkataKalyanKrishnaVarmaSagi.addFirst(20);
        linkedListVenkataKalyanKrishnaVarmaSagi.addFirst(10);

        System.out.println("----Linked List Test Program---- \n 0 - Exit Program \n 1 - Add First Node \n 2 - Add Last Node \n 3 - Add at Index" +
                "\n 4 - Remove First Node \n 5 - Remove Last Node \n 6 - Remove at Index \n 7 - Print List Size \n Select Option:");

        //Open Scanner.
        Scanner scanner = new Scanner(System.in);

        //Take Option and execute the appropriate function in the Linked List.
        int option = scanner.nextInt();

        if (option == 0) {
            System.out.println("Testing exit program");
            return;
        }
        if (option == 1) {
            System.out.println("Testing method addFirst");
            System.out.println("List content before adding first node to list " + linkedListVenkataKalyanKrishnaVarmaSagi);
            //call addFirst method
            linkedListVenkataKalyanKrishnaVarmaSagi.addFirst(11);
            System.out.println("List content after adding first node to list " + linkedListVenkataKalyanKrishnaVarmaSagi);
        }
        if (option == 2) {
            System.out.println("Testing method addLast");
            System.out.println("List content before adding last node to list " + linkedListVenkataKalyanKrishnaVarmaSagi);
            //call addLast method
            linkedListVenkataKalyanKrishnaVarmaSagi.addLast(55);
            System.out.println("List content after adding last node to list " + linkedListVenkataKalyanKrishnaVarmaSagi);
        }
        if (option == 3) {
            System.out.println("Testing method add at index");
            System.out.println("List content before adding element at a given index " + linkedListVenkataKalyanKrishnaVarmaSagi);
            //call add method
            linkedListVenkataKalyanKrishnaVarmaSagi.add(3, 99);
            System.out.println("List content after adding element at a given index " + linkedListVenkataKalyanKrishnaVarmaSagi);
        }
        if (option == 4) {
            System.out.println("Testing method remove First");
            System.out.println("List content before removing first node " + linkedListVenkataKalyanKrishnaVarmaSagi);
            //call removeFirst method
            linkedListVenkataKalyanKrishnaVarmaSagi.removeFirst();
            System.out.println("List content after removing first node " + linkedListVenkataKalyanKrishnaVarmaSagi);
        }
        if (option == 5) {
            System.out.println("Testing method removeLast");
            System.out.println("List content before removing last node " + linkedListVenkataKalyanKrishnaVarmaSagi);
            //call removeLast method
            linkedListVenkataKalyanKrishnaVarmaSagi.removeLast();
            System.out.println("List content after removing last node " + linkedListVenkataKalyanKrishnaVarmaSagi);
        }
        if (option == 6) {
            System.out.println("Testing method remove");
            System.out.println("List content before removing element at a given index" + linkedListVenkataKalyanKrishnaVarmaSagi);
            //call remove method
            linkedListVenkataKalyanKrishnaVarmaSagi.remove(3);
            System.out.println("List content after removing element at a given index" + linkedListVenkataKalyanKrishnaVarmaSagi);
        }
        if (option == 7) {
            System.out.println("Testing method size");
            //call size method
            System.out.println("List content before calculating the size" + linkedListVenkataKalyanKrishnaVarmaSagi);
            System.out.println("Size of the list " + linkedListVenkataKalyanKrishnaVarmaSagi.size());
        }
    }
}
