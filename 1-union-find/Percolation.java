/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid; // grid[i][j]=false for blocked and true for open

    private WeightedQuickUnionUF uf;  // for percolates()
    private WeightedQuickUnionUF ufBack; // for isFull()
    private int sz;
    private int N;
    private int noOfOpenSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int N) {
        // initially no sites are open
        noOfOpenSites = 0;
        if (N <= 0) throw new java.lang.IllegalArgumentException();

        grid = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }
        this.N = N;
        int nSquare = N * N;
        this.sz = nSquare + 2;
        uf = new WeightedQuickUnionUF(
                sz); // create one virtual node top and one virtual node at bottom (so if both these virtual nodes are connected, it means the system perculates)
        ufBack = new WeightedQuickUnionUF(nSquare
                                                  + 1); // one virtual node on top , to keep track of the full sites i.e. blue colored sites( the sites that are connected to top, because any element(water) is flowing from top)

        for (int i = 1; i <= N; i++) {
            uf.union(0,
                     i);  // connecting all items from top row(element 1,2 and 3) to top virtual node(0) for 3x3 set
            uf.union(sz - 1, nSquare + 1
                    - i); // connecting all items from bottom row (element 7,8 and 9) to bottom virtual node(10) for 3x3 set
            ufBack.union(0,
                         i); // connecting all items from top row(element 1,2 and 3) to top virtual node(0) for 3x3 set for uf tracking the full sites
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // open the current element i.e. first element [1][1] is actually [0][0] index
        grid[row - 1][col - 1] = true;
        // increment the open sites count when a site is opened
        noOfOpenSites++;

        // get index of the site
        int index = positionOfSite(row, col);

        // now we need to check if the left,right,top and bottom adjacent sites are open, if open then union them with current site

        // the site above it is open?
        if (row > 1 && isOpen(row - 1, col)) {
            // union the site above it with the current site (positions)
            uf.union(positionOfSite(row - 1, col), index);
            // do the same for the union object checking the full sites
            ufBack.union(positionOfSite(row - 1, col), index);
        }
        // the site below it is open?
        if (row < N && isOpen(row + 1, col)) {
            // union the site below it with the current site (positions)
            uf.union(positionOfSite(row + 1, col), index);
            ufBack.union(positionOfSite(row + 1, col), index);
        }

        // the site on the left of it is open?
        if (col > 1 && isOpen(row, col - 1)) {
            // union the site to the left of it with the current site (positions)
            uf.union(positionOfSite(row, col - 1), index);
            ufBack.union(positionOfSite(row, col - 1), index);
        }

        // the site on the right of it is open?
        if (col < N && isOpen(row, col + 1)) {
            // union the site to the right of it with the current site (positions)
            uf.union(positionOfSite(row, col + 1), index);
            ufBack.union(positionOfSite(row, col + 1), index);
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    // its full if a) its open and b) it is connected to the top node (using the ufBack data structure)
    public boolean isFull(int row, int col) {
        // connected method deprecated,so use alternative
        // return isOpen(row, col) && ufBack.connected(positionOfSite(row, col), 0);

        return isOpen(row, col) && ufBack.find(positionOfSite(row, col)) == ufBack.find(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return noOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        // if the size of set is 1x1 and then if its open then it percolates else it doesn't
        if (N == 1) return isOpen(1, 1);
        // if top virtual node(node 0) and bottom virtual node (node 10) in a 3x3 set is connected, then the system percolates
        // since connected method is deprecated
        // return uf.connected(0, sz - 1);
        return uf.find(0) == uf.find(sz - 1);
    }

    // helper method to find the position of the element in the set
    // e.g.; in a 3x3 set, element (1,1) is grid[0][0] i.e. 1, element (1,2) is grid[0][1] i.e. 2 (top virtual node is element 0 and bottom virtual node is element 10)
    //     0
    // 1   2   3
    // 4   5   6
    // 7   8   9
    //     10
    private int positionOfSite(int i, int j) {
        return (i - 1) * N + j;
    }

    public static void main(String[] args) {
        Percolation perc = new Percolation(5);
        System.out.println("Is (2,1) element at position 6 open? " + perc.isOpen(2, 1));
        System.out.println("Is (1,1) element at position 1 full? " + perc.isFull(1, 1));
        perc.open(1, 1);
        System.out.println("Opening (1,1) element at position 1");
        System.out.println("Is (1,1) element at position 1 open? " + perc.isOpen(1, 1));
        System.out.println("Is (1,1) element at position 1 full? " + perc.isFull(1, 1));
        System.out.println("Does the system perculate? " + perc.percolates());
        System.out.println("Total number of open sites - " + perc.numberOfOpenSites());
        System.out.println("Opening (2,2),(3,3),(4,4) and (5,5)");
        perc.open(2, 2);
        perc.open(3, 3);
        perc.open(4, 4);
        perc.open(5, 5);
        System.out.println("Does the system perculate? " + perc.percolates());
        System.out.println("Total number of open sites - " + perc.numberOfOpenSites());
        System.out.println("Opening (1,2),(2,3),(3,4) and (4,5)");
        perc.open(1, 2);
        perc.open(2, 3);
        perc.open(3, 4);
        perc.open(4, 5);
        System.out.println("Does the system perculate? " + perc.percolates());
        System.out.println("Total number of open sites - " + perc.numberOfOpenSites());
        System.out.println(perc.isFull(5, 5));
    }
}
