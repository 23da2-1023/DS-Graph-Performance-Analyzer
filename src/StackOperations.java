/** Array-based stack (LIFO). */
public class StackOperations {
    private static final int CAPACITY = 10;
    private final int[] items = new int[CAPACITY];
    private int top = -1;
 
    public boolean isEmpty() { return top == -1; }
 
    public void push(int value) {
        if (top == CAPACITY - 1) { System.out.println("  [!] Stack overflow: stack is full."); return; }
        items[++top] = value;
        System.out.println("  Pushed " + value);
    }
 
    public void pop() {
        if (isEmpty()) { System.out.println("  [!] Stack underflow: cannot pop from an empty stack."); return; }
        System.out.println("  Popped " + items[top--]);
    }
 
    public void peek() {
        if (isEmpty()) { System.out.println("  [!] Stack is empty. Nothing to peek."); return; }
        System.out.println("  Top element: " + items[top]);
    }
 
    public void display() {
        if (isEmpty()) { System.out.println("  Stack is empty."); return; }
        System.out.print("  Stack (top -> bottom): ");
        for (int i = top; i >= 0; i--) System.out.print(items[i] + (i > 0 ? ", " : ""));
        System.out.println();
    }
 
    public void menu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Display\n5. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 5);
            switch (c) {
                case 1: push(InputHelper.readInt("Value: ")); break;
                case 2: pop(); break;
                case 3: peek(); break;
                case 4: display(); break;
                default: return;
            }
        }
    }
}
