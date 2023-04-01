package velykyi.vladyslav.leetCode.level1.prefixSum.runningSumOf1dArray;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/running-sum-of-1d-array/">running-sum-of-1d-array</a>
 * <p>
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 * <p> Example:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * <p> Explanation:
 * Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */
@SuppressWarnings("unused")
public class Solution {

    public static void main(String[] args) {
        int[] ints = runningSumFinal(new int[]{1, 2, 3, 4});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * <p> Intuition: to save the previous sum somewhere.
     * <p> Approach: adding to the previous sum the current.
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(n)
     */
    public static int[] runningSumFinal(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

    /**
     * First solution
     */
    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] runningSum = new int[length];
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += nums[i];
            runningSum[i] = sum;
        }

        return runningSum;
    }
}
