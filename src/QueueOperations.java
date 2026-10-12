/** Circular array-based queue (FIFO). */
public class QueueOperations {
    private static final int CAPACITY = 10;
    private final int[] items = new int[CAPACITY];
    private int front = 0, count = 0;
 
    public boolean isEmpty() { return count == 0; }
 
    public void enqueue(int value) {
        if (count == CAPACITY) { System.out.println("  [!] Queue is full."); return; }
        items[(front + count) % CAPACITY] = value;
        count++;
        System.out.println("  Enqueued " + value);
    }
 
    public void dequeue() {
        if (isEmpty()) { System.out.println("  [!] Queue underflow: cannot dequeue from an empty queue."); return; }
        System.out.println("  Dequeued " + items[front]);
        front = (front + 1) % CAPACITY;
        count--;
    }
 
    public void peek() {
        if (isEmpty()) { System.out.println("  [!] Queue is empty. Nothing at the front."); return; }
        System.out.println("  Front element: " + items[front]);
    }
 
    public void display() {
        if (isEmpty()) { System.out.println("  Queue is empty."); return; }
        System.out.print("  Queue (front -> rear): ");
        for (int i = 0; i < count; i++) System.out.print(items[(front + i) % CAPACITY] + (i < count - 1 ? ", " : ""));
        System.out.println();
    }
 
    public void menu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek/Front\n4. Display\n5. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 5);
            switch (c) {
                case 1: enqueue(InputHelper.readInt("Value: ")); break;
                case 2: dequeue(); break;
                case 3: peek(); break;
                case 4: display(); break;
                default: return;
            }
        }
    }
}

 
