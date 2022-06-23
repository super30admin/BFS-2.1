// https://leetcode.com/problems/rotting-oranges/submissions/

// Time Complexity: O(Row + Column)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

//-------------------------------------- DFS --------------------------------------
class Solution {
    int[][] dir;
    int m;
    int n;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        dir = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 2);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
                else if (grid[i][j] != 0) {
                    max = Math.max(max, grid[i][j] - 2);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j, int time) {
        // Base case

        if (i < 0 || j < 0 || i == m || j == n)
            return;
        if (grid[i][j] != 1 && grid[i][j] < time)
            return;

        // Logic
        grid[i][j] = time;
        for (int[] dir : dir) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc, time + 1);
        }
    }

}
