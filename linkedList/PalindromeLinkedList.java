package linkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}

public class PalindromeLinkedList {

    private ListNode reverseList(ListNode head) {
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

    public boolean isPalindrome(ListNode head) {
        ListNode reverseHead = reverseList(head);
        ListNode cur = head;
        ListNode curRev = reverseHead;
        while (cur != null && curRev !=null) {
            System.out.println(cur.val);
            System.out.println(curRev.val);
            if (cur.val != curRev.val) {
                return false;
            }
            cur = cur.next;
            curRev = curRev.next;
        }
        return true;
    }
}
