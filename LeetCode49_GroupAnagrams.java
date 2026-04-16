/**
 * LeetCode 49: Group Anagrams (Medium)
 *
 * Problem Statement:
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

import java.util.*;

public class LeetCode49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map from sorted string (key) to list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort characters to create key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add to map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        // Return all values as list of lists
        return new ArrayList<>(map.values());
    }
    
    // Test the solution
    public static void main(String[] args) {
        LeetCode49_GroupAnagrams solution = new LeetCode49_GroupAnagrams();
        
        // Test case 1
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(solution.groupAnagrams(strs1));
        // Expected: [["bat"],["nat","tan"],["ate","eat","tea"]]
        
        // Test case 2
        String[] strs2 = {""};
        System.out.println(solution.groupAnagrams(strs2));
        // Expected: [[""]]
        
        // Test case 3
        String[] strs3 = {"a"};
        System.out.println(solution.groupAnagrams(strs3));
        // Expected: [["a"]]
    }
}

