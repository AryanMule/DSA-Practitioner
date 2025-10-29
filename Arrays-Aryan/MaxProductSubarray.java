
public class MaxProductSubarray {

    // 1️⃣ Brute Force Approach (O(n²))
    // Check all possible subarrays, multiply elements, and track max product
    public static int maxProductBruteForce(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currProduct = 1;
            for (int j = i; j < n; j++) {
                currProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currProduct);
            }
        }
        return maxProduct;
    }

    // 2️⃣ Optimized Approach (O(n)) — Dynamic Kadane’s variant
    // Track both max and min product because a negative number can flip results
    public static int maxProductOptimized(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int currMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = currMax; // store current max before overwriting

            // if nums[i] is negative, swap max & min
            if (nums[i] < 0) {
                int swap = currMax;
                currMax = currMin;
                currMin = swap;
            }

            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);

            result = Math.max(result, currMax);
        }
        return result;
    }

    // DRIVER CODE
    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        int[] nums3 = {-2, 3, -4};

        System.out.println("Brute Force: " + maxProductBruteForce(nums1));   // 6
        System.out.println("Optimized: " + maxProductOptimized(nums1));      // 6

        System.out.println("Brute Force: " + maxProductBruteForce(nums2));   // 0
        System.out.println("Optimized: " + maxProductOptimized(nums2));      // 0

        System.out.println("Optimized: " + maxProductOptimized(nums3));      // 24  (subarray [-2,3,-4])
    }
}
