package Linked_List;

//82. Remove Duplicates from Sorted List II (Medium)

//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
//Example 2:
//
//
//Input: head = [1,1,1,2,3]
//Output: [2,3]
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 300].
//-100 <= Node.val <= 100
//The list is guaranteed to be sorted in ascending order.
public class RemoveDuplicatesFromSortedListII {

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

        public static ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0, head);

            ListNode prev = dummy;
            ListNode current = head;

            while(current!=null){

                if(current.next!=null && current.val == current.next.val){
                    while(current.val==current.next.val){
                        current = current.next;
                    }
                    prev.next = current.next;
                }else{
                    prev = prev.next;
                }
                current = current.next;
            }
            return dummy.next;
        }

        public static void main(String[] args) {

//            head = [1,2,3,3,4,4,5]

            ListNode head = new ListNode(1);
            ListNode node1 = new ListNode(2);
            ListNode node2 = new ListNode(3);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);
            ListNode node5 = new ListNode(4);
            ListNode node6 = new ListNode(5);

            head.next = node1;
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node6;

            int n = 2;

            //calling the method and printing the result linked list
            ListNode uniqueList = deleteDuplicates(head);
            while(uniqueList!=null){
                System.out.print(" -> ");
                System.out.print(uniqueList.val);
                uniqueList = uniqueList.next;
            }
        }

    }
}
