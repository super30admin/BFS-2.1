// https://leetcode.com/problems/rotting-oranges/submissions/

// Time Complexity: O(Row + Column)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture


class Solution {
    int[][] dir;
    int m; int n;
        
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        dir = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
            
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) return 0;
        
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            // Processing the level
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir: dir) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    
                    // check bounds
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; fresh--;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time - 1;
    }
}