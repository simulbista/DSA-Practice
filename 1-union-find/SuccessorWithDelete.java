/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class SuccessorWithDelete {

    private boolean[] data; // data[i]= false means i has been removed
    private UFWithFindLargest ufl;
    private int N;

    public SuccessorWithDelete(int N) {
        this.N = N;
        data = new boolean[N];
        // setting data for all items to true initially (i.e. nothing has been removed yet)
        for (int i = 0; i < N; i++) {
            data[i] = true;
        }
        ufl = new UFWithFindLargest(N);
    }

    public void remove(int x) {
        data[x] = false;
        // if the preceding item has already been removed
        // combine the removed item with x (since they are part of the same component)
        if (x > 0 && !data[x - 1]) ufl.union(x, x - 1);
        // if the following item has already been removed
        // combine the removed item with x (since they are part of the same component)
        if (x < N && !data[x + 1]) ufl.union(x, x + 1);
    }

    public int successor(int x) {
        // if the element hasn't been removed, it is its own successor
        if (data[x]) {
            return x;
        }
        else {
            int res = ufl.find(x) + 1;
            // if x is the last element
            if (res >= N) {
                System.out.println("No successor present");
                return -1;
            }
            else {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        SuccessorWithDelete swd = new SuccessorWithDelete(10);
        System.out.println(swd.successor(3) == 3);
        swd.remove(3);
        System.out.println(swd.successor(3) == 4);
        swd.remove(4);
        System.out.println(swd.successor(3) == 4);
        System.out.println(swd.successor(3) == 5);
    }
}
