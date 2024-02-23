// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int m;
    int n;

    public int orangesRotting(int[][] grid) {
        // return helperBfs(grid);
        return helperDfs(grid);
        
    }

    private int helperBfs(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        if (fresh == 0) {
            return time;
        }
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r >= 0 && c >= 0 && r < m && c < n && (grid[r][c] == 1)) {
                        grid[r][c] = 2;
                        fresh--;
                        if (fresh == 0) {
                            return time + 1;
                        }
                        q.offer(new int[] { r, c });
                    }
                }
            }
            time++;
        }
        if (fresh != 0) {
            return -1;
        }
        return --time;
    }

    private int helperDfs(int[][] grid) {
        int offSet = 2;
        this.m = grid.length;
        this.n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, offSet);
                }
            }
        }

        int max = offSet;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }

                max = Math.max(max, grid[i][j]);
            }
        }
        return max - offSet;
    }

    private void dfs(int[][] grid, int r, int c, int time) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) {
            return;
        }

        if (grid[r][c] != 1 && grid[r][c] < time) {
            return;
        }

        grid[r][c] = time;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc, time + 1);
        }
    }
}