import java.util.Arrays;

/** Linear Search vs Binary Search (returns {index, steps}). */
public class SearchOperations {
    private final ArrayOperations arrayModule;

    public SearchOperations(ArrayOperations arrayModule) { this.arrayModule = arrayModule; }

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

    private void compare(int target) {
        int[] arr = arrayModule.toArray();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        long t1 = System.nanoTime();
        int[] lin = linearSearch(arr, target);
        long linTime = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        int[] bin = binarySearch(sorted, target);
        long binTime = System.nanoTime() - t2;

        System.out.println("  Original array : " + Arrays.toString(arr));
        System.out.println("  Sorted copy    : " + Arrays.toString(sorted));
        System.out.printf("  Linear Search  : index=%d, steps=%d, time=%d ns%n", lin[0], lin[1], linTime);
        System.out.printf("  Binary Search  : index=%d (in sorted copy), steps=%d, time=%d ns%n", bin[0], bin[1], binTime);
        PerformanceAnalyzer.log("Search " + target + " | Linear steps=" + lin[1] + " | Binary steps=" + bin[1]);
    }

    public void menu() {
        while (true) {
            System.out.println("\n-------------- SEARCHING OPERATIONS --------------");
            System.out.println("(Uses the data in the Array module)");
            System.out.println("1. Linear Search\n2. Binary Search (sorts a copy first)\n3. Compare both\n4. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 4);
            if (c == 4) return;
            if (arrayModule.getSize() == 0) { System.out.println("  [!] Array is empty. Add values in Array Operations first."); continue; }
            int target = InputHelper.readInt("Value to search: ");
            if (c == 1) {
                int[] r = linearSearch(arrayModule.toArray(), target);
                System.out.println(r[0] >= 0 ? "  Found at index " + r[0] + ", steps: " + r[1] : "  Not found, steps: " + r[1]);
            } else if (c == 2) {
                int[] sorted = arrayModule.toArray();
                Arrays.sort(sorted);
                int[] r = binarySearch(sorted, target);
                System.out.println("  Sorted: " + Arrays.toString(sorted));
                System.out.println(r[0] >= 0 ? "  Found at sorted index " + r[0] + ", steps: " + r[1] : "  Not found, steps: " + r[1]);
            } else compare(target);
        }
    }
}
