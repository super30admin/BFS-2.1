/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O((m*n)^2)
    m = total rows
    n = total cols
* 
* Space Complexity: O(m*n)
* 
*/

class RottingOrangesDFS {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    int freshCount = 0;

    private void dfs(int[][] grid, int row, int col, int time, int m, int n){
        for(int[] dir: dirs){
            int nrow = dir[0] + row;
            int ncol = dir[1] + col;

            if(nrow>=0 && nrow < m && ncol >=0 && ncol < n && 
                grid[nrow][ncol]!=0 && grid[nrow][ncol]!=2
                && (grid[nrow][ncol] == 1|| grid[nrow][ncol] >=time)){
                if(grid[nrow][ncol] == 1){
                    freshCount--;
                }

                grid[nrow][ncol] = time;

                dfs(grid, nrow, ncol, time+1, m, n);
            }
        }
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;

        int n = grid[0].length;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1){
                    freshCount++;
                }
            }
        }

        int maxTime = 0;

        if(freshCount == 0){
            return maxTime;
        }

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 2) {
                    dfs(grid, row, col, 3, m, n);
                }
            }
        }
       
        if(freshCount != 0)
            return -1;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                maxTime = Math.max(maxTime, grid[row][col]-2);
            }
        }
        return maxTime;
    }
}