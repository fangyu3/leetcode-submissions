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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Traverse linkedlist to find length
        // Some math to identify which node to remove
        // Remove & reconnect the ptrs

        // Some math:
        // idx = length - n;

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        int targetIdx = length-n;
        int idx = 0;
        curr = head;
        ListNode prev = curr;

        while (curr != null) {
            if (idx == targetIdx) {
                if (idx == 0) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                curr.next = null;
                break;
            }

            idx++;
            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}
