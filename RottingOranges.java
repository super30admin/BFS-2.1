import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n) , Traverse and Queue
// Space Complexity : O(m*n), Queue Space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int fresh = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // counting no. of fresh oranges.
                    fresh++;
                }
                if (grid[i][j] == 2) { // adding rotten oranges's row and column to queue.
                    q.add(new int[] { i, j });
                }
            }
        }

        if (fresh == 0)
            return 0;

        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) { // to check 4 directions of each cell
                    int nr = curr[0] + dir[0]; // new row
                    int nc = curr[1] + dir[1]; // new column
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) { // valid row and colum and
                                                                                       // considering only fresh
                                                                                       // oranges.
                        fresh--;
                        q.add(new int[] { nr, nc });
                        grid[nr][nc] = 2; // so that there are no duplicates in the queue.

                    }
                }

            }

            time++; // incrementing time after each level
        }

        if (fresh != 0) // not all oranges can be rotted, therefore return -1.
            return -1;
        return time - 1; // because the time will advance by 1 in the last level.
    }
}