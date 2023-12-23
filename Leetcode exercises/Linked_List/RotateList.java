package Linked_List;

//61. Rotate List (Medium)

//Given the head of a linked list, rotate the list to the right by k places.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//Example 2:
//
//
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 500].
//-100 <= Node.val <= 100
//0 <= k <= 2 * 109
public class RotateList {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        //edge case
        if(head ==null) return head;

        int length=1;
        ListNode tail = head;
        ListNode newHead;

        //1st part: traverse all the nodes and find its length and position the tail at the end
        while(tail.next!=null){
            tail = tail.next;
            length++;
        }

        k = k%length;

        //edge case
        if(k == 0) return head;

        //2nd part: traverse and reach to the node before the node to be moved
        //i.e. length - k - 1 times

        ListNode current = head;
        for(int i=0;i<length-k-1;i++){
            current = current.next;
        }

        //3rd part: break the connection and attach it to the beginning of the list
        newHead = current.next;
        current.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        //head = [1,2,3,4,5], k = 2

        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        int k = 2;

        ListNode rotatedList = rotateRight(head, k);

        while(rotatedList!=null){
            System.out.print(" -> " + rotatedList.val);
            rotatedList = rotatedList.next;
        }
    }
}
