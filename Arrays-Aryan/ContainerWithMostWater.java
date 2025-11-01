
public class ContainerWithMostWater {

    public static int maxAreaBrute(int[] height) {
        int maxArea = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int heightofWater = Math.min(height[i], height[j]);
                int width = j - 1;
                int area = heightofWater * width;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static int maxAreaTwoPointer(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int heightofWater = Math.min(height[left], height[right]);
            int width = right - left;
            int area = heightofWater * width;
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static int maxAreaOptimized(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int heightofWater = (height[left] < height[right]) ? height[left] : height[right];
            int area = heightofWater * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }

            // Skip all positions from the left that are <= lowest
            // They cannot form a larger area with the current right pointer
            while (left < right && height[left] <= heightofWater) {
                left++;
            }
            // Skip all positions from the right that are <= lowest
            // They cannot form a larger area with the current left pointer
            while (right > left && height[right] <= heightofWater) {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("max area is " + maxAreaTwoPointer(height));

    }
}
