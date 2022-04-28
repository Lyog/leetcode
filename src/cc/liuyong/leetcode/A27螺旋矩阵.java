package cc.liuyong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A27螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1;
        int top = 0, down = matrix.length - 1;
        int num = matrix.length * matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        while (num >= 1) {
            for (int i = left; i <= right && num >= 1; i++) {
                num--;
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= down && num >= 1; i++) {
                num--;
                ans.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && num >= 1; i--) {
                num--;
                ans.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= top && num >= 1; i--) {
                num--;
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }

}
