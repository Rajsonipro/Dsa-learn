/**
 * LeetCode 11: Container With Most Water (Medium)
 * 
 * Problem Statement:
 * You are given an integer array height of length n. There are n vertical lines drawn such that 
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * 
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
 * In this case, the max area of water the container can contain is 49.
 * 
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * 
 * Example 3:
 * Input: height = [1,2,1]
 * Output: 2
 * 
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * Approach: Two Pointers (Optimal)
 * - Initialize left=0, right=n-1, maxArea=0
 * - Calculate area = min(height[left], height[right]) * (right - left)
 * - Update maxArea
 * - Move the pointer with smaller height inward (greedy, since moving larger won't increase min height)
 * - Continue until pointers meet
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Current area
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    
    // Test the solution
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        // Test case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height1)); // Expected: 49
        
        // Test case 2
        int[] height2 = {1, 1};
        System.out.println(solution.maxArea(height2)); // Expected: 1
        
        // Test case 3
        int[] height3 = {1, 2, 1};
        System.out.println(solution.maxArea(height3)); // Expected: 2
        
        // Test case 4
        int[] height4 = {1, 3, 2, 5, 25, 24, 5};
        System.out.println(solution.maxArea(height4)); // Expected: 24
    }
}

