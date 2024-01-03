package Linked_List;

//146. LRU Cache (Medium)

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
//Implement the LRUCache class:
//
//LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//int get(int key) Return the value of the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//The functions get and put must each run in O(1) average time complexity.
//
//
//
//Example 1:
//
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
//
//
//Constraints:
//
//1 <= capacity <= 3000
//0 <= key <= 104
//0 <= value <= 105
//At most 2 * 105 calls will be made to get and put.
public class LRUCache {

    public class Node{
        int key,val;
        Node prev,next;
        public Node(int key, int val){
            this.key = key;this.val=val;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity;
    Map<Integer,Node> cache;  //map key to nodes
    Node left,right;    //dummy nodes to point(next and prev respectively) the least recent and the most recent values
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        left = new Node(0,0);   //left.next = LRU (Least Recently Used)
        right = new Node(0,0);  //right.prev = most recently used
        left.next = right;
        right.prev = left;

        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            //Step1:  remove that node containing the key from the linkedlist
            //Step 2: add the node containing the same value to the right (since accessing means it is used recently)
            remove(cache.get(key));
            insert(cache.get(key));
            print();
            return cache.get(key).val;
        }
        print();
        return -1;
    }

    public void put(int key, int value) {
        //if the key-value already exists then we remove the existing node from the linkedlist
        if(cache.containsKey(key))  remove(cache.get(key));

        //create the new node (with the given key-val) and make the hashmap point to it
        // and then insert it to the linked list
        //Note: if the key is in the cache already, the following wont add a duplicate key-value pair to the cache
        //instead: it will replace the older pair with the new one (hence maintaining unique keys in the map)
        cache.put(key, new Node(key,value));
        insert(cache.get(key));

        //Note: the above insertion might create no. of nodes greater than the capacity (for new value insertions to the cache map), hence we remove it
        //if the capacity is already full, we need to remove the lru
        if(cache.size()>this.capacity){
            Node lru = left.next;
            remove(lru);    //remove lru from the linked list
            cache.remove(lru.key);  //remove it from the hashmap
        }
        print();
    }


    //helper methods (remove and insert) to update the link list (that tracks the least recent used)

        //remove node from the list
        public void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;

            //connect prev to next and next to prev (hence deleting the middle node)
            prev.next = next;
            next.prev=  prev;
        }

        //insert node at the right (since insert means the node was used recently so must be the most recently used)
        public void insert(Node node){
            Node prev = right.prev;
            Node next = this.right;

            //insert between the right (dummy) pointer and the node previous to the right pointer
                prev.next = next.prev = node;

                node.prev = prev;
                node.next = next;
        }

        //to help me debug (print the linkedlist)
        public void print(){
            Node start = left;
            System.out.println("");
            while(start!=null){
                System.out.print(" -> ");
                System.out.print("(" + start.key + "," + start.val + ")");
                start = start.next;
            }
        }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        lRUCache.get(1);    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        lRUCache.get(2);    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        lRUCache.get(1);    // return -1 (not found)
//        lRUCache.get(3);    // return 3
//        lRUCache.get(4);    // return 4

        lRUCache.get(2);    // return -1
        lRUCache.put(2, 6); // cache is {2=6}
        lRUCache.get(1);    // return -1
        lRUCache.put(1, 5); // cache is {2=6, 1=5}
        lRUCache.put(1, 2); // cache is {2=6, 1=2}
        lRUCache.get(1);    // return 2
        lRUCache.get(2);    // return 6
    }
}
