package practice.sample1223;

public class Sample001 {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode front = head;
            ListNode back = dummy;

            for (int i = 0; i < n; i++) {
                front = front.next;
            }

            while (front!= null) {
                front = front.next;
                back = back.next;
            }

            back.next = back.next.next;
            return dummy.next;
        }
    }
}
