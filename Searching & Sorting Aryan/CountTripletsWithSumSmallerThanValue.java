
import java.util.Arrays;

public class CountTripletsWithSumSmallerThanValue {

    public static int countTriplets(int[] arr, int val) {

        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] < val) {
                        count++;
                    }
                }
            }
        }
        return count;

    }

    public static int countTripletsEfficient(int[] arr, int val) {
        Arrays.sort(arr); // Sorting helps use two-pointer logic
        int n = arr.length;
        int count = 0;

        // Fix one element (arr[i]) and use two pointers for the other two
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum < val) {
                    // ✅ If arr[i] + arr[left] + arr[right] < val,
                    // then all elements between left and right form valid triplets
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 7};
        int val = 12;

        System.out.println("Brute Force Count: " + countTriplets(arr, val));
        System.out.println("Efficient Count: " + countTripletsEfficient(arr, val));
    }
}
