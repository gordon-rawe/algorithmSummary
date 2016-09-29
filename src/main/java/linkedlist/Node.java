package linkedlist;

import java.util.Map;
import java.util.Stack;

/**
 * Created by gordon on 9/27/16.
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
        Node cursor = head, aux;
        while (cursor.next != null) {
            aux = cursor.next;
            cursor.next = cursor.next.next;
            aux.next = head;
            head = aux;
        }
        return head;
    }

    public static void main(String[] args) {
        printLinkedList(reverseList(buildLinkedList()));
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;
        Node current = head, aux;
        while (current.next != null) {
            aux = current.next;
            current.next = current.next.next;
            aux.next = head;
            head = aux;
        }
        return head;
    }
}