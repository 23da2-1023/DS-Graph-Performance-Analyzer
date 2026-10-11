public class LinkedListOperations {
    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }
 
    private Node head;
    private int size = 0;
 
    /** Insert at the end. O(n) */
    public void insertAtEnd(int value) {
        Node n = new Node(value);
        if (head == null) head = n;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = n;
        }
        size++;
        System.out.println("  Inserted " + value + " at the end.");
    }
 
    public void display() {
        if (head == null) { System.out.println("  List is empty."); return; }
        System.out.print("  List (" + size + " nodes): ");
        for (Node cur = head; cur != null; cur = cur.next) System.out.print(cur.value + " -> ");
        System.out.println("null");
    }
 
    public void menu() {
        while (true) {
            System.out.println("\n------------- LINKED LIST OPERATIONS -------------");
            System.out.println("1. Insert at end\n2. Display\n3. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 3);
            switch (c) {
                case 1: insertAtEnd(InputHelper.readInt("Value: ")); break;
                case 2: display(); break;
                default: return;
            }
        }
    }
}
