/** Data Structure & Graph Performance Analyzer - main menu and integration. */
public class Main {
    public static void main(String[] args) {
        ArrayOperations array = new ArrayOperations();
        StackOperations stack = new StackOperations();
        QueueOperations queue = new QueueOperations();
        LinkedListOperations list = new LinkedListOperations();
        SearchOperations search = new SearchOperations(array);
        Graph graph = new Graph();
        PerformanceAnalyzer perf = new PerformanceAnalyzer(graph);

        while (true) {
            System.out.println("\n=============================================");
            System.out.println("   DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations\n2. Stack Operations\n3. Queue Operations\n4. Linked List Operations");
            System.out.println("5. Searching Operations\n6. Graph Operations\n7. Performance Comparison\n8. Display All Results\n9. Exit");
            int c = InputHelper.readInt("Enter your choice: ", 1, 9);
            switch (c) {
                case 1: array.menu(); break;
                case 2: stack.menu(); break;
                case 3: queue.menu(); break;
                case 4: list.menu(); break;
                case 5: search.menu(); break;
                case 6: graph.menu(); break;
                case 7: perf.run(); break;
                case 8: PerformanceAnalyzer.displayAllResults(); break;
                default: System.out.println("Goodbye!"); return;
            }
        }
    }
}
