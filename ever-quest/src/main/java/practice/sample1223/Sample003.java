package practice.sample1223;

public class Sample003 {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if (headA == null || headB == null) return null;

            int countA = 0, countB = 0;
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            while (nodeA != null) {
                countA++;
                nodeA = nodeA.next;
            }
            while (nodeB != null) {
                countB++;
                nodeB = nodeB.next;
            }

            int delta = Math.abs(countA - countB);
            ListNode longer = countA > countB ? headA : headB;
            ListNode shorter = countA > countB ? headB : headA;
            ListNode node1 = longer;
            for (int i = 0; i < delta; i++) {
                node1 = node1.next;
            }

            ListNode node2  = shorter;
            while (node2 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }
    }
}
