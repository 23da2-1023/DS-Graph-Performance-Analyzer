import java.util.Arrays;

/** Fixed-size array with insert, delete, search and display. */
public class ArrayOperations {
    private static final int CAPACITY = 20;
    private final int[] data = new int[CAPACITY];
    private int size = 0;

    public int[] toArray() { return Arrays.copyOf(data, size); }
    public int getSize() { return size; }

    /** Insert at the end. O(1) */
    public void insert(int value) {
        if (size == CAPACITY) { System.out.println("  [!] Array is full (max " + CAPACITY + ")."); return; }
        data[size++] = value;
        System.out.println("  Inserted " + value + " at index " + (size - 1));
    }

    /** Insert at a given index (shifts elements right). O(n) */
    public void insertAt(int index, int value) {
        if (size == CAPACITY) { System.out.println("  [!] Array is full (max " + CAPACITY + ")."); return; }
        if (index < 0 || index > size) { System.out.println("  [!] Invalid index. Allowed: 0 to " + size); return; }
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = value;
        size++;
        System.out.println("  Inserted " + value + " at index " + index);
    }

    /** Delete first occurrence of a value (shifts elements left). O(n) */
    public void delete(int value) {
        if (size == 0) { System.out.println("  [!] Array is empty."); return; }
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                for (int j = i; j < size - 1; j++) data[j] = data[j + 1];
                size--;
                System.out.println("  Deleted " + value + " (was at index " + i + ")");
                return;
            }
        }
        System.out.println("  [!] Value " + value + " not found.");
    }

    /** Linear search. O(n) */
    public void search(int value) {
        if (size == 0) { System.out.println("  [!] Array is empty."); return; }
        int[] r = SearchOperations.linearSearch(toArray(), value);
        if (r[0] >= 0) System.out.println("  Found " + value + " at index " + r[0] + " (steps: " + r[1] + ")");
        else System.out.println("  " + value + " not found (steps: " + r[1] + ")");
    }

    public void display() {
        if (size == 0) { System.out.println("  Array is empty."); return; }
        System.out.println("  Array (" + size + "/" + CAPACITY + "): " + Arrays.toString(toArray()));
    }

    public void menu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert (end)\n2. Insert at index\n3. Delete\n4. Search\n5. Display\n6. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 6);
            switch (c) {
                case 1: insert(InputHelper.readInt("Value: ")); break;
                case 2: insertAt(InputHelper.readInt("Index: "), InputHelper.readInt("Value: ")); break;
                case 3: delete(InputHelper.readInt("Value to delete: ")); break;
                case 4: search(InputHelper.readInt("Value to search: ")); break;
                case 5: display(); break;
                default: return;
            }
        }
    }
}
