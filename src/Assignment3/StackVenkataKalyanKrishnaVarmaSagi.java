package Assignment3;/*
Develop a new stand-alone generic class, called StackYourname, to implement, among others, key stack operations [push(e), pop(), peek(), size(), isEmpty()]we discussed in the class.
Note that our LinkedList class does not use variable size, but you can use variable size in this class StackYourname.
Again, class Stack needs to be defined as generic stack with type <E> so that we can create stack objects that can hold data of different types, such as integer stack, string stack, char stack, double stack, etc.
Furthermore, define class Node as part of class Stack, similar to class LinkedList in the previous assignment.
StackYourname Class must have these methods
-	methodname(argument): return type
-	isEmpty(): Boolean	Returns true if this stack is empty
-	size(): int		Returns the number of elements in this stack
-	peek(): E		Returns the top element in this stack
-	pop(): E			Returns and removes the top element in this stack
-	push(E element): E	Adds a new element to the top of this stack
-	search(E element): int	Returns the position of the specified element in this stack
-	toString(): String		Returns the String with all elements in current stack
*/

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #3 – Stack
 IDE : 	IntelliJ
*/

// Stack with Generic
public class StackVenkataKalyanKrishnaVarmaSagi<E> {

    private int count = 0;
    private Node head = null;
    private Node tail = null;

    public class Node {
        E data;
        Node next;

        //Node constructor
        public Node(E element) {
            data = element;
            next = null;
        }

        //Node toString method to print Node element
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    //method to verify if stack is empty
    public boolean isEmpty() {
        return (size() == 0);
    }

    //method to return number of elements in stack
    public int size() {
        return count;
    }

    //method to return top element in stack
    public E peek() {
        if (!isEmpty()) {
            return tail.data;
        } else {
            System.out.println("Stack is empty");
        }
        return null;
    }


    //method to return and remove top element in stack
    public E pop() {
        if (size() == 0) {
            System.out.println("Stack is Empty now");
            return null;
        }
        if (size() == 1) {
            Node temp = head;
            head = null;
            tail = null;
            count = 0;
            return temp.data;
        }
        Node current = head;
        Node temp = tail;
        while (current.next.next != null)
            current = current.next;
        current.next = null;
        tail = current;
        count--;
        return temp.data;
    }

    //method to add new element to the top of stack
    public E push(E element) {
        Node newNode = new Node(element);
        //for the first element, tail and head are same.
        if (size() == 0) {
            head = newNode;
            tail = newNode;
            count++;
            return (E) head;
        }
        tail.next = newNode;
        tail = tail.next;
        count++;
        //return (E) tail;
        return element;
    }

    //method to return the position of particular item in stack
    public int search(E element) {
        if (size() != 0) {
            Node current = head;
            // First we need to find out the last but one node.
            for (int i = 0; i < size(); i++) {
                if (current.data == element) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    //method to return string with all elements in stack
    public String toString() {
        Node temp = head;
        String str = "[";
        if (size() > 0) {
            while (temp.next != null) {
                str = str + temp.data + ", ";
                temp = temp.next;
            }
            str = str + temp.data;
        }
        return str + "]";
    }
}
