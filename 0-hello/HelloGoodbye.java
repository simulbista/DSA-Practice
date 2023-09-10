/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

// Command-line arguments. Write a program HelloGoodbye.java that takes two names as command-line arguments and
// prints hello and goodbye messages as shown below (with the names for the hello message in the same order as
// the command-line arguments and with the names for the goodbye message in reverse order).
public class HelloGoodbye {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide 2 names!");
        }
        else {
            System.out.println(
                    "Hello ".concat(args[0]).concat(" and ").concat(args[1]).concat(".\nGoodbye ")
                            .concat(args[1]).concat(" and ").concat(args[0]).concat("."));
        }
    }
}
