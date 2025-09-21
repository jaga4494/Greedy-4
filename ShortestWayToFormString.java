// https://leetcode.ca/2018-10-20-1055-Shortest-Way-to-Form-String/

import java.util.HashSet;
import java.util.Set;

/**
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.

 

Example 1:

Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences

Example 2:

Input: source = "abc", target = "acdbc"
Output: -1
Explanation: The target string cannot be constructed from the subsequences of source
 */
class Solution {
    public static int shortestWay(String source, String target) {
        if (target == null || target.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        for (char c : source.toCharArray()) {
            set.add(c);
        }

        int m = source.length();
        int n = target.length();
        
        int sp = 0;
        int tp = 0;
        int ans = 1;
        while (tp < n) {

            char sc = source.charAt(sp);
            char tc = target.charAt(tp);

            if(!set.contains(tc)) {
                return -1;
            }
            
            if (tc == sc) {
                tp++;
                sp++;
            } else {
                sp++;
            }

            if (tp == n) {
                return ans;
            }
            if (sp == m) {
                ans++;
                sp = 0;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestWay("abc", "abcbc"));
        System.out.println(shortestWay("abc", "acdbc"));
        System.out.println(shortestWay("xyz", "zyzxz"));
    }
}