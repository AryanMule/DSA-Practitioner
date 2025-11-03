
import java.util.Arrays;
import java.util.Collections;

public class PermuteTwoArrays {

    public static boolean isPossible(Integer[] a, Integer[] b, int k) {
        // Sort a in descending order
        Arrays.sort(a, Collections.reverseOrder());

        // Sort b in ascending order
        Arrays.sort(b);

        // Check the condition
        for (int i = 0; i < a.length; i++) {
            if (a[i] + b[i] < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a1 = {2, 1, 3};
        Integer[] b1 = {7, 8, 9};
        int k1 = 10;
        System.out.println(isPossible(a1, b1, k1) ? "Yes" : "No"); // ✅ Yes

        Integer[] a2 = {1, 2, 2, 1};
        Integer[] b2 = {3, 3, 3, 4};
        int k2 = 5;
        System.out.println(isPossible(a2, b2, k2) ? "Yes" : "No"); // ❌ No
    }
}
