// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int cur = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cur = grid[i][j];
                if (cur == 2) {
                    q.add(new int[] { i, j });
                } else if (cur == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur_cell = q.poll();
                for (int[] dir : dirs) {
                    int nr = cur_cell[0] + dir[0];
                    int nc = cur_cell[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[] { nr, nc });
                        fresh--;
                    }
                }
            }
            time++;
        }

        if (fresh > 0)
            return -1;
        return time - 1;
    }
}
