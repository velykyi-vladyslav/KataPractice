package velykyi.vladyslav.leetcode.easy;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/longest-common-prefix/">longest-common-prefix/a>
 */
public class LongestCommonPrefix {



//    1. Initialize the prefix as the first string in the array.
//    2. Iterate over the array and update the prefix at each step,
//    keeping only the common prefix of the current prefix and the current string.
//    3. If at any point the prefix becomes an empty string, stop the iteration because there can be no common prefix.

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;

    }
}
