// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// BFS
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null) return 0;
        int m = grid.length; 
        int n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        int fresh=0;
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        if(fresh == 0) return 0;
        int time = 0;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && c >= 0 && r<m && c<n && grid[r][c] == 1){//check if fresh
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh > 0) return -1;
        return time-1;
    }
}

// ******************************************

// Time Complexity : O( (m*n)^2 )
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// DFS
class Solution {
    int[][] dirs;
    int fresh;

    public int orangesRotting(int[][] grid) {
        if( grid == null || grid.length == 0)
            return 0;        
        int m = grid.length, n = grid[0].length;
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
// time is initially 2 because we are overriding fresh oranges with time, 
// instead of storing the clock ticks separately 
// (1 -> fresh orange, 0 -> no orange, 2-> rotten at 0, 3 or more -> rotten at time-2 )
                    dfs(grid, i, j, m, n, 2);
                }
            }
        }//If all are rotten, time-2 would give 0
        int time = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                time = Math.max(time, cell);
            }
        }        
        return time - 2;    
    }    
    
    private void dfs(int[][] grid, int r, int c, int m, int n, int time) {
        //base
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return;
        
        //logic
        //rotten by another orange already sooner than current time
        if(grid[r][c] > 1 && grid[r][c] < time) return; 
        else {
            grid[r][c] = time;
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                dfs(grid, nr, nc, m, n, time+1);
            }
        } 
    }
}