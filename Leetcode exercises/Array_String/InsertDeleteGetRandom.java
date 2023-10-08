package Array_String;//380. Insert Delete GetRandom O(1)  (Medium)

//Implement the RandomizedSet class:
//
//RandomizedSet() Initializes the RandomizedSet object.
//bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
//bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
//int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
//You must implement the functions of the class such that each function works in average O(1) time complexity.
//
//
//
//Example 1:
//
//Input
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//Output
//[null, true, false, true, 2, true, false, 2]
//
//Explanation
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
//randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
//randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
//randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
//randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
//randomizedSet.insert(2); // 2 was already in the set, so return false.
//randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
//
//
//Constraints:
//
//-231 <= val <= 231 - 1
//At most 2 * 105 calls will be made to insert, remove, and getRandom.
//There will be at least one element in the data structure when getRandom is called.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {
    private HashMap<Integer, Integer> locs;
    private ArrayList<Integer> nums;

    Random rand = new Random();
    public InsertDeleteGetRandom() {
        locs = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        //the map already contains the key of val
        if(contain) return false;

        // initially, when there is no item in the map and the arraylist = size of arraylist =0
        // inserting the no. 1 will make map -> (1,0) where 0  is the index thats pointing to the index in the arraylist
        // and make the arraylist -> (1)
        locs.put(val,nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        //cant return val if it doesn't exist in the hashmap
        if(!contain) return false;

        //if contains - remove it
        //step1: find the index of the value in the arraylist and store it in a variable loc
        int loc = locs.get(val);
        //step2: if the index in the arraylist is not the final index i.e. its not the last item, we will
        //step2.1: swap the last item in the arraylist with the val in the arraylist
        //step2.2: remove the last item(which is now the val) in the arraylist
        //if we don't do this and are removing an item in the middle of the arraylist, even though the item si removed - the index mapping from the hashmap remains
        if(loc<nums.size()-1){
            //get the last item in the arraylist
            int last = nums.get(nums.size()-1);
            //set this last item to the position of the item getting removed, index of last item changes
            nums.set(loc,last);
            //update the new index of the last item from the arraylist to the hash map
            locs.put(last,loc);
        }
        //remove last item from arraylist and the value from the hashmap
        nums.remove(nums.size()-1);
        locs.remove(val);
        return true;
    }

    public int getRandom() {
        //nextInt method returns 0 to the parameter(exclusive)
        //i.e. nextInt(3) returns 0,1 and 2 randomly
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args){
        InsertDeleteGetRandom x = new InsertDeleteGetRandom();
        System.out.println("Inserting 1 : " + x.insert(1));
        System.out.println("Inserting 2 : " + x.insert(2));
        System.out.println("Inserting 3 : " + x.insert(3));
        System.out.println("Inserting 1 again: " + x.insert(1));

        System.out.println("Removing unavailable 5 : " + x.remove(5));
        System.out.println("Removing 3 : " + x.remove(3));

        System.out.println("Returning randomly from the set : " + x.getRandom());

    }
}
