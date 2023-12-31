package Linked_List;

//138. Copy List with Random Pointer (Medium)

import java.util.HashMap;
import java.util.Map;

//A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
//
//Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
//
//For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
//
//Return the head of the copied linked list.
//
//The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//
//val: an integer representing Node.val
//random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
//Your code will only be given the head of the original linked list.
//
//
//
//Example 1:
//
//
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Example 2:
//
//
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
//Example 3:
//
//
//
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
//
//
//Constraints:
//
//0 <= n <= 1000
//-104 <= Node.val <= 104
//Node.random is null or is pointing to some node in the linked list.
public class CopyListWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        Map<Node,Node> nodeMap = new HashMap<>();

        Node current = head;
        Node copy;

        //first pass: to create the new copy nodes mapped with the original nodes in the hashmap
        while(current!=null){
            copy = new Node(current.val);
            nodeMap.put(current,copy);
            current = current.next;
        }

        //second pass: to connect the nodes and then the random pointer with the help of the hashmap link
        current = head;
        while(current!=null){
            copy = nodeMap.get(current);
            copy.next = nodeMap.get(current.next);
            if(current.random == null){
                copy.random = null;
            }else{
                copy.random = nodeMap.get(current.random);
            }
            current = current.next;
            copy = copy.next;
        }

        return nodeMap.get(head);
    }

    public static void main(String[] args) {
        //head = [[7,null],[13,0],[11,4],[10,2],[1,0]]

        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;

        //calling the method and printing the result linked list
        Node finalList = copyRandomList(head);
        while(finalList!=null){
            System.out.print(" -> ");
            System.out.print(finalList.val + "(" + finalList.random + ")");
            finalList = finalList.next;
        }

    }
}
