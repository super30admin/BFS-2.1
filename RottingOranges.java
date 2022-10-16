// Time Complexity : O(m*n)
// Space Complexity : O(m*n) where at some point, there could be m*n elements in the queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I did not consider array with all 0 values and had to fix it
class Solution {
    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1}, {0,-1},{1,0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        int minutes = 0;

        // Capture all the co-ordinates with 2 value in the queue
        for (int i=0; i< m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i,j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;

        // start iteration on the elemnts in the stack
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr= q.poll();

                // loop over every dir
                for (int[] dir: dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nc >=0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        freshOranges--;
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            minutes++;
        }

        if (freshOranges > 0) return -1;
        return minutes-1;
    }
}
