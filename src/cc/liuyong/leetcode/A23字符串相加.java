package cc.liuyong.leetcode;

public class A23字符串相加 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || add != 0) {
            int x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int result = x + y + add;
            sb.append(result % 10);
            add = result / 10;
            len1--;
            len2--;
        }
        return sb.reverse().toString();
    }
}
