public class MinMaxOptimized{

    public static void main(String[] args){
        int[] arr = {3, 5, 4, 1, 9};
        int n= arr.length;
        int min, max, i;

        // Step 1: Initialize based on array length
        if(n%2 == 0){
            if(arr[0]>arr[1]){
                max = arr[0];
                min = arr[1];
            } else{
                max = arr[1];
                min = arr[0];
            }
            i = 2;// If even, start from index 2
        } else{
            min = max = arr[0];
            i = 1; // If odd, start from 1
        }
        // Step 2: Process pairs
        while(i < n-1){
            int localMin, localMax;
            // Compare the pair
            if(arr[i] > arr[i+1]){
                localMax = arr[i];
                localMin = arr[i+1];
            }else{
                localMax = arr[i+1];
                localMin = arr[i];
            }
            // Update global min and max
            if(localMax > max){
                max = localMax;
            }
            if(localMin < min){
                min = localMin;
            }

            i+= 2; // Move to next pair
        }
        System.out.println("Min: " + min + ", Max: " + max);
    }

}