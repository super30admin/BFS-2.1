// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No


class Solution {
    //method1 BFS- all rotten oranges goes in queue and then its children 
    //TC: m*n SC: m*n
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length==0)return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;// to get how many fresh oranges remain at last to check what to return;
        
        for( int i=0;i<m;i++){
            for(int j=0;j<n;j++){//traverse to find all the fresh oranges count and if it is rotten put it inside queue
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                
            }
        }
        int time = 0;
        if(q.isEmpty() && fresh == 0)return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for( int i=0;i<size;i++){
                int[] curr = q.poll();
                for( int[] dir: dirs){
                    int r = dir[0] + curr[0]; 
                    int c = dir[1] + curr[1];
                    if(r>=0  && c>=0 && r<m && c<n && grid[r][c]==1){
                        q.add(new int[]{r,c});
                        grid[r][c]=2;
                        fresh--;
                    }
                }
            }//level processed
        time++;   
        }
        if(fresh>0)return -1;
       return time-1;
    }
    
    
    //method2- DFS - 1 parent rotten oranges and then their children and similarly for others goes inside queue
    //RightDownLeftTop -  each node checks all directions and then only returns
    //TC: m^2*n^2 SC:m*n
    
//     int[][] dirs;
//     private void dfs(int[][] grid,int i, int j, int m, int n, int time){
//         //base
//         if(i<0 || j<0 || i==m || j==n || grid[i][j]==0) return;//if grid has no oranges immediately return
        
//         if(grid[i][j]>1 && grid[i][j]<time) return;//>1 as it wont be compared with time 2 as it wont make fresh oranges time set to time+1 (visiting fresh node for first time) , other node already set minimum time for that grid then simply return as curr time will be greater than min
        
//         //logic
//         //all directions done
//         grid[i][j]=time;
        
//         //orange is rotten check for direction 
//         for(int[] dir: dirs){
//             int r = dir[0]+i;
//             int c = dir[1]+j;
//             //in dfs we dont bother abt the bounds in bounds -- so check everything in base case
//             dfs(grid,r,c,m,n,time+1);
//         }
//     }
//    public int orangesRotting(int[][] grid) {
//        if(grid == null || grid.length==0)return -1;
//        int m = grid.length;
//        int n = grid[0].length;
//        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
//        for( int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==2){ // DFS only checks for 1 node first and goes to depth till all its children is accessed
//                     dfs(grid,i,j,m,n,2);//time is 2 as already in the grid 0,1,2 is there now we can add 2+time and then subtract -2 from total time
//                 }
//             }
//        }
//        int time = 2;
//        for( int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==1)return -1;
//                 time = Math.max(time, grid[i][j]);// time taken for farthest node in grid will be the total time
//             }
//         }
//         return time-2;
//     }
}