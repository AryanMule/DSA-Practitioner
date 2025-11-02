
import java.util.*;

public class LongestSubarrayDivisibleByK {

    public static int longestBrute(int[] arr, int k) {
        int maxlength = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % k == 0) {
                    maxlength = Math.max(maxlength, j - i + 1);
                }
            }
        }
        return maxlength;
    }

    public static int longestOptimizedUsingPrefixsumAndHashmap(int[] arr, int k) {
        Map<Integer, Integer> prefIdx = new HashMap<>();
        int sum = 0, res = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = ((sum + arr[i]) % k + k) % k; // prefix sum mod k, safe for negatives

            if (sum == 0) {
                res = i + 1; // subarray from start is divisible
            } else if (prefIdx.containsKey(sum)) {
                res = Math.max(res, i - prefIdx.get(sum)); // repeat remainder → valid subarray
            } else {
                prefIdx.put(sum, i); // store first occurrence

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;
        System.out.println("length " + longestOptimizedUsingPrefixsumAndHashmap(arr, k));
    }
}
