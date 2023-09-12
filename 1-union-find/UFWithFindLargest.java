/* Union-find with specific canonical element.
 * Add a method find() to the union-find data type so that find(i)
 * returns the largest element in the connected component containing i.
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is {1,2,6,9},
 * then the find() method should return 9 for each of the four elements in the connected components.
 */


public class UFWithFindLargest {
    private int[] id;
    private int[] sz;
    private int[] large;

    public UFWithFindLargest(int N) {
        id = new int[N];
        sz = new int[N];
        large = new int[N];
        for (int i = 0; i < N; i++) {
            // assigning id of each no. to that no. like id[1] = 1, id[2] = 2 ...
            id[i] = i;
            // initially size for all items is 1
            sz[i] = 1;
            // large for an item is that item itself (same as id)
            large[i] = i;
        }
    }

    // find the root of item i
    private int root(int i) {
        // for example the connected elements are 8->3->4 i.e. root is 8 and input to the function is 4 i.e. find root of 4
        // 1st iteration: 4!=3, i=3
        // 2nd iteration: 3!=8, i=8
        // 3rd iteration: 8!=8 so end loop i.e. i=8 which is the root
        while (i != id[i]) {
            id[i]
                    = id[id[i]]; // path compression i.e. make every node in path to point its grandparent instead of its parent
            i = id[i];
        }
        return i;
    }

    // find the largest item in the component
    public int find(int p) {
        return large[root(p)];
    }

    // union component with p to the component with q
    public void union(int p, int q) {
        //        int pid = id[p];
        //        int qid = id[q];
        //        for (int i = 0; i < id.length; i++)
        //            //if the id of any items in the list is equal to the id of the first item, set the id to that of the 2nd item
        //            //e.g.: pid=2 and qid=3, if id[5] = 2, then id[5]=3, if id[7] = 2, then id[7] =3 ...
        //            if (id[i] == pid) id[i] = qid;

        int rootP = root(p);
        int rootQ = root(q);
        // if both have the same root, it is already combined
        if (rootP == rootQ) return;

        int largestP = large[rootP];
        int largestQ = large[rootQ];

        // always combine the smaller component to the bigger one
        // size of the component is based on the no. of items it has

        // if size of first component is smaller than the size of second component, add the first component to the second component
        // add the size of the first component to the size of the second component
        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
            if (largestP > largestQ) large[rootQ] = largestP;
        }
        else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
            if (largestQ > largestP) large[p] = largestQ;
        }
    }

    // check if two items belong to the same component
    // returns true if connected else false
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }


    // main method

    public static void main(String[] args) {
        // initializing constructor with N=10 i.e. 10 items
        UFWithFindLargest ufl = new UFWithFindLargest(10);

        // union end result: component -> {1,2,6,9}
        ufl.union(1, 2);
        ufl.union(6, 9);
        ufl.union(1, 6);

        // finding greatest from the component
        System.out.println(ufl.find(1));
        System.out.println(ufl.find(2));
        System.out.println(ufl.find(6));
        System.out.println(ufl.find(9));

        System.out.println(ufl.find(3));
    }
}
