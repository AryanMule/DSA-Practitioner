
public class MinimumInRotatedSortedArray {

    public static int findMin(int[] arr) {
        int n = arr.length;
        int pivot = -1;
        // Step 1: Find pivot (point of rotation)
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                pivot = i;
                break;
            }
        }
        return arr[(pivot + 1) % n];
    }

    public static int findMinimum(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element > right element, min is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Else, min is in left half (including mid)
                right = mid;
            }
        }

        // left == right → minimum element
        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println("Min elem is: " + findMin(arr));
    }
}
