package Linked_List;

//Reverse Linked List II (Medium)

import java.util.Stack;

//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
//
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= n <= 500
//-500 <= Node.val <= 500
//1 <= left <= right <= n
//
//
//Follow up: Could you do it in one pass?
public class ReverseLinkedListII {

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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftPrev = dummy;
        ListNode current = head;

        //1st part: reach the left node (i.e. l-1 iteration)
        for(int i=0; i<left-1;i++){
           leftPrev =  current;
           current = current.next;
        }

        //2nd part: reach the node after right(traversing r-l+1 times) and in the process reverse the link by breaking the older links
        ListNode prev = null;
        ListNode tempNext;
        for(int i=0;i<right-left+1;i++){
            tempNext = current.next;
            //since current.next gets assigned as prev which will alter your current in the last step of this iteration, so we store it in temp to retain its state
            current.next = prev;
            prev = current;
            current = tempNext;
        }


        //3rd part: connect the unconnected nodes: i.e. the reversed chain with the unreversed nodes
            //connecting last node of the reversed part to the first node after the reverse chain
        leftPrev.next.next = current;
            //connecting last node of the node before the reversed part to the first node of the reversed chain
        leftPrev.next = prev;

        return dummy.next;
    }

    public static void main(String[] args) {
        //head = [1,2,3,4,5] left=2, right=4

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);


        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        int left = 2; int right = 4;

        //calling the method and printing the result linked list
        ListNode reversed = reverseBetween(head, left,right);
        while(reversed!=null){
            System.out.print(" -> ");
            System.out.print(reversed.val);
            reversed = reversed.next;
        }
    }
}
