package velykyi.vladyslav.leetcode.level1.prefixSum.findPivotIndex;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/find-pivot-index">find-pivot-index</a>
 * <p>
 * Given an array of integers nums, calculate the pivot index of this array.
 * <p>The pivot index is the index where the sum of all the numbers strictly to the left of the index
 * is equal to the sum of all the numbers strictly to the index's right.
 * <p>If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 * This also applies to the right edge of the array.
 * <p>Return the leftmost pivot index. If no such index exists, return -1.
 * <p> Example:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * <p> Explanation:
 * The pivot index is 3.
 * <p>Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * <p>Right sum = nums[4] + nums[5] = 5 + 6 = 11
 */
@SuppressWarnings("unused")
public class Solution {
    public static void main(String[] args) {
        System.out.println(pivotIndexFinal(new int[]{1, 7, 3, 6, 5, 6}));
    }

    /**
     * <p> Intuition: to go through array and find left sum and right sum from index, if they are equal - return index.
     * <p> Approach: calculate the total sum, and the left sum multiplied by 2 should bb equal to the total sum.
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(n)
     */
    public static int pivotIndexFinal(int[] nums) {
        int pivotIndex = -1;
        int leftSum = 0, totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == totalSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return pivotIndex;
    }

    /**
     * First solution
     */
    public static int pivotIndex(int[] nums) {
        int pivotIndex = -1;
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (leftSum == calculateSumFromIndex(nums, i)) {
                return i;
            }
        }

        return pivotIndex;
    }

    private static int calculateSumFromIndex(int[] nums, int index) {
        int sum = 0;

        while (index < nums.length) {
            sum += nums[index];
            index++;
        }

        return sum;
    }
}
