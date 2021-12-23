// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// Used a queue to store the location of rotten oranges
// Based on the size of the queue traversed the queue and then popped the element and made the oranges around it rotten
// incremented time

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
            }
        }
        if (fresh == 0)
            return 0;
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
            time++;
        }
        if (fresh != 0)
            return -1;
        return time - 1;
    }
}