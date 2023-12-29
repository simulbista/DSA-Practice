package Linked_List;

//86. Partition List

//Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//
//
//Example 1:
//
//
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
//Example 2:
//
//Input: head = [2,1], x = 2
//Output: [1,2]
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 200].
//-100 <= Node.val <= 100
//-200 <= x <= 200
public class PartitionList {
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
    public static ListNode partition(ListNode head, int x) {
        //logic - me are creating 2 linked lists (1 more nodes less than x) and the other for nodes more or equal to x
        //traverse the list - if item is less than x then connect it with smaller ll
        //else connect it with greater ll.

        //at the end. connect the end of the smaller ll to the marked head of the bigger ll.

        ListNode headLess = new ListNode(0);
        ListNode headGreater = new ListNode(0);
        ListNode currentLess = headLess;
        ListNode currentGreater = headGreater;
        ListNode current = head;

        // head.val<x?smallerHead = head:greaterHead = head;

        while(current!=null){
            if(current.val<x) {
                currentLess.next = new ListNode(current.val);
                currentLess = currentLess.next;
            }else{
                currentGreater.next = new ListNode(current.val);
                currentGreater = currentGreater.next;
            }
            current = current.next;
        }
        currentLess.next = headGreater.next;

        return headLess.next;
    }

    public static void main(String[] args) {
        //head = [1,4,3,2,5,2], x = 3

        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        int x = 3;

        ListNode partitionedList = partition(head, x);

        while(partitionedList!=null){
            System.out.print(" -> " + partitionedList.val);
            partitionedList = partitionedList.next;
        }
    }
}
