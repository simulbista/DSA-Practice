package Linked_List;

//21. Merge Two Sorted Lists (Easy)

import java.util.List;

//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
//
//
//
//Example 1:
//
//
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//
//Input: list1 = [], list2 = [0]
//Output: [0]
//
//
//Constraints:
//
//The number of nodes in both lists is in the range [0, 50].
//-100 <= Node.val <= 100
//Both list1 and list2 are sorted in non-decreasing order.
public class MergeTwoSortedLists {
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        //edge cases: if one of the list has ended while there are items remaining on the other one
        //we append that remaining list items to our result
        if(list1!=null){
            current.next = list1;
        }else if(list2!=null){
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode finalList;

        finalList = mergeTwoLists(list1,list2);
        while(finalList!=null){
            System.out.print(" -> ");
            System.out.print(finalList.val);
            finalList = finalList.next;
        }
    }
}
