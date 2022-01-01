//BFS
// Time Complexity :O(m*n)(calculate fresh oranges)+traverse through each element in queue
// Space Complexity :O(m*n) maximum elements in queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    int time;
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid[0].length==0)
            return 0;
        
        int m=grid.length;
        int n=grid[0].length;
        int freshCount=0;
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]>q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==1){
                    freshCount++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
        }
        }
        // if count is 0 need not proceed
        if(freshCount==0)
            return 0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr= q.poll();
                for(int [] dir:dirs){
                    int nr=dir[0]+curr[0];
                    int nc=dir[1]+curr[1];
                    
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    freshCount--;
                    q.add(new int[]{nr,nc});
                }
                }
                
            }
            time++;
        }
     // the last element if rotten will enter in the queue and increment the time by one
        if(freshCount==0)
            return time-1;
        else
            return -1;
    }
}
//DFS
// Time Complexity :O(m*n)*(m*n) dfs on each cell with rotten orange
// Space Complexity :O(m*n) maximum elements in recursive stack
class Solution2 {
    int[][] dirs;
    int m;
    int n;
    int t=0;
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid[0].length==0)
            return 0;
        m=grid.length;
        n=grid[0].length;
        dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};  
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // for every rotten orange carry dfs
                if(grid[i][j]==2){
                    dfs(grid,i,j,2);
                }
        }
        }
        t=2;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
                t=Math.max(t,grid[i][j]);
            }
        }
        // since initial time we added 2 for rotten oranges
        return t-2;


    }
    
    private void dfs(int [][] grid,int i, int j,int time ){
        
    // base
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0)
            return;
    // logic
    // if it was a fresh orange and time to rot was minimum ,no need for dfs
    if(grid[i][j]>1 && grid[i][j]<time)
        return;
    else{ 
        //mutate grid with time taken to rot it
        grid[i][j]=time;
          for( int [] dir: dirs){
              int nr= dir[0]+i;
              int nc= dir[1]+j;
              // oranges at same level rot at same time
              dfs(grid,nr,nc,time+1);
         }
     }
    }
   
    }