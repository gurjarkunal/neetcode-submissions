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
        // Using Stack
        Stack<ListNode> st = new Stack<>();

        ListNode curr  = head;
        while (curr != null){
            st.push(curr);
            curr = curr.next;
        }

        int k = st.size() / 2;
        curr = head;

        while (k > 0){
            ListNode topNode = st.peek();
            st.pop();

            ListNode temp = curr.next;
            curr.next = topNode;
            topNode.next = temp;

            curr = temp;
            k--;
        }

        curr.next = null;
    }
}
