import java.util.ArrayList;
import java.util.List;
 
/** Compares algorithms by steps and execution time; stores results. */
public class PerformanceAnalyzer {
    private static final List<String> RESULTS = new ArrayList<>();
    private final Graph graph;
 
    public PerformanceAnalyzer(Graph graph) { this.graph = graph; }
 
    public static void log(String entry) { RESULTS.add(entry); }
 
    public static void displayAllResults() {
        System.out.println("\n=============================================");
        System.out.println("              ALL RESULTS");
        System.out.println("=============================================");
        if (RESULTS.isEmpty()) System.out.println("  No results recorded yet. Run searches, traversals or comparisons first.");
        for (int i = 0; i < RESULTS.size(); i++) System.out.println("  " + (i + 1) + ". " + RESULTS.get(i));
    }
 
    public void run() {
        int n = InputHelper.readInt("Array size for search test (1 - 1000000): ", 1, 1000000);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = (i + 1) * 2;      // sorted: 2,4,6,...
        int target = a[n - 1];                                  // worst case: last element
 
        long t1 = System.nanoTime();
        int[] lin = SearchOperations.linearSearch(a, target);
        long linTime = System.nanoTime() - t1;
        long t2 = System.nanoTime();
        int[] bin = SearchOperations.binarySearch(a, target);
        long binTime = System.nanoTime() - t2;
 
        int bfsSteps = -1, dfsSteps = -1;
        long bfsTime = 0, dfsTime = 0;
        if (graph.isEmpty()) {
            System.out.println("  [!] Graph is empty - graph rows skipped. Add vertices/edges or load the sample graph.");
        } else {
            int start = InputHelper.readInt("Graph start vertex: ");
            if (graph.hasVertex(start)) {
                long b1 = System.nanoTime(); bfsSteps = graph.bfs(start, false); bfsTime = System.nanoTime() - b1;
                long d1 = System.nanoTime(); dfsSteps = graph.dfs(start, false); dfsTime = System.nanoTime() - d1;
            } else System.out.println("  [!] Vertex does not exist - graph rows skipped.");
        }
 
        System.out.println("\n=============================================");
        System.out.println("            PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.printf("%-16s %-16s %-10s %-12s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println("---------------------------------------------------------");
        row("Search (n=" + n + ")", "Linear Search", lin[1], linTime);
        row("Search (n=" + n + ")", "Binary Search", bin[1], binTime);
        if (bfsSteps >= 0) {
            row("Graph Traversal", "BFS", bfsSteps, bfsTime);
            row("Graph Traversal", "DFS", dfsSteps, dfsTime);
        }
        System.out.println("=============================================");
        System.out.println("Why? Linear Search is O(n); Binary Search is O(log n) because it halves the range each step.");
        System.out.println("BFS and DFS are both O(V+E), so their step counts are similar; only the visiting order differs.");
        System.out.println("(Time in ns can vary between runs; step counts are more reliable.)");
    }
 
    private void row(String op, String algo, int steps, long time) {
        System.out.printf("%-16s %-16s %-10d %-12d%n", op, algo, steps, time);
        log(op + " | " + algo + " | steps=" + steps + " | time=" + time + " ns");
    }
}



