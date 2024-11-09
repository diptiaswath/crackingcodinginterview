// https://leetcode.com/explore/interview/card/facebook/6/linked-list/3021/
class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // First find middle of linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half of the list
        ListNode prev = null, next = null;
        ListNode cur = slow;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // MOST CONFUSING. PAY SPECIAL ATTENTION: Merge two sorted lists, first = head, second = prev
        ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            next = first.next;
            first.next = second;
            first = next;

            next = second.next;
            second.next = first;
            second = next;
        }

    }
}