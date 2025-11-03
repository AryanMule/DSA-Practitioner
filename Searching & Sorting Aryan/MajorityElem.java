
import java.util.HashMap;

public class MajorityElem {

    // 🔹 1. Brute Force — O(n²)
    public static int findMajorityElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0; // reset count for every new element
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return arr[i]; // majority element found
            }
        }
        return -1; // no majority
    }

    // 🔹 2. Efficient using HashMap — O(n)
    public static int findMajorityElementEfficient(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > arr.length / 2) {
                return num; // majority element found
            }
        }
        return -1; // no majority
    }

    // 🔹 Main Method — Run All Approaches
    public static void main(String[] args) {
        int[] arr1 = {3, 3, 4, 2, 4, 4, 2, 4, 4}; // Majority = 4
        int[] arr2 = {1, 2, 3, 4};                // No majority

        System.out.println("Brute Force: " + findMajorityElement(arr1));
        System.out.println("Efficient HashMap: " + findMajorityElementEfficient(arr1));

        System.out.println("\n--- For array with no majority ---");
        System.out.println("Brute Force: " + findMajorityElement(arr2));
        System.out.println("Efficient HashMap: " + findMajorityElementEfficient(arr2));
    }
}
