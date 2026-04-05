import java.util.Scanner;

public class LargestTwice {

    // Task: Determine if the largest element is at least twice every other number
    public int dominantIndex(int[] nums, int n) {
        if (n == 0) return -1;
        if (n == 1) return 0; // A single element is trivially the largest

        int maxIndex = 0;
        int maxVal = -1;
        int secondMaxVal = -1;

        // Traverse the array to find the largest and second-largest values
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxVal) {
                // The old max becomes the new second max
                secondMaxVal = maxVal;
                maxVal = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMaxVal) {
                // Update second max if the current number is between secondMax and max
                secondMaxVal = nums[i];
            }
        }

        // The largest number only needs to be twice the SECOND largest number
        // If it is, it is mathematically guaranteed to be at least twice all smaller numbers.
        if (maxVal >= 2 * secondMaxVal) {
            return maxIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read length of the array
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            
            // Read array elements
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            
            // Create object and solve
            LargestTwice solver = new LargestTwice();
            System.out.println(solver.dominantIndex(nums, n));
        }
        
        sc.close();
    }
}
