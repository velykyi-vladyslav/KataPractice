package velykyi.vladyslav.leetcode.level1.linkedList.linkedListCycle2;

import velykyi.vladyslav.leetcode.level1.linkedList.ListNode;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/linked-list-cycle-ii">linked-list-cycle-II</a>
 *
 * <p> Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p> There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
 * Note that pos is not passed as a parameter.
 * <p> Do not modify the linked list.
 * <p> Example:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * <p> Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */
@SuppressWarnings("unused")
public class Solution {

    public static void main(String[] args) {
        System.out.println(detectCycleFinal(null));
    }

    /**
     * The first idea - but it can find not the 1st cycle - bad solution
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (head.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == head || fast == head) {
                return head;
            }
            head = head.next;
        }

        return null;
    }

    /**
     * Second idea was to add counter for slow and fast and check whether cycle that is present closer to slow.
     * Not passing the tests as well.
     */
    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        int slowCounter = 0;
        int fastCounter = 0;

        ListNode fastSecondCycle;

        while (fast != null && fast.next != null) {
            slowCounter++;
            fastCounter = fastCounter + 2;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fastSecondCycle = slow.next;
                while (fastCounter != slowCounter) {
                    if (slow == fastSecondCycle) {
                        head = slow;
                        break;
                    }
                    fastCounter--;
                    fastSecondCycle = fastSecondCycle.next;
                }
                return head;
            }
        }

        return null;
    }

    /**
     * <p> Intuition: Use a Floyd's Cycle-Finding algorithm to detect a cycle in a linked list and find the node
     * where the cycle starts.
     * <p> Approach:
     * <li> When the two pointers meet, we know that there is a cycle in the linked list.
     * <li> We then reset the slow pointer to the head of the linked list and move both pointers at the same pace,
     * one step at a time, until they meet again.
     * <li> The node where they meet is the starting point of the cycle.
     * <li> If there is no cycle in the linked list, the algorithm will return null.
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(1)
     */
    public static ListNode detectCycleFinal(ListNode head) {
        // Initialize two pointers, slow and fast, to the head of the linked list.
        ListNode slow = head;
        ListNode fast = head;

        // Move the slow pointer one step and the fast pointer two steps at a time through the linked list,
        // until they either meet or the fast pointer reaches the end of the list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If the pointers meet, there is a cycle in the linked list.
            if (slow == fast) {
                // Reset the slow pointer to the head of the linked list, and move both pointers one step at a time
                // until they meet again. The node where they meet is the starting point of the cycle.
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        // If the fast pointer reaches the end of the list without meeting the slow pointer,
        // there is no cycle in the linked list. Return null.
        return null;
    }
}
