package linkedList;

public class ListNodeSample002 {
    public static void main(String[] args) {
        Node initNode = new Node(1);
        Node LoopNode = null;
        for (int i = 2; i < 7; i++) {
            initNode.append2(initNode, i);
        }

        Node tempNode1 = initNode;
        for (int i = 1; i < 3; i++) {
            tempNode1 = tempNode1.next;
        }
        LoopNode = tempNode1;

        Node tempNode2 = initNode;
        while(tempNode2.next != null) {
            tempNode2 = tempNode2.next;
        }
        tempNode2.next = LoopNode;

        Node node = detectCycle(initNode);
        if (node != null) {
            System.out.println(node.val);
        }
    }

    public static Node getNodeInLoop(Node head) {
        if (head == null || head.next == null) {
           return null;
        }
        Node slow = head.next;
        Node fast = slow.next;
        while(slow != null && fast != null) {
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

    public static Node detectCycle(Node head) {
        Node inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        int loopCount = 1;
        for (Node n = inLoop; n.next != inLoop; n = n.next) {
            loopCount++;
        }

        Node fast = head;
        for (int i = 0; i < loopCount; ++i) {
            fast = fast.next;
        }

        Node slow = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
