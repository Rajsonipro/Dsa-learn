/**
 * LeetCode 22: Generate Parentheses (Medium)
 *
 * Problem Statement:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(()","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * 1 <= n <= 8
 */

import java.util.*;

public class LeetCode22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        
        // Add open parenthesis if possible
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        
        // Add close parenthesis if possible
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
    // Test the solution
    public static void main(String[] args) {
        LeetCode22_GenerateParentheses solution = new LeetCode22_GenerateParentheses();
        
        // Test case 1
        System.out.println(solution.generateParenthesis(3));
        // Expected: ["((()))","(()())","(())()","()(()","()()()"]
        
        // Test case 2
        System.out.println(solution.generateParenthesis(1));
        // Expected: ["()"]
    }
}

