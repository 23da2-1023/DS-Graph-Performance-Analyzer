/** Linear Search and Binary Search (Day 2 version: algorithms only). Each returns {index, steps}. */
public class SearchOperations {
 
    /** Linear search: O(n). */
    public static int[] linearSearch(int[] a, int target) {
        int steps = 0;
        for (int i = 0; i < a.length; i++) {
            steps++;
            if (a[i] == target) return new int[]{i, steps};
        }
        return new int[]{-1, steps};
    }
 
    /** Binary search (array MUST be sorted): O(log n). */
    public static int[] binarySearch(int[] a, int target) {
        int low = 0, high = a.length - 1, steps = 0;
        while (low <= high) {
            steps++;
            int mid = (low + high) >>> 1;
            if (a[mid] == target) return new int[]{mid, steps};
            if (a[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return new int[]{-1, steps};
    }
}
