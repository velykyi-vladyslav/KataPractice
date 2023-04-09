package velykyi.vladyslav.leetCode.level1.linkedList.reverseLinkedList;

import velykyi.vladyslav.leetCode.level1.linkedList.ListNode;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/reverse-linked-list/">reverse-linked-list</a>
 *
 * <p> Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * <p> Example:
 * Input: head = [1,2]
 * Output: [2,1]
 */
@SuppressWarnings("unused")
public class Solution {

    /**
     * Bad solution - too many lines of code.
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedList = null;

        while (head.next!=null) {
            ListNode prevHead = reversedList;

            if (prevHead == null) {
                reversedList = new ListNode(head.next.val, new ListNode(head.val));
            } else {
                reversedList = new ListNode(head.next.val);
                reversedList.next = prevHead;
            }

            head = head.next;
        }

        return reversedList;
    }

    /**
     * <p> Intuition: head to the placeholder (prevHead), create ListNode with head = next from input, on this ListNode
     * next = prev
     * <p> Approach: to update the link part of one node at a time which is pointed by the head pointer.
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(n)
     */
    public static ListNode reverseListFinal(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
