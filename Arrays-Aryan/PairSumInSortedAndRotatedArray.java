
public class PairSumInSortedAndRotatedArray {

    public static boolean hasPairWithSumBrute(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("pair found: " + arr[i] + ", " + arr[j]);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairInSortedRotated(int[] arr, int target) {
        int n = arr.length;
        int pivot = -1;

        // Step 1: Find pivot (point of rotation)
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: Set left (smallest) and right (largest)
        int left = (pivot + 1) % n; // smallest element
        int right = pivot;          // largest element

        // Step 3: Two-pointer loop (circular)
        while (left != right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left = (left + 1) % n; // move forward
            } else {
                right = (n + right - 1) % n; // move backward circularly

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10};
        int target = 15;
        System.out.println("Pair exists: " + hasPairWithSumBrute(arr, target));
        System.out.println("Pair exists: " + pairInSortedRotated(arr, target));

    }
}
