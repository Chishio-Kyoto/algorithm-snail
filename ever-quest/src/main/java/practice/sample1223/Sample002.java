package practice.sample1223;

public class Sample002 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.append(node,2);
        node.append(node,0);
        node.append(node,-4);

        while (node.next == null) {
            node = node.next;
        }

        node.next = node;

        System.out.println(node);
    }

    static class Solution {
        public ListNode detectCycle(ListNode head) {

            // 判断是否为环并获得环中的一个点：利用快慢指针
            ListNode node = getNodeInLoop(head);

            if (node == null) return null;

            // 计算环的长度
            int count = 1;
            for (ListNode n = node; n.next != node; n = n.next) {
                count++;
            }

            // 计算环的入口处
            ListNode front = head;
            ListNode back = head;

            for (int i = 0; i < count; i++) {
                front = front.next;
            }

            while (front != back) {
                front = front.next;
                back = back.next;
            }

            return back;
        }

        public ListNode getNodeInLoop(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode slow = dummy;
            ListNode fast = slow;

            while (slow != null || fast != null) {
                if (slow == fast) {
                    return slow;
                }
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
            }
            return null;
        }
    }
}
