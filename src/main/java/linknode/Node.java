package linknode;

import java.util.Stack;

/**
 * Created by gordon on 16/9/26.
 */
public class Node {
    public Node next;
    public int value;

    public static Node buildLinkedList() {
        Node firstNode = new Node();
        Node headNode = firstNode;
        firstNode.value = 0;
        for (int i = 1; i < 50; i++) {
            Node tmpValue = new Node();
            tmpValue.value = i;
            headNode.next = tmpValue;
            headNode = tmpValue;
        }
        return firstNode;
    }

    public static void printLinkedList(Node linkedList) {
        if (linkedList == null) return;
        while (linkedList != null) {
            System.out.println(linkedList.value);
            linkedList = linkedList.next;
        }
    }

    public static void printLinkedListReverse(Node linkedList) {
        if (linkedList == null) return;
        if (linkedList.next != null) printLinkedListReverse(linkedList.next);
        System.out.println(linkedList.value);
    }

    public static void printLinkedListReverseUsingStack(Node linkedList) {
        if (linkedList == null) return;
        Stack<Node> nodeStack = new Stack<>();
        while (linkedList != null) {
            nodeStack.push(linkedList);
            linkedList = linkedList.next;
        }
        while (!nodeStack.empty()) {
            System.out.println(nodeStack.peek().value);
            nodeStack.pop();
        }
    }

    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        Node cursor = head.next, aux;
        while (cursor != null) {
            aux = cursor;
            cursor = cursor.next;
            aux.next = head;
            head = aux;
        }
        return head;
    }
}
