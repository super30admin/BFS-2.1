// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//in this approach we process all the 2 places, and it is 1 we calculate the fresh oranges. Then we add the first 2 in the queue and process all the neighbors of the rotten oranges.
//we decrement the fresh while putting a fresh orange to avoid visiting that again. We increment time once all the neighbors of a particular ornage are processed.
//if the fresh is 0 at the end then we return time otherwise -1.
//bfs
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)return 0;
        int time=0;
        int fresh=0;
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int []> q= new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] ==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] ==1){
                    fresh++;
                }
            }
        }
        if(q.isEmpty() && fresh==0)return 0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int [] curr = q.poll();
                for(int [] dir:dirs){
                    int r = curr[0] + dir[0];
                    int c= curr[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] ==1 ){
                        q.add(new int[]{r,c});
                        grid[r][c]=2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh==0)return time-1;
        return -1;
    }
}


//dfs
class Solution {
    int[][] dirs;
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)return 0;
        dirs= new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] ==2){
                    dfs(grid,i,j,2,m,n);
                }
            }
        }
        int max =0 ;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] ==1)return -1;
                max=Math.max(max,grid[i][j]-2);
            }
        }
        return max;
    }
    private void dfs(int[][] grid, int r,int c,int time, int m, int n){
        if(r<0 || c<0 || r==m || c==n)return;
        if(grid[r][c]!=1 && grid[r][c]<time)return;
        grid[r][c] = time;
        for(int []dir : dirs){
            int nr= r+dir[0];
            int nc = c+dir[1];
            dfs(grid,nr,nc,time+1,m,n);
        }
         
    }
}

