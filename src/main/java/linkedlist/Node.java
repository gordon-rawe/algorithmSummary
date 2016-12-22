package linkedlist;

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
        for (int i = 1; i < 5; i++) {
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

    /**
     * java里面要直接更改传入的变量，可以使用数组，所以，在下面，我们采用Node[]表示输入源，nodes[0]表示链表头，nodes[1]表示某个节点
     */
    public static void deleteNodeO1(Node[] nodes) {
        if (nodes.length != 2) return;
        Node head = nodes[0], target = nodes[1];
        if (head == null || target == null) return;
        if (target.next != null) {
            target.value = target.next.value;
            target.next = target.next.next;
            target.next = null;
        } else if (head == target) {
            nodes[1] = null;
            nodes[0] = null;
        } else {
            while (head.next != target) {
                head = head.next;
            }
            head.next = null;
            nodes[1] = null;
        }
    }

    public static Node getLaskK(Node node, int k) {
        Node p1 = node, p2 = node;
        for (int i = 0; i < k - 1; i++) {
            if (p1.next == null) return null;
            p1 = p1.next;
        }
        while (p1 != null && p1.next != null) {
            p2 = p2.next;
        }
        return p2;
    }

    public static int current = 1;

    public static Node findLastKthNodeRecursive(Node node, int k) {
        if(node==null)return null;
        Node n = null;
        if (node.next != null) {
            n = findLastKthNodeRecursive(node.next, k);
        }
        if (current++ == k) {
            return node;
        } else {
            return n;
        }
    }

    public static Node findLastKthNode(Node head, int k) {
        if (head == null || k <= 0) return null;
        Node node1 = head;
        for (int i = 0; i < k - 1; i++) {
            if (node1.next != null) node1 = node1.next;
            else return null;
        }
        Node node2 = head;
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }

    public static void main(String[] args) {
        Node list = buildLinkedList();
        printLinkedList(list);
        Node node = findLastKthNodeRecursive(list,4);
        System.out.println(node==null?"null":node.value);
    }

    public static Node reverseLists(Node head) {
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

    public static Node mergeTwoLinkedLists(Node one, Node two) {
        if (one == null) return two;
        else if (two == null) return one;
        Node retNode;
        if (one.value < two.value) {
            retNode = one;
            retNode.next = mergeTwoLinkedLists(one.next, two);
        } else {
            retNode = two;
            retNode.next = mergeTwoLinkedLists(one, two.next);
        }
        return retNode;
    }

    public static Node firstCommonNode(Node one, Node two) {
        if (one == null || two == null) return null;
        int countOne = 0, countTwo = 0;
        Node p1 = one, p2 = two;
        while (p1 != null) {
            p1 = p1.next;
            countOne++;
        }
        while (p2 != null) {
            p2 = p2.next;
            countTwo++;
        }
        int diff = countOne - countTwo;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                one = one.next;
            }
        } else {
            for (int i = 0; i < -diff; i++) {
                two = two.next;
            }
        }
        while (one != null && two != null) {
            if (one == two) return one;
            one = one.next;
            two = two.next;
        }
        return null;
    }

    public static void printReversely() {

    }

    public static linknode.Node deleteNode(linknode.Node head, linknode.Node nodeToDelete) {
        if (nodeToDelete == null || head == null) return head;
        if (nodeToDelete.next != null) {/*要删除的节点有下一个节点,拷贝内容*/
            nodeToDelete.value = nodeToDelete.next.value;
            nodeToDelete.next = nodeToDelete.next.next;
        } else if (nodeToDelete == head) {/*头部只有一个节点*/
            return null;
        } else {/*只剩下最后一个节点了*/
            linknode.Node node = head;
            while (node.next != nodeToDelete) {
                node = node.next;
            }
            node.next = null;
        }
        return head;
    }
}