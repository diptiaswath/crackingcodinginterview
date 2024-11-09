package linkedList;

import linkedList.ListNode;

//https://leetcode.com/problems/reverse-linked-list/solution/
// LATEST - USE EDUCATIVE.IO SOLUTION
public class ReverseLinkedList {


    // CHOOSE ITERATIVE Approach1: Iterative O(N)
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode next = null;
        LinkedListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }


    // Approach recursive O(n)
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
