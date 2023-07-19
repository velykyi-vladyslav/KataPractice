package velykyi.vladyslav.leetcode.level1.linkedList.mergeTwoSortedLists;


import velykyi.vladyslav.leetcode.level1.linkedList.ListNode;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/merge-two-sorted-lists">merge-two-sorted-lists</a>
 *
 * <p>You are given the heads of two sorted linked lists list1 and list2. Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * <p> Example:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
@SuppressWarnings("unused")
public class Solution {

    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(mergeTwoLists2(first, second));
    }


    /**
     * Doesn't work.
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        ListNode sortedListNode;

        do {
            int value1 = list1.val;
            int value2 = list2.val;

            if (value1 <= value2) {

                sortedListNode = new ListNode(value1);
                list1 = list1.next;
            } else {


                sortedListNode = new ListNode(value1);
                list2 = list2.next;
            }
            sortedListNode = sortedListNode.next;

        } while (list1 != null && list2 != null);



        return sortedListNode;
    }

    /**
     * <p> Intuition: compare firs elements and assign the higher to the Head.
     * Create new List in which new Head will take place. And compare Next in both - delete used.
     * <p> Approach: use recursion: set the lowest Node.value and give Node.next and other list to the same method.
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(n)
     */
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode sortedListNode;

        if (list1.val >= list2.val) {
            sortedListNode = new ListNode(list2.val, mergeTwoLists2(list2.next, list1));
        } else {
            sortedListNode = new ListNode(list1.val, mergeTwoLists2(list1.next, list2));
        }

        return sortedListNode;
    }
}
