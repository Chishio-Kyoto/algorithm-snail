package sample.linkedList;

public class Sample003 {
    public static void main(String[] args) {
        Node initNode = new Node(1);
        for (int i = 2; i < 7; i++) {
            ListNode.append(initNode, i);
        }

        // 获取循环节点入口节点，初始化链表需要
        Node tempNode1 = initNode;
        for (int i = 0; i < 2; i++) {
            tempNode1 = tempNode1.next;
        }

        // 获取尾节点，设置尾节点指向环入口处
        Node tempNode2 = initNode;
        while(tempNode2.next != null) {
            tempNode2 = tempNode2.next;
        }
        tempNode2.next = tempNode1;

        // 1 > 2 > 3 > 4 > 5 > 6 > 3 > 4 > 5 > 6 > 3 > 4 > 5 > 6......
        // ListNode.printList(node1);

        Node node3 = getNodeInLoop(initNode);
        System.out.println(node3.val);  // 5

        int count = getLoopCount(initNode);
        System.out.println(count);  // 4

        Node node4 = detectCycle(initNode);
        System.out.println(node4.val);  // 3
    }

    public static Node getNodeInLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            // 慢指针每移动一步，快指针移动两步
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    public static int getLoopCount(Node head) {
        Node inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return 0;
        }
        int loopCount = 1;
        for(Node n = inLoop; n.next != inLoop; n = n.next) {
            loopCount++;
        }
        return loopCount;
    }

    public static Node detectCycle(Node head) {
        Node fast = head;
        int n = getLoopCount(head);
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        Node slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
