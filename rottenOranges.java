// Time Complexity :O(m*n) - grid
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        
        int time = 2;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){//run the dfs if the orange is rotten
                    dfs(grid, i, j, 2);
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }else{
                    time = Math.max(time, grid[i][j]);// we have to chekc what our maximum is
                }
            }
        }
        return time-2;
    }
    
    private void dfs(int[][] grid, int i, int j, int time){
        //base
        //checking all the bounds
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 ||
          //also see if the vlue is greater than 1 and lesser than the current time is
           grid[i][j]>1 && grid[i][j]<time){
            return;
        }
        //logic
            grid[i][j] = time;
            dfs(grid, i, j+1, time+1);
            dfs(grid, i+1, j, time+1);
            dfs(grid, i-1, j, time+1);
            dfs(grid, i, j-1, time+1);
    }
}