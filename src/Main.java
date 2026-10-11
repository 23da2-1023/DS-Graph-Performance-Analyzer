/** Main menu (Day 2 version: only the Graph module is connected so far). */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
 
        while (true) {
            System.out.println("\n=============================================");
            System.out.println("   DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations\n2. Stack Operations\n3. Queue Operations\n4. Linked List Operations");
            System.out.println("5. Searching Operations\n6. Graph Operations\n7. Performance Comparison\n8. Display All Results\n9. Exit");
            int c = InputHelper.readInt("Enter your choice: ", 1, 9);
            if (c == 6) graph.menu();
            else if (c == 9) { System.out.println("Goodbye!"); return; }
            else System.out.println("  This module is not integrated yet.");
        }
    }
}
