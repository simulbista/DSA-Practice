package Stack;

//71. Simplify Path (Medium)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
//
//In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
//
//The canonical path should have the following format:
//
//The path starts with a single slash '/'.
//Any two directories are separated by a single slash '/'.
//The path does not end with a trailing '/'.
//The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
//Return the simplified canonical path.
//
//
//
//Example 1:
//
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory name.
//Example 2:
//
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
//Example 3:
//
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
//
//
//Constraints:
//
//1 <= path.length <= 3000
//path consists of English letters, digits, period '.', slash '/' or '_'.
//path is a valid absolute Unix path.
public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList(".","..",""));

        //we split the path by / i.e.
        // the path /a//b becomes "a","","b"
        for(String dir : path.split("/")){
            if(dir.equals("..") && !stack.isEmpty()){
                // double dot means go back 1 lvl ie.. pop the latest stack value
                stack.pop();
            }else if(!skip.contains(dir)){
                //we push values in the stack other than the values .,.. and null (null might come from path.split)
                stack.push(dir);
            }
        }
        //add a slash in the beginning and between each elements in the stack (since we removed these elements while splitting)
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
//        String path = "/home/";
//        String path = "/../";
        String path = "/home//foo/";

        System.out.println(simplifyPath(path));

    }
}
