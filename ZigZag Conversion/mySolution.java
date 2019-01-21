class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <= 1 || numRows <= 1)
            return s;
        char [][] charMatrix = new char[numRows][(s.length() + (2*numRows-3))/(2*numRows-2) * (numRows-1)];
        for(int i = 0 ; i < s.length() ; i++){
            if(i % (2*(numRows - 1)) == 0){
                int currentColumn = (i / (2*(numRows - 1)))*(numRows - 1);
                int k = 0;
                for(int j = i ; j < i + 2*(numRows - 1) && j < s.length() ; j++){
                    if(j < i + numRows){
                        k = j - i;
                        charMatrix[k][currentColumn] = s.charAt(j);
                    }else{
                        currentColumn++;
                        k--;
                        charMatrix[k][currentColumn] = s.charAt(j);
                    }
                }
                i += 2*numRows - 3;
            }
        }
        String newString = "";
        for(char[] a : charMatrix){
            for(char b : a){
                if(b != '\u0000'){
                    newString += b + "";
                }
            }
        }
        return newString;
    }
}
