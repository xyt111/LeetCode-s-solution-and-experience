class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <= 1 || numRows <= 1)
            return s;
        String [] stringArray = new String[numRows];
        for(int i = 0 ; i < s.length() ; i++){
            if(i % (2*(numRows - 1)) == 0){
                int k = 0;
                for(int j = i ; j < i + 2*(numRows - 1) && j < s.length() ; j++){
                    if(j < i + numRows){
                        k = j - i;
                        if(stringArray[k] != null){
                            stringArray[k] += s.charAt(j)+"";
                        }else
                            stringArray[k] = s.charAt(j)+"";
                    }else{
                        k--;
                        if(stringArray[k] != null){
                            stringArray[k] += s.charAt(j)+"";
                        }else
                            stringArray[k] = s.charAt(j)+"";
                    }
                }
                i += 2*numRows - 3;
            }
        }
        String newString = "";
        for(String a : stringArray){
            if(a != null){
                newString+=a;
            }
        }
        return newString;
    }
}
