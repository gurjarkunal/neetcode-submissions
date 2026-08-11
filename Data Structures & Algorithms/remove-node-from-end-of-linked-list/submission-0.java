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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
            
        if (head.next == null)
            return null;

        ListNode prev = null;
        ListNode curr = head;
        ListNode reversedFirst = reverseList(curr);
        curr = reversedFirst;
        ListNode forw = curr.next;

        if (n == 1){
            reversedFirst = reversedFirst.next;
            return reverseList(reversedFirst);
        }
        n -= 1;

        while (n != 0) {
            prev = curr;
            curr = forw;
            forw = forw.next;
            n--;
        }
        prev.next = forw;
        curr.next = null;

        return reverseList(reversedFirst);
    }
}
