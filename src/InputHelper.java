import java.util.NoSuchElementException;
import java.util.Scanner;

/** Safe console input helper (validates every number the user types). */
public class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = SC.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a whole number.");
            } catch (NoSuchElementException e) {
                System.out.println("\nInput closed. Exiting.");
                System.exit(0);
            }
        }
    }

    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.println("  [!] Please enter a number between " + min + " and " + max + ".");
        }
    }
}
