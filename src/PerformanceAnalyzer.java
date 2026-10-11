import java.util.ArrayList;
import java.util.List;
 
/** Stores results from all modules (Day 2 version: results log only). */
public class PerformanceAnalyzer {
    private static final List<String> RESULTS = new ArrayList<>();
 
    public static void log(String entry) { RESULTS.add(entry); }
 
    public static void displayAllResults() {
        System.out.println("\n=============================================");
        System.out.println("              ALL RESULTS");
        System.out.println("=============================================");
        if (RESULTS.isEmpty()) System.out.println("  No results recorded yet. Run searches, traversals or comparisons first.");
        for (int i = 0; i < RESULTS.size(); i++) System.out.println("  " + (i + 1) + ". " + RESULTS.get(i));
    }
}


