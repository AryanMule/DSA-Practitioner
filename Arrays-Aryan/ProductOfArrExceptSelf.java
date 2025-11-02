
public class ProductOfArrExceptSelf {

    public static int[] ProductOfArr(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //step1: prefixx product
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 2: Suffix products and combine
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = ProductOfArr(nums);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
