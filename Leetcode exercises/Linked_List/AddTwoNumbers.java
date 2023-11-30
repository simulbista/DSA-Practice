package Linked_List;

//2. Add Two Numbers (Medium)

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
//
//Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//Constraints:
//
//The number of nodes in each linked list is in the range [1, 100].
//0 <= Node.val <= 9
//It is guaranteed that the list represents a number that does not have leading zeros.
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //setting the dummy to a random node with value 0, so at the end of the method we can point to its next
        // which is where the first node of the result lies. i.e return dummy.next points the result's first node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        //carry >0 is for the edge case when both l1 and l2 val don't exist but there is a carry forward
        while(l1 != null || l2!=null || carry>0){
            //edge case: if one or both is null
            int x = (l1 !=null) ? l1.val : 0;
            int y = (l2 !=null) ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum/10;
            //setting the next time as the remainder of division by 10
            current.next = new ListNode(sum%10);
            current = current.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
//        l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1,l2,l3;
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        l3 = addTwoNumbers(l1,l2);
        while(l3!=null){
            System.out.print(" -> ");
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }

}
