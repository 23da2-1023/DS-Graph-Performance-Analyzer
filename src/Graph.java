import java.util.*;
 
/** Undirected graph using an adjacency list (Day 1 version: vertices, edges, display). */
public class Graph {
    private final Map<Integer, TreeSet<Integer>> adj = new TreeMap<>();
 
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
 
    public void menu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex\n2. Add Edge\n3. Display Graph\n4. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 4);
            switch (c) {
                case 1: addVertex(InputHelper.readInt("Vertex number: ")); break;
                case 2: addEdge(InputHelper.readInt("From vertex: "), InputHelper.readInt("To vertex: ")); break;
                case 3: display(); break;
                default: return;
            }
        }
    }
}

