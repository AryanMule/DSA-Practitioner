
import java.util.Arrays;

public class ChocolateDistribution {

    public static int findMinDiff(int[] arr, int m) {
        if (m == 0 || arr.length == 0) {
            return 0;
        }
        if (arr.length < m) {
            return -1;
        }
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < arr.length; i++) { // SLIDING WINDOW OF SIZE M 
            int diff = arr[i + m - 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;

    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println(findMinDiff(arr, m)); // Output: 2

        m = 5;
        System.out.println(findMinDiff(arr, m)); // Output: 7
    }
}
