package cc.liuyong.leetcode;

public class A20岛屿数量 {

    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ans = 0;
        int ni = grid.length;
        int nj = grid[0].length;
        for (int i = 0; i < ni; i++) {
            for (int j = 0; j < nj; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        int ni = grid.length - 1;
        int nj = grid[0].length - 1;
        if (i < 0 || j < 0 || i > ni || j > nj || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}
