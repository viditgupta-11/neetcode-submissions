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
        if (head.next == null) {
            return null;
        }
        ListNode p1 = head;
        int sz = 0;
        while (p1 != null) {
            sz++;
            p1 = p1.next;
        }
        int rem = sz - n + 1;
        if (rem == 1) {
            return head.next;
        }
        p1 = head;
        for (int i = 1; i < rem - 1; i++) {
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}
