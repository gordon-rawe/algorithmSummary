package linknode;

/**
 * Created by gordon on 16/9/26.
 */
public class TestCase {
    public static void main(String[] args) {
//        System.out.println("----------- normal order-----------");
//        Node.printLinkedList(Node.buildLinkedList());
//        System.out.println("-----------reverse order-----------");
//        Node.printLinkedListReverse(Node.buildLinkedList());
//        System.out.println("--------stack reverse order--------");
//        Node.printLinkedListReverseUsingStack(Node.buildLinkedList());
        System.out.println("----------- reverse linked list-----------");
        Node.printLinkedList(Node.reverseLinkedList(Node.buildLinkedList()));
    }
}
