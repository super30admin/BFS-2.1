class Solution {
    // DSF Solution
    // Time complexity is O(m^2n^2) since we are calling DFS on each rotten oranges
    // Space complexity is O(mn)
    // This solution is submitted on leetcode wiyth zero errors
    private int rowLen;
    private int colLen;
    private int[][] dirs;
    public int orangesRotting(int[][] grid) {
        //Edge case
        if(grid.length == 0 || grid == null) return -1;
        rowLen = grid.length;
        colLen = grid[0].length;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i = 0; i<rowLen;i++){
            for(int j = 0;j<colLen;j++){
                if(grid[i][j] == 2){
                    dfs(grid, i,j,2);
                }
            }
        }
        // Result for loop
        int max = 0;
        for(int i = 0; i<rowLen;i++){
            for(int j = 0;j<colLen;j++){
                if(grid[i][j] == 1) return -1;
                max = Math.max(max,grid[i][j] -2);
            }
        }
        return max;
    }
    private void dfs(int[][]grid, int i, int j, int time){
        // base case
        if(i < 0 || j < 0 || i == rowLen || j ==colLen || grid[i][j] == 0) return;
        
        //logic
        if(grid[i][j] > 1 && grid[i][j]< time){
            return;
        } else {
            grid[i][j] = time;
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                dfs(grid, r,c,time+1);
            }
        }
    }
}