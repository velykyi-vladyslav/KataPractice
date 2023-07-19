package velykyi.vladyslav.leetcode.level1.linkedList.middleOfTheLinkedList;


import velykyi.vladyslav.leetcode.level1.linkedList.ListNode;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/middle-of-the-linked-list">middle-of-the-linked-list</a>
 *
 * <p> Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * <p> Example:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * <p> Explanation: The middle node of the list is node 3.
 *
 * <p> Example:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * <p> Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
@SuppressWarnings("unused")
public class Solution {

    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode second = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(3, first))));

        System.out.println(middleNode(first));
        System.out.println(middleNode(second));
    }

    /**
     * Working solution - first implementation
     */
    public static ListNode middleNode(ListNode head) {
        ListNode resultNode = head;
        int elCounter = 0;

        while (head != null) {
            elCounter++;
            head = head.next;
        }

        int middlePosition = elCounter / 2;
        int position = 0;

        while (resultNode != null) {
            if (position++ == middlePosition){
                return resultNode;
            }
            resultNode = resultNode.next;
        }

        return null;
    }

    /**
     * <p> Intuition: Find count of nodes and find middle node: int middlePosition = elCounter / 2
     * <p> Approach: to use two pointers - a slow pointer and a fast pointer - to traverse the list.
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(1) because we use a constant amount of extra space to perform the search.
     */
    public static ListNode middleNodeFinal(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
