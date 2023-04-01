package velykyi.vladyslav.leetCode.level1.string.isSubsequence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/is-subsequence/">is-subsequence</a>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * <p>A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * <p> Example:Input: s = "abc", t = "ahbgdc", Output: true
 */
@SuppressWarnings("unused")
public class Solution {

    public static void main(String[] args) {
        System.out.println(isSubsequenceFinal("acb", "ahbgdcc"));
    }

    /**
     * Bad solution, because not subsequence but contains (order is important).
     */
    public static boolean isSubsequence(String s, String t) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        t.chars().forEach(charK -> occurrences.compute(charK, (letter, integer) ->
                occurrences.getOrDefault(letter, 0) + 1));

        return s.chars().boxed().allMatch(occurrences::containsKey);
    }

    /**
     * Bad solution, because of creating additional data structures.
     */
    public static boolean isSubsequence2(String s, String t) {
        LinkedList<Integer> subsequence = new LinkedList<>();
        s.chars().boxed().forEach(subsequence::add);

        List<Integer> inputChars = t.chars().boxed().toList();

        for (Integer el : inputChars) {
            if (el.equals(subsequence.getFirst())) {
                subsequence.removeFirst();
            }
        }

        return subsequence.size() == s.length();
    }

    /**
     * <p> Intuition: to ASCII, go through array and check if all are present - return true, false otherwise.
     * <p> Approach: count subsequence index and exit with true when the index is >= subsequence string length.
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(n)
     */
    public static boolean isSubsequenceFinal(String s, String t) {
        int subsequenceLength = s.length();
        if (subsequenceLength == 0) {
            return false;
        }

        int subsequenceIndex = 0;

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(subsequenceIndex) == t.charAt(i)) {
                subsequenceIndex++;
            }

            if (subsequenceIndex >= subsequenceLength) {
                return true;
            }
        }
        return false;
    }
}
