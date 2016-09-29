package mergelinkedlist;

import lastk.LastKNode;

/**
 * Created by gordon on 16/9/28.
 */
public class MergeTwoSortedLinkedList {

    public static void printLinkedList(LastKNode.Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static LastKNode.Node buildList1() {
        LastKNode.Node root = new LastKNode.Node(0);
        LastKNode.Node lastNode = root;
        for (int i = 0; i < 10; i++) {
            LastKNode.Node tmpNode = new LastKNode.Node(i * 2 + 2);
            lastNode.next = tmpNode;
            lastNode = tmpNode;
        }
        return root;
    }

    public static LastKNode.Node buildList2() {
        LastKNode.Node root = new LastKNode.Node(1);
        LastKNode.Node lastNode = root;
        for (int i = 0; i < 10; i++) {
            LastKNode.Node tmpNode = new LastKNode.Node(2 * i + 1);
            lastNode.next = tmpNode;
            lastNode = tmpNode;
        }
        return root;
    }

    public static LastKNode.Node mergeTwoSortedLinkedList(LastKNode.Node h1, LastKNode.Node h2) {
        LastKNode.Node retHead;
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        if (h1.value < h2.value) {
            retHead = h1;
            h1.next = mergeTwoSortedLinkedList(h1.next, h2);
        } else {
            retHead = h2;
            h2.next = mergeTwoSortedLinkedList(h2.next, h1);
        }
        return retHead;
    }

    public static void main(String[] args) {
        printLinkedList(buildList1());
        System.out.println();
        printLinkedList(buildList2());
        System.out.println();
        printLinkedList(mergeTwoSortedLinkedList(buildList1(), buildList2()));
    }
}
