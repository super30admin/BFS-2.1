
//---------------------DFS-----------------------------
// Time Complexity :O(mn)^2
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :was difficult to manage maxtime

//we are performing dfs where we find rotten orange,and rewrite the element at that location as time+2
//and we return our dfs in case of any boundary cross or if next element is not 1 or it is smaller than the current time
//at the end, we return max time in matrix
class Solution {
    private int max;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;

        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        // if(m==1 && grid[m-1][n-1]!=1)return 0;
        int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, m, n, i, j, dirs, 2);
                }

            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                max = Math.max(max, grid[i][j] - 2);
            }
        }
        return max;

    }

    private void dfs(int[][] grid, int m, int n, int i, int j, int[][] dirs, int time) {

        // edge case
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < time)) {
            return;
        } else {

            grid[i][j] = time;

            for (int[] dir : dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                dfs(grid, m, n, nr, nc, dirs, time + 1);
            }

        }

    }
}
// -----------------------BFS------------------------------------
// Time Complexity :O(mn)
// Space Complexity :O(mn) space will be min of m and n in case rotten orange is at corner and all other are fresh
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :No

// after procesing each level, we increase time by 1 and at the end if fresh
// becomes 0, we return time+1

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    int[] temp = { i, j };
                    q.add(temp);
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        ;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r >= 0 && c >= 0 && r < m && c < n) {
                        if (grid[r][c] == 1) {
                            q.add(new int[] { r, c });
                            grid[r][c] = 2;
                            fresh--;
                            if (fresh == 0) {
                                return time + 1;
                            }
                        }
                    }
                }

            }
            time++;
        }
        return -1;
    }
}
