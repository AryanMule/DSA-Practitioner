
import java.util.HashSet;

public class RepeatingAndMissingNumber {

    public static int[] function1(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        int repeating = -1, missing = -1;
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                repeating = i;
            }
            if (freq[i] == 0) {
                missing = i;
            }
        }
        return new int[]{repeating, missing};
    }

    public static int[] function2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int repeating = -1, missing = -1;
        for (int num : nums) {
            if (set.contains(num)) {
                repeating = num;
            } else {
                set.add(num);
            }
        }
        for (int i = 1; i <= n; i++) { // if 1 to n is not present in set then its missing
            if (!set.contains(i)) {
                missing = i;
            }
        }
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 5, 4};
        int[] result = function1(nums);
        System.out.println("repeating number: " + result[0]);
        System.out.println("missing number: " + result[1]);
    }
}
