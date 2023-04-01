package velykyi.vladyslav.leetCode.level1.string.isomorphicString;

import java.util.*;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/isomorphic-strings/">isomorphic-strings</a>
 * Given two strings s and t, determine if they are isomorphic.
 *
 * <p> Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p> All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * <p> Example:Input: s = "egg", t = "add", Output: true
 */
@SuppressWarnings("unused")
public class Solution {

    public static void main(String[] args) {

        System.out.println(isIsomorphicFinal("paper", "title"));
    }

    /**
     * Had no clear understanding of the task.
     * <p> Explanation that helped: <a href="https://youtu.be/EwV4Puk2coU">What are isomorphic Graphs?</a>
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        boolean isIsomorphic;
        int[] indexes = new int[2];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isIsomorphic = t.charAt(i) == t.charAt(j);
                    if (isIsomorphic) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * <p> Intuition: write the mapping from inputs like {e-> a, g -> d} (Map as data structure), do mapping and check
     * if the result string will equal mapped one.
     * <p> Approach: as in the intuition, but we should also check the values to be unique, as this leeds to incorrect
     * mapping.
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(n)
     *
     * Bad solution, because of creating additional data structures (Runtime = 9 ms).
     */
    public static boolean isIsomorphic2(String s, String t) {
        int length = s.length();
        if (length != t.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> uniqueReplacements = new HashSet<>();

        for (char replacement : t.toCharArray()) {
            uniqueReplacements.add(replacement);
        }

        for (int i = 0; i < length; i++) {
            char replacement = t.charAt(i);
            if (uniqueReplacements.remove(replacement)) {
                mapping.putIfAbsent(s.charAt(i), replacement);
            }
        }

        StringBuilder mappedString = new StringBuilder();

        for (char letterS : s.toCharArray()) {
            mappedString.append(mapping.get(letterS));
        }

        return mappedString.toString().equals(t);
    }

    /**
     * Best solution (Runtime = 2 ms).
     */
    public static boolean isIsomorphicFinal(String s, String t) {
        char[] asciiCharHolder = new char[256];
        boolean[] notUnique = new boolean[256];

        char[] sLetters = s.toCharArray();
        char[] tLetters = t.toCharArray();

        for (int i = 0; i < sLetters.length; i++) {
            char input = sLetters[i];
            char replacement = tLetters[i];

            if (asciiCharHolder[replacement] == 0 && !notUnique[input]) {
                asciiCharHolder[replacement] = input;
                notUnique[input] = true;
            }
            if (asciiCharHolder[replacement] != input)
                return false;
        }
        return true;
    }
}
