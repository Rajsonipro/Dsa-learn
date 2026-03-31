/**
 * LeetCode 3: Longest Substring Without Repeating Characters (Medium)
 * 
 * Problem Statement:
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * Approach: Sliding Window with HashSet
 * - Use two pointers (left and right) to represent the current window.
 * - Use a HashSet to store characters in the current window.
 * - Expand the window by moving right pointer.
 * - If a duplicate is found, shrink the window from left until no duplicate.
 * - Track the maximum length of valid window.
 * 
 * Time Complexity: O(n) - each character visited at most twice.
 * Space Complexity: O(min(m, n)) - size of charset or window.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Edge case: empty string
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // left: start of current window
        // maxLen: maximum length found so far
        int left = 0;
        int maxLen = 0;
        // Set to store characters in current window
        Set<Character> charSet = new HashSet<>();
        
        // Iterate over string with right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // Shrink window from left if duplicate found
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            // Add current character to set
            charSet.add(currentChar);
            
            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
    
    // Test the solution
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        
        // Test cases
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));   // Expected: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));  // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring(""));        // Expected: 0
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));    // Expected: 3
    }
}

