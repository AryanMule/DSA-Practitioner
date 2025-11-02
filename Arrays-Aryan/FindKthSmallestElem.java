
import java.util.*;

public class FindKthSmallestElem {

    public static int findingBrute(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];

    }

    public static int findingUsingMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();

    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("brute force: " + findingBrute(arr, k));
        System.out.println("using min heap: " + findingUsingMaxHeap(arr, k));
    }
}
