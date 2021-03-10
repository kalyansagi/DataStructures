package Assignment2;
/*
Develop Java program for each of the following problems. Please name the programs as indicated and add proper program headers and output labels as shown below.
Use only concepts and programming constructs/syntax we discussed in class.

Programming (30 points)
Write your Java Class named LinkedListYourName as follows.
Choose one of the given files (LinkedListGGGG.java or LinkedListOOOO.java)
-	LinkedListGGGG.java is a LinkedList Class with Generic
-	LinkedListOOOO.java is a LinkedList Class with Object element type
Change the filename and Class name with yours LinkedListYourName
Implement all class methods.
-	add, addFirst, addLast, getFirst, getLast, remove, removeFirst, removeLast
You cannot change the name of methods, parameter type, return type.
Remove all written comments from the code, then write your comments.
Using code from outside sources receives NO credit. You must write and document your own code to meet the assignment requirements. Some methods are not in the slides.

Second, you must create your own test program named ListTestYourName
Your test program will runs with sentinal loop with user input.
The main menu will be similar as follows.

Test each method at least one execution for each, then show the status before & after execution with proper label.
Except for options 0 and 7 above, when calling a method on the list make sure the method prints the list content before and after executing the called method, For example, the output of testing method removeLast() would be displayed like this
(assuming the list has 10, 20, 30, 40, 50):


User choose remove option but there is no element in the List, you need to show the message like this


Again, you cannot change method names, return type and parameter types.
To evaluate your Class’s methods, the instructor will use another Test Program.

 */

/*
 Class: CS 5040
 Term:  Spring 2021
 Name:  Venkata Kalyan Krishna Varma Sagi
 Program Number: Assignment #2 – Linked List
 IDE : 	IntelliJ
*/


// LinkedList with Generic
public class LinkedListVenkataKalyanKrishnaVarmaSagi<E> {
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

    public void add(int index, E element) {
        Node temp1 = head;
        while (--index > 0) {
            temp1 = temp1.next;
        }
        Node temp2 = temp1.next;
        Node newNode = new Node(element);
        temp1.next = newNode;
        newNode.next = temp2;
    }

    public void addFirst(E element) {
        //for the first element, tail and head are same.
        if (size() == 0) {
            head = new Node(element);
            tail = new Node(element);
            return;
        }
        Node temp = new Node(element);
        temp.next = head;
        head = temp;
        if (temp.next == null)
            tail = temp;
    }

    public void addLast(E element) {
        //for the first element, tail and head are same.
        if (size() == 0) {
            head = new Node(element);
            tail = new Node(element);
            return;
        }
        Node newNode = new Node(element);
        //read head value in temp
        Node temp = head;
        //Now traverse through the linked list and move one position next for every element until we reach end
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public E getFirst() {
        //head is the first element
        return head.data;
    }

    public E getLast() {
        //tail is the last element
        return tail.data;
    }

    public void remove(int index) {
        if (size() == 0) {
            System.out.println("List is Empty now");
            return;
        }
        Node temp = head;
        while (--index > 0) {
            temp = temp.next;
        }
        Node target = temp.next;
        temp.next = target.next;
        if (temp.next == null) {
            tail = temp;
        }
    }

    public E removeFirst() {
        if (size() == 0) {
            System.out.println("List is Empty now");
            return null;
        }
        // Move the head pointer to the next node
        Node temp = head;
        head = head.next;
        return head.data;
    }

    public E removeLast() {
        if (size() == 0) {
            System.out.println("List is Empty now");
            return null;
        }
        Node temp = head;
        // First we need to find out the last but one node.
        while (temp.next.next != null)
            temp = temp.next;
        // now set the next of second last to null.
        temp.next = null;
        return head.data;
    }

    public int size() {
        int count = 0;
        Node temp = head;
    /*
        starting from head iterate every next element until you reach the end
        and save the iterations in count
     */
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public String toString() {
        Node temp = head;
        String str = "[";
        while (temp.next != null) {
            str = str + temp.data + ", ";
            temp = temp.next;
        }
        str = str + temp.data;

        return str + "]";
    }

}
