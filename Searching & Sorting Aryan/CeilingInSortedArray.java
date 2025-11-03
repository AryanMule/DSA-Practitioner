
public class CeilingInSortedArray {

    // 🔹 Linear Search Approach — O(n)
    // The "ceiling" of x is the smallest element >= x
    public static int ceilingSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) {
                return arr[i];
            }
        }
        return -1;
    }

    // 🔹 Binary Search Approach — O(log n)
    // Much faster on sorted arrays
    public static int ceilingSearchBinary(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        // Standard binary search structure
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If exact match found, that's the ceiling
            if (arr[mid] == x) {
                return arr[mid];
            } // If mid value is smaller than x, move right
            else if (arr[mid] < x) {
                left = mid + 1;
            } // If mid value is greater than x, move left
            else {
                right = mid - 1;
            }
        }

        // After loop ends, 'left' points to the smallest element greater than x
        if (left < arr.length) {
            return arr[left];
        }

        // If x is greater than all elements, ceiling doesn't exist
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;

        System.out.println("Ceiling of " + x + " is: " + ceilingSearchBinary(arr, x));
    }
}
