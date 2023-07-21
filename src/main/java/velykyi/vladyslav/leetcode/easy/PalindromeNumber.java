package velykyi.vladyslav.leetcode.easy;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/palindrome-number">palindrome-number/a>
 */
public class PalindromeNumber {


    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }


    public static boolean isPalindrome(int x) {
        // 0 - palindrome
        if (x == 0) {
            return true;
        }
        // -1, 0001 - is not palindrome
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int reversedX = 0;
        while (x > reversedX) {
            int pop = x % 10;
            x /= 10;
            reversedX = (reversedX * 10) + pop;
        }

        // 1221 -> 12 == 12 || 121 -> 1 == 12 / 10
        return x == reversedX || x == (reversedX / 10);
    }
}
