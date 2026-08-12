/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// YT solution link: https://www.youtube.com/watch?v=OLgXN2Yg3xQ
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        // 1) Insert the new nodes in between the original linked List
        Node curr = head;

        while (curr != null) {
            Node currNext = curr.next; // B
            curr.next = new Node(curr.val); // A -> x -> B
            curr.next.next = currNext;
            curr = currNext; // curr = B
        }

        // 2) Deep copy of random pointers
        curr = head;

        while (curr != null && curr.next != null) {
            if (curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3) Separate the linked lists
        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;

        while (curr != null && newCurr != null) {
            curr.next = curr.next == null ? null : curr.next.next;
            newCurr.next = newCurr.next == null ? null : newCurr.next.next;
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}
