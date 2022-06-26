/* Time Complexity : O((m*n)^2)
 * Space Complexity : O(m*n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    int [][] dirs;
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}}; // up,left,down,right
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    dfs(grid, i, j, 2);
                } 
            }
        }
        int max =0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
                else if(grid[i][j] != 0){
                   max = Math.max(max, grid[i][j] - 2);
                }  
            }
        }
        return max;
    }
    private void dfs(int[][] grid, int i, int j, int time){
        //base
        if(i < 0 || j < 0 || i == m || j == n) return;
        if(grid[i][j] != 1 && grid[i][j] < time) return;
        //logic
        grid[i][j] = time;
        for(int [] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc, time + 1);
        }
    }
}
