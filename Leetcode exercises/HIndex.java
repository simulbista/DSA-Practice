import java.util.Arrays;
import java.util.Collections;

public class HIndex {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        // Initialize the h-index to 0
        int hIndex = 0;

        // Iterate through the sorted array
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] >= n - i) {
                hIndex = n - i;
            } else {
                break;
            }
        }
        return hIndex;
    }

    public static void main(String[] args){
//        int [] citations = {3,0,6,1,5};
        int[] citations = {1,3,1};

        System.out.println(hIndex(citations));
    }
}
