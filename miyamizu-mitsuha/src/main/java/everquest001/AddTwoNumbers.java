package everquest001;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 哨兵节点
            ListNode dummy = new ListNode(0);
            ListNode tmp = dummy;
            int t = 0;
            while (l1 != null || l2 != null) {
                int a = l1 != null ? l1.val : 0;
                int b = l2 != null ? l2.val : 0;
                t = a + b + t;
                // t值的处理
                tmp.next = new ListNode(t % 10);
                t /= 10;
                tmp = tmp.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (t > 0) tmp.next = new ListNode(t);
            return dummy.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
