package Linked_List;

//19. Remove Nth Node From End of List (Medium)

//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:
//
//Input: head = [1], n = 1
//Output: []
//Example 3:
//
//Input: head = [1,2], n = 1
//Output: [1]
//
//
//Constraints:
//
//The number of nodes in the list is sz.
//1 <= sz <= 30
//0 <= Node.val <= 100
//1 <= n <= sz
//
//
//Follow up: Could you do this in one pass?
public class RemoveNthNodeFromEndOfList {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(){}

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        ListNode left = dummy;
        ListNode right = head;

        //1st part: to initialize right in the correct starting position (which is head + n position)
        while(n>0){
            right = right.next;
            n--;
        }

        //2nd part: move both left and right until right reaches null (this means we have reached a node before the node to be deleted)
        while(right!=null){
            left = left.next;
            right = right.next;
        }

        //3rd part: delete the node ( our left is at the node just before the node to be deleted)
        left.next = left.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        //head = [1,2,3,4,5], n = 2

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        int n = 2;

        //calling the method and printing the result linked list
        ListNode removed = removeNthFromEnd(head,n);
        while(removed!=null){
            System.out.print(" -> ");
            System.out.print(removed.val);
            removed = removed.next;
        }
    }
}
