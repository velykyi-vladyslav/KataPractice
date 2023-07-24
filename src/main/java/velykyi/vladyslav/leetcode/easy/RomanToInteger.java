package velykyi.vladyslav.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/roman-to-integer">Roman to Integer/a>
 */
public class RomanToInteger {

    @SuppressWarnings("java:S3599")
    private static final Map<Character, Integer> DICTIONARY = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int result = DICTIONARY.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            int current = DICTIONARY.get(s.charAt(i));
            int next = DICTIONARY.get(s.charAt(i + 1));
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
