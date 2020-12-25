// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0) {
            return -1;
        }
        
        int m = grid.length, n = grid[0].length;
        int fresh = 0, time = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) return 0;
        
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                
                int[] curr = q.poll();
                
                for(int[] dir: dirs) {
                    
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[] {r, c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        
        if(fresh > 0) return -1;
        
        return time - 1;
    }
}