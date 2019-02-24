class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
//
6: 构建一个stringBuilder的arraylist，stringBuilder也是字符串，用法参考https://www.cnblogs.com/Lxiaojiang/p/6442137.html
7: 第一次循环，循环次数为zigzag行数与字符串长度的最小值，n次（n = s.length），构建第六行创建的arraylist
13: 第二次循环，遍历字符串的每个character，循环次数为n次（n = s.length），第二次循环其实就是对字符串的zigzag形式从第一个遍历到最后一个
19-21: 遍历第六行创建的arraylist，将每一行的字符串加在一起，打印出来
