/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }



        ListNode ptr1 = head.next;
        ListNode ptr2 = slow.next;
        slow.next = null;
        ptr2 = reverse(ptr2);
        int idx = 1;
        ListNode curr = head;

        while (ptr1 != null && ptr2 != null) {
            if (idx % 2 == 0) {
                curr.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                curr.next = ptr2;
                ptr2 = ptr2.next;
            }
            curr = curr.next;
            idx++;
        }

        if (ptr1 == null) {
            curr.next = ptr2;
        }

        if (ptr2 == null) {
            curr.next = ptr1;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = curr;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
