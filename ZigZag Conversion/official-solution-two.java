class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
/*
6: construct string ret by StringBuilder
7: n indicates(refers to) string ret's length
10: traverse all the line of zigzag pattern of string ret(line by line)
11 and 12: get the character in a straight line and append it to string ret 
13: get the character between two character in straight line and append it to string ret
time complexity is O(n), n indicates the length of string ret
space complexity is O(n), n refers to the length of string ret
*/
