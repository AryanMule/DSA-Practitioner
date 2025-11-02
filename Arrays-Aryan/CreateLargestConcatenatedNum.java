
import java.util.Arrays;

public class CreateLargestConcatenatedNum {

    public static String largestNumber(int[] nums) {
        // Convert integers to strings for concatenation comparison
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]); //["3", "30", "34", "5", "9"] converted to strings
        }

        // Sort using custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b)); //puts the bigger combination first , The goal is to get the largest concatenated number, not smallest. 
        //This sorting compare which combination is lexicographically larger.

        // Edge case: if all numbers are zeros like [0, 0, 0]
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build final result
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr1)); // Output: 9534330

        int[] arr2 = {54, 546, 548, 60};
        System.out.println(largestNumber(arr2)); // Output: 6054854654
    }
}
