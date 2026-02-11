/*LEETCODE:268 MISSING VALUES*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 3}; // Example: missing 2
        int result = sol.missingNumber(nums);
        System.out.println("Missing number: " + result);
    }
}
