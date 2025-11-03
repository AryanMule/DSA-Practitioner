
import java.util.*;

public class PairWithGivenDifference {

    // 🔹 1. Brute Force O(n²)
    public static boolean hasPairWithDifference(int[] arr, int diff) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == diff) {
                    System.out.println("Pair found: (" + arr[i] + ", " + arr[j] + ")");
                    return true;
                }
            }
        }
        return false;
    }

    // 🔹 2. Optimized Two Pointer Approach (O(n log n))
    public static boolean hasPairWithDifferenceOptimizedTwoPointer(int[] arr, int diff) {
        Arrays.sort(arr); // Must sort first for two-pointer logic
        int left = 0;
        int right = 1;

        while (left < arr.length && right < arr.length) {
            int currentDiff = arr[right] - arr[left];

            if (left != right && currentDiff == diff) {
                System.out.println("Pair found: (" + arr[left] + ", " + arr[right] + ")");
                return true;
            } else if (currentDiff < diff) {
                right++; // need a bigger difference
            } else {
                left++; // need a smaller difference
            }
        }
        return false;
    }

    // 🔹 3. Optimized HashSet Approach (O(n))
    public static boolean hasPairWithDifferenceOptimizedHashset(int[] arr, int diff) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            // check if complement exists
            if (set.contains(num + diff) || set.contains(num - diff)) {
                System.out.println("Pair found: (" + num + ", " + (set.contains(num + diff) ? (num + diff) : (num - diff)) + ")");
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // 🔹 Main method for testing all approaches
    public static void main(String[] args) {
        int[] arr1 = {5, 20, 3, 2, 50, 80};
        int diff1 = 78;

        System.out.println("➡ Brute Force: " + (hasPairWithDifference(arr1, diff1) ? "Yes" : "No"));
        System.out.println("➡ Two Pointer: " + (hasPairWithDifferenceOptimizedTwoPointer(arr1, diff1) ? "Yes" : "No"));
        System.out.println("➡ HashSet: " + (hasPairWithDifferenceOptimizedHashset(arr1, diff1) ? "Yes" : "No"));

        System.out.println();

        int[] arr2 = {90, 70, 20, 80, 50};
        int diff2 = 45;

        System.out.println("➡ Brute Force: " + (hasPairWithDifference(arr2, diff2) ? "Yes" : "No"));
        System.out.println("➡ Two Pointer: " + (hasPairWithDifferenceOptimizedTwoPointer(arr2, diff2) ? "Yes" : "No"));
        System.out.println("➡ HashSet: " + (hasPairWithDifferenceOptimizedHashset(arr2, diff2) ? "Yes" : "No"));
    }
}
