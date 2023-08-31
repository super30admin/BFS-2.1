// Time Complexity : O(n*m)
// Space Complexity : O(n*m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//USING BFS
class Solution {
    int dirs[][]= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>(); //integer array or two integer every time
        int m = grid.length;
        int n = grid[0].length;
        if( grid == null)
            return 0;
        int fresh = 0;//maintain the count of fresh oranges
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh == 0)
            return 0;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr[] = q.poll(); //ex:[1,0]
                for(int[] dir: dirs){ //check new neigbours in all 4 directions
                    int r = curr[0] + dir[0];// -1+-1 {-1,0}  = -2
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){ //inbounds
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh != 0)// all the oranges can't be rotten case
            return -1;
        return time - 1;
    }
}


//Using DFS
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    int[][] dirs;
    int n,m;
    public int orangesRotting(int[][] grid) {
        if( grid == null)
            return 0;
        n=grid[0].length;
        m=grid.length;
        dirs= new int[][]{{-1,0},{0,-1},{1,0},{0,1}}; // right , bottom, left, up
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){ //rotten
                   dfs(grid,i,j,2);
                }  
            }
        }
        int result =0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                   return -1;
                if(grid[i][j]>2){
                    grid[i][j] = grid[i][j]-2; //removing offset
                    result = Math.max(result,grid[i][j]);
                }   
            }
        }
        return result;
    }


    private void dfs(int[][] grid, int i, int j, int time){
        //base
        if(i < 0 || j<0|| i>=m || j>=n || grid[i][j]==0){ //inbounds
                        return;
        }
        if(grid[i][j]!=1 && grid[i][j]<time){
             return;
        }     
        
        //logic
        grid[i][j]=time;
        for(int [] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            dfs(grid,nr,nc,time+1);
        }

    }
}

