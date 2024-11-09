package linkedList;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
public class RemoveNthNodeFromLast {

    /**
     * Definition for singly-linked list.
     */
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    //
    //
    //Time complexity : O(L).
    //
    //The algorithm makes one traversal of the list of L nodes. Therefore time complexity is O(L).
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode right = head;
        LinkedListNode left = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }
}
