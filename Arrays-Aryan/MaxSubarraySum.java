
public class MaxSubarraySum {

    // 1️⃣ Brute Force Approach — O(n^3)
    public static int maxSubarrayBrute(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // 2️⃣ Prefix Sum Approach — O(n^2)
    public static int maxSubarrayPrefix(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // 3️⃣ Kadane’s Algorithm — O(n)
    public static int maxSubarrayKadane(int[] arr) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;  // reset if current sum is negative

            }
        }
        return maxSum;
    }

    // 🚀 Driver Method
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Input Array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("\n");

        System.out.println("1️⃣ Brute Force Result (O(n^3)) = " + maxSubarrayBrute(arr));
        System.out.println("2️⃣ Prefix Sum Result   (O(n^2)) = " + maxSubarrayPrefix(arr));
        System.out.println("3️⃣ Kadane’s Result     (O(n))   = " + maxSubarrayKadane(arr));
    }
}
