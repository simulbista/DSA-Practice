//6. Zigzag Conversion (Medium)

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string s, int numRows);
//
//
//Example 1:
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//Example 2:
//
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//Example 3:
//
//Input: s = "A", numRows = 1
//Output: "A"
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consists of English letters (lower-case and upper-case), ',' and '.'.
//1 <= numRows <= 1000
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        //base case
        if(numRows == 1) return s;

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int k = (numRows-1) * 2;

        for(int i =0; i<numRows;i++){
            int index = i;
            while(index<n){
                result.append(s.charAt(index));
                //logic - for first and last row: items will be on index: index + k i.e. index + (numRows-1)*2;
                //for non first and non last rows: items will be on the above index but additionally on : index + k-(2*rowNo) as well
                if(i!=0 && i!=numRows-1){
                    int k1 = index + k - (2*i);
                    if(k1<n) result.append(s.charAt(k1));
                }
                index +=k;
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(convert(s,numRows));
    }
}
