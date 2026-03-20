import java.util.*;

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements to sets
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        int count1 = 0;
        int count2 = 0;
        
        // Count elements of nums1 present in nums2
        for (int num : nums1) {
            if (set2.contains(num)) {
                count1++;
            }
        }
        
        // Count elements of nums2 present in nums1
        for (int num : nums2) {
            if (set1.contains(num)) {
                count2++;
            }
        }
        
        return new int[]{count1, count2};
    }

    public static void main(String[] args) {
        // Sample test case 1
        int[] nums1 = {12, 25, 37, 12, 25};
        int[] nums2 = {2, 4, 12, 25};
        int[] result = new Solution().findIntersectionValues(nums1, nums2);
        System.out.println("Test 1: [" + result[0] + ", " + result[1] + "]");  // Expected: [2, 2]

        // Sample test case 2
        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{2, 3, 4};
        result = new Solution().findIntersectionValues(nums1, nums2);
        System.out.println("Test 2: [" + result[0] + ", " + result[1] + "]");  // Expected: [2, 2]

        // Sample test case 3
        nums1 = new int[]{1};
        nums2 = new int[]{2};
        result = new Solution().findIntersectionValues(nums1, nums2);
        System.out.println("Test 3: [" + result[0] + ", " + result[1] + "]");  // Expected: [0, 0]
    }
}
