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
        List<ListNode> arr = new ArrayList<>();

        ListNode curr = head;
        ListNode prev = curr;

        while (curr!= null) {
            arr.add(curr);
            curr = curr.next;
            prev.next = null;
            prev = curr;
        }

        int l = 1;
        int r = arr.size()-1;
        int idx = 1;
        curr = head;

        while (l<=r) {
            if (idx % 2 == 0) {
                curr.next = arr.get(l);
                l++;
            } else {
                curr.next = arr.get(r);
                r--;
            }
            curr = curr.next;
            idx++;
        }

        return;
    }
}
