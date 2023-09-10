/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

// Using algs4.jar. Under construction. Write a program RandomWord.java that reads a sequence of words from standard
// input and prints one of those words uniformly at random. Do not store the words in an array or list.
// Instead, use Knuth’s method: when reading the ith word, select it with probability 1/i
//  to be the champion, replacing the previous champion. After reading all of the words, print the surviving champion.
public class RandomWord {
    public static void main(String[] args) {
        int i = 0;
        String champion = "";
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            i++;

            if (StdRandom.bernoulli(1.0 / i)) {
                champion = word;
            }
        }
        System.out.println(champion);
    }
}
