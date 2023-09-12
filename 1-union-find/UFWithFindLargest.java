public class UFWithFindLargest {
    private int[] id;
    private int[] sz;

    public UFWithFindLargest(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            //assigning id of each no. to that no. like id[1] = 1, id[2] = 2 ...
            id[i] = i;
        }
    }

    //find the root of item i
    private int root(int i) {
        // for example the connected elements are 8->3->4 i.e. root is 8 and input to the function is 4 i.e. find root of 4
        //1st iteration: 4!=3, i=3
        //2nd iteration: 3!=8, i=8
        //3rd iteration: 8!=8 so end loop i.e. i=8 which is the root
        while (i != id[i]) {
            id[i] = id[id[i]]; //path compression i.e. make every node in path to point its grandparent instead of its parent
            i = id[i];
        }
        return i;
    }

    //union component with p to the component with q
    public void union(int p, int q) {
//        int pid = id[p];
//        int qid = id[q];
//        for (int i = 0; i < id.length; i++)
//            //if the id of any items in the list is equal to the id of the first item, set the id to that of the 2nd item
//            //e.g.: pid=2 and qid=3, if id[5] = 2, then id[5]=3, if id[7] = 2, then id[7] =3 ...
//            if (id[i] == pid) id[i] = qid;

        int i = root(p);
        int j = root(q);
        //if both have the same root, it is already combined
        if (i == j) return;

        //always combine the smaller component to the bigger one
        //size of the component is based on the no. of items it has

        //if size of first component is smaller than the size of second component, add the first component to the second component
        // add the size of the first component to the size of the second component
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    // check if two items belong to the same component
    //returns true if connected else false
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
}
