
import java.util.*;

public class FindKthLargestElem {

    public static int findingBrute(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    public static int findingUsingMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("brute force: " + findingBrute(arr, k));
        System.out.println("using min heap: " + findingUsingMinHeap(arr, k));
    }
}
