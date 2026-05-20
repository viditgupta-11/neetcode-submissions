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
    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode node = p1.next;
        p1.next = null;
        p2 = reverse(node);
        p1 = head;
        int i = 1;
        while (p1 != null || p2 != null) {
            if (i % 2 == 1) {
                ListNode tmp = p1.next;
                p1.next = p2;
                p1 = tmp;
            } else {
                ListNode tmp = p2.next;
                p2.next = p1;
                p2 = tmp;
            }
            i++;
        }
    }
}
