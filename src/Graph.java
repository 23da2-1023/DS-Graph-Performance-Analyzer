import java.util.*;
 
/** Undirected graph using an adjacency list. Supports BFS and DFS. */
public class Graph {
    private final Map<Integer, TreeSet<Integer>> adj = new TreeMap<>();
    private int dfsSteps;
 
    public boolean isEmpty() { return adj.isEmpty(); }
    public boolean hasVertex(int v) { return adj.containsKey(v); }
 
    public void addVertex(int v) {
        if (adj.containsKey(v)) { System.out.println("  [!] Vertex " + v + " already exists."); return; }
        adj.put(v, new TreeSet<>());
        System.out.println("  Added vertex " + v);
    }
 
    public void addEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b)) { System.out.println("  [!] Both vertices must exist first."); return; }
        if (a == b) { System.out.println("  [!] Self-loops are not allowed."); return; }
        if (adj.get(a).contains(b)) { System.out.println("  [!] Edge " + a + "-" + b + " already exists."); return; }
        adj.get(a).add(b);
        adj.get(b).add(a);
        System.out.println("  Added edge " + a + " - " + b);
    }
 
    public void display() {
        if (isEmpty()) { System.out.println("  Graph is empty."); return; }
        System.out.println("  Adjacency List:");
        for (Map.Entry<Integer, TreeSet<Integer>> e : adj.entrySet())
            System.out.println("   " + e.getKey() + " -> " + e.getValue());
    }
 
    /** BFS using a queue. Steps = vertices visited + edges examined. O(V+E) */
    public int bfs(int start, boolean print) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        int steps = 0;
        visited.add(start);
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            order.add(v);
            steps++;
            for (int n : adj.get(v)) {
                steps++;
                if (visited.add(n)) q.add(n);
            }
        }
        if (print) System.out.println("  BFS from " + start + ": " + order + "  (steps: " + steps + ")");
        return steps;
    }
 
    /** DFS using recursion. Steps = vertices visited + edges examined. O(V+E) */
    public int dfs(int start, boolean print) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        dfsSteps = 0;
        dfsVisit(start, visited, order);
        if (print) System.out.println("  DFS from " + start + ": " + order + "  (steps: " + dfsSteps + ")");
        return dfsSteps;
    }
 
    private void dfsVisit(int v, Set<Integer> visited, List<Integer> order) {
        visited.add(v);
        order.add(v);
        dfsSteps++;
        for (int n : adj.get(v)) {
            dfsSteps++;
            if (!visited.contains(n)) dfsVisit(n, visited, order);
        }
    }
 
    /** Convenience: loads a small sample graph for demonstration. */
    public void loadSample() {
        adj.clear();
        for (int i = 0; i <= 5; i++) adj.put(i, new TreeSet<>());
        int[][] edges = {{0,1},{0,2},{1,3},{2,4},{3,5},{4,5}};
        for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
        System.out.println("  Sample graph loaded (vertices 0-5, 6 edges).");
    }
 
    public void menu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex\n2. Add Edge\n3. Display Graph\n4. BFS Traversal\n5. DFS Traversal\n6. Load Sample Graph\n7. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 7);
            switch (c) {
                case 1: addVertex(InputHelper.readInt("Vertex number: ")); break;
                case 2: addEdge(InputHelper.readInt("From vertex: "), InputHelper.readInt("To vertex: ")); break;
                case 3: display(); break;
                case 4:
                case 5:
                    if (isEmpty()) { System.out.println("  [!] Graph is empty."); break; }
                    int s = InputHelper.readInt("Start vertex: ");
                    if (!hasVertex(s)) { System.out.println("  [!] Vertex " + s + " does not exist."); break; }
                    int steps = (c == 4) ? bfs(s, true) : dfs(s, true);
                    PerformanceAnalyzer.log((c == 4 ? "BFS" : "DFS") + " from " + s + " | steps=" + steps);
                    break;
                case 6: loadSample(); break;
                default: return;
            }
        }
    }
}
