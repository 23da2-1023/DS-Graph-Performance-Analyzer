/** Singly linked list with insert, delete, search and display. */
public class LinkedListOperations {
    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;
    private int size = 0;

    /** Insert at the beginning. O(1) */
    public void insertAtBeginning(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
        size++;
        System.out.println("  Inserted " + value + " at the beginning.");
    }

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

    /** Delete first node with the given value. O(n) */
    public void delete(int value) {
        if (head == null) { System.out.println("  [!] List is empty."); return; }
        if (head.value == value) { head = head.next; size--; System.out.println("  Deleted " + value); return; }
        Node cur = head;
        while (cur.next != null && cur.next.value != value) cur = cur.next;
        if (cur.next == null) { System.out.println("  [!] Value " + value + " not found."); return; }
        cur.next = cur.next.next;
        size--;
        System.out.println("  Deleted " + value);
    }

    /** Search. O(n) */
    public void search(int value) {
        if (head == null) { System.out.println("  [!] List is empty."); return; }
        Node cur = head;
        int pos = 0, steps = 0;
        while (cur != null) {
            steps++;
            if (cur.value == value) {
                System.out.println("  Found " + value + " at position " + pos + " (steps: " + steps + ")");
                return;
            }
            cur = cur.next;
            pos++;
        }
        System.out.println("  " + value + " not found (steps: " + steps + ")");
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
            System.out.println("1. Insert at beginning\n2. Insert at end\n3. Delete\n4. Search\n5. Display\n6. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 6);
            switch (c) {
                case 1: insertAtBeginning(InputHelper.readInt("Value: ")); break;
                case 2: insertAtEnd(InputHelper.readInt("Value: ")); break;
                case 3: delete(InputHelper.readInt("Value to delete: ")); break;
                case 4: search(InputHelper.readInt("Value to search: ")); break;
                case 5: display(); break;
                default: return;
            }
        }
    }
}
