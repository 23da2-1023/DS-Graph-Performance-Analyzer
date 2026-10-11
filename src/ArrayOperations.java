import java.util.Arrays;
 
/** Fixed-size array module (Day 1 version: insert and display). */
public class ArrayOperations {
    private static final int CAPACITY = 20;
    private final int[] data = new int[CAPACITY];
    private int size = 0;
 
    /** Insert at the end. O(1) */
    public void insert(int value) {
        if (size == CAPACITY) { System.out.println("  [!] Array is full (max " + CAPACITY + ")."); return; }
        data[size++] = value;
        System.out.println("  Inserted " + value + " at index " + (size - 1));
    }
 
    public void display() {
        if (size == 0) { System.out.println("  Array is empty."); return; }
        System.out.println("  Array (" + size + "/" + CAPACITY + "): " + Arrays.toString(Arrays.copyOf(data, size)));
    }
 
    public void menu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert (end)\n2. Display\n3. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 3);
            switch (c) {
                case 1: insert(InputHelper.readInt("Value: ")); break;
                case 2: display(); break;
                default: return;
            }
        }
    }
}
