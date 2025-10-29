import java.util.*;

public class ContainsDuplicate {

    // Approach 1: Brute Force (O(n²))
    // Compare each element with every other element
    public static boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // Approach 2: Sorting (O(n log n))
    // Sort array and check if any consecutive elements are equal
    public static boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    // Approach 3: HashSet (O(n)) — Most Efficient
    // Uses extra space but best for large inputs
    public static boolean containsDuplicateHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println("Brute Force: " + containsDuplicateBruteForce(nums1)); // true
        System.out.println("Sorting: " + containsDuplicateSorting(nums2)); // false
        System.out.println("HashSet: " + containsDuplicateHashSet(nums3)); // true
    }
}
