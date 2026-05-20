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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        while (list1 != null && list2 != null) {
            ListNode node = new ListNode();
            if (list1.val <= list2.val) {
                node.val = list1.val;
                list1 = list1.next;
            } else {
                node.val = list2.val;
                list2 = list2.next;
            }
            cur.next = node;
            cur = node;
        }
        while (list1 != null) {
            ListNode node = new ListNode(list1.val);
            cur.next = node;
            cur = node;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode node = new ListNode(list2.val);
            cur.next = node;
            cur = node;
            list2 = list2.next;
        }
        return ans.next;
    }
}