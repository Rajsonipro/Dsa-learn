class Solution{
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the next position of the non-val element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move the non-val element to the front
                k++;
            }
        }
        return k; // The new length of the array after removing val
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 2, 2, 3}; // Example: remove 3
        int val = 3;
        int newLength = sol.removeElement(nums, val);
        System.out.println("New length after removing " + val + ": " + newLength);
    }               
}
