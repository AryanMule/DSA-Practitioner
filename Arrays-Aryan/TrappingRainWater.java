public class TrappingRainWater {

    // --------------------------
    // 1️⃣ Brute Force (O(n²))
    // --------------------------
    public static int trapBruteForce(int[] height) {
        int n = height.length;
        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;

            // find highest bar on left of i
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // find highest bar on right of i
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // trapped water at i
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }
        return totalWater;
    }

    // ---------------------------------
    // 2️⃣ Prefix Arrays (O(n) Time, O(n) Space)
    // ---------------------------------
    public static int trapUsingPrefixArrays(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Left max array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Right max array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // Calculate trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            totalWater += waterLevel - height[i];
        }
        return totalWater;
    }

    // ---------------------------------
    // 3️⃣ Two-Pointer Optimal (O(n) Time, O(1) Space)
    // ---------------------------------
    public static int trapTwoPointer(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    // --------------------------
    // DRIVER CODE
    // --------------------------
    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};

        System.out.println("Brute Force: " + trapBruteForce(height1));         // 6
        System.out.println("Prefix Arrays: " + trapUsingPrefixArrays(height1)); // 6
        System.out.println("Two Pointer: " + trapTwoPointer(height1));          // 6

        System.out.println("Two Pointer: " + trapTwoPointer(height2));          // 9
    }
}
