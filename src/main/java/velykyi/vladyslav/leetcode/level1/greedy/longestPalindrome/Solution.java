package velykyi.vladyslav.leetcode.level1.greedy.longestPalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/longest-palindrome/">longest-palindrome</a>
 * <p> Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 * <p> Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.
 *
 * <p> Example:
 * Input: s = "abccccdd"
 * Output: 7
 * <p> Explanation:
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Solution {

    public static void main(String[] args) {
        String string = "abccccdd";
        System.out.println(longestPalindrome(string));
    }

    /**
     * <p> Intuition: Needs to find all possible pairs and check fo +1 (letter in the center).
     * <p> Approach: Formula [ sum(even) + sum(odd - 1) ] + 1(extra character in the center)
     * <p> Time complexity: O(n), where n is the length of the string s.
     * <p> Space complexity: O(n), where n is the number of unique characters in the string.
     * This is because we are using an unordered map to store the count of each character.
     */
    public static int longestPalindrome(String s) {
        Map<Character, Integer> pairsHolder = new HashMap<>();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            pairsHolder.compute(s.charAt(i), (key, val) -> val == null ? 1 : val + 1);
        }

        int evenSum = 0;
        int oddSum = 0;
        for (int value : pairsHolder.values()) {
            if ((value & 1) == 0) {
                evenSum += value;
            } else {
                oddSum += value - 1;
            }
        }

        int evenPalindrome = evenSum + oddSum;

        return evenPalindrome < length ? evenPalindrome + 1 : evenPalindrome;
    }
}
