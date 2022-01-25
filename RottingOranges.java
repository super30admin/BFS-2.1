class Solution {
    // Time Complexity : O(mn), where m is the no of rows and n is the no of columns
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using BFS
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        if(count_fresh == 0) {
            return 0;
        }
        int time = 0;
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            for(int k = 0; k < size; k++) {
                int[] t = q.poll();
                for(int[] d : dir) {
                    int nr = t[0] + d[0];
                    int nc = t[1] + d[1];

                    if(nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        count_fresh--;
                    }
                }
            }

        }
        return count_fresh > 0 ? -1 : time-1;
    }
}