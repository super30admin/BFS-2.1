// Time Complexity : O(mn), m and n matrix size, worst case all are rotten
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
/*
 * Since all the values are connected we use the BFS approach. we have add all the rotten oranges initially in the queue.
 * if there are not rotten we increse the fresh count. After just iterating through the matrix we get fresh count as 0 then we return 0 , bcoz we know there is no fresh orange so no converting to rotten.
 * after adding to the queue, we check in all 4 directions for fresh orange if we find, we make the orage rotten then add to the queue, to avoid repeatability
 * After completing every level we increment the time counter.
*/
class Solution {
    public int orangesRotting(int[][] grid) {

        if (grid.length == 0 || grid == null) {
            return 0;
        }
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        // for BFS approach select all the rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0)
            return 0;
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    // out of bound check
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
            time++;
        }

        if (freshCount == 0)
            return time - 1;

        return -1;
    }
}

// Time Complexity : O((mn)^2), m and n matrix size, worst case all are rotten
// Space Complexity : O(H), H -> m*n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * we use the DFS approach, but we increment the the next orange by 1 if it is
 * fresh orange, go for all the directions
 * we create a dfs recursive function to do do the above approach and at end
 * return max -2, since 2 is the offset.
 */
class Solution {
    int[][] dirs;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;

        dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 1, m, n);
                }
            }
        }

        int max = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
                max = Math.max(max, grid[i][j]);
            }
        }
        if (max == 0)
            return 0;
        return max - 2;
    }

    private void dfs(int[][] grid, int r, int c, int dist, int m, int n) {
        // base
        if (r < 0 || c < 0 || r == m || c == n || grid[r][c] == 0)
            return;

        if (grid[r][c] != 1 && grid[r][c] <= dist)
            return;
        // logic
        if (grid[r][c] != 2)
            grid[r][c] = dist;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(grid, nr, nc, grid[r][c] + 1, m, n);
        }
    }
}