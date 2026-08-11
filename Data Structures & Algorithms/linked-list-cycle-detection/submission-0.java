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
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        
        ListNode s = head;
        ListNode f = head;

        while (s != null && f != null){
            f = f.next;
            if (f != null){
                f = f.next;
            }
            s = s.next;
            if (s == f) return true;
        }

        return false;
    }
}
