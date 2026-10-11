/** Simple array-based queue (Day 2 version: enqueue and display). */
public class QueueOperations {
    private static final int CAPACITY = 10;
    private final int[] items = new int[CAPACITY];
    private int count = 0;
 
    public boolean isEmpty() { return count == 0; }
 
    public void enqueue(int value) {
        if (count == CAPACITY) { System.out.println("  [!] Queue is full."); return; }
        items[count++] = value;
        System.out.println("  Enqueued " + value);
    }
 
    public void display() {
        if (isEmpty()) { System.out.println("  Queue is empty."); return; }
        System.out.print("  Queue (front -> rear): ");
        for (int i = 0; i < count; i++) System.out.print(items[i] + (i < count - 1 ? ", " : ""));
        System.out.println();
    }
 
    public void menu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue\n2. Display\n3. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 3);
            switch (c) {
                case 1: enqueue(InputHelper.readInt("Value: ")); break;
                case 2: display(); break;
                default: return;
            }
        }
    }
}

