package practice.sample1223;

/**
 * 单链表节点定义
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode (int value) {
        this.value = value;
    }

    /**
     * 插入节点
     */
    public ListNode append(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) return newNode;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = newNode;
        return head;
    }

    /**
     * 插入节点：哨兵节点
     */
    public ListNode appendPlus(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode newNode = new ListNode(value);
        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return dummy.next;
    }

    /**
     * 删除第一个指定值的节点
     */
    public ListNode delete(ListNode head, int value) {
        // head 为 null
        if (head == null) return null;
        // head 为 value
        if (head.value == value) return head.next;
        ListNode node = head;
        while (node.next != null) {
            if (node.next.value == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

    /**
     * 删除第一个指定值的节点: 哨兵节点
     */
    public ListNode deletePlus(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.value == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.append(node,2);
        node.append(node,3);
        node.append(node,4);
        node.append(node,5);

        node.delete(node, 4);

        while (node.next != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println(node.value);
    }
}