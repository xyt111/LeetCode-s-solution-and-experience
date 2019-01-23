class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <= 1 || numRows <= 1)
            return s;
        //make check, if the string's length is less than 1 or the row's number is less than 1, just return it.
        char [][] charMatrix = new char[numRows][(s.length() + (2*numRows-3))/(2*numRows-2) * (numRows-1)];
        //creat a right matrix by length and row's number, calculate the matrix's row number and column number by simple sequence knowledge.
        for(int i = 0 ; i < s.length() ; i++){
            //traverse the string
            if(i % (2*(numRows - 1)) == 0){//judge the start point, about what is the start and end point, look at the bottom
                //start from every start point, and excute the for loop.
                int currentColumn = (i / (2*(numRows - 1)))*(numRows - 1);
                //calculate the start point's column
                int k = 0;
                for(int j = i ; j < i + 2*(numRows - 1) && j < s.length() ; j++){
                    //run from the start point to the end point
                    if(j < i + numRows){
                        k = j - i;
                        charMatrix[k][currentColumn] = s.charAt(j);
                        //store the character which is in the same line with the start point.
                    }else{
                        currentColumn++;
                        k--;
                        charMatrix[k][currentColumn] = s.charAt(j);
                        //store the other character
                    }
                }
                i += 2*numRows - 3;
                //change i when for loop is done.
            }
        }
        String newString = "";
        for(char[] a : charMatrix){
            for(char b : a){
                if(b != '\u0000'){
                    newString += b + "";
                }
            }
        }//get the string in zigzag pattern.
        return newString;
    }
}
//for example, see this subject's example, if the numRows = 3, the start point are P A H N, the end point are Y I R.
