//Problem 1: Binary Tree Right Side view
// Time Complexity :O(4mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
// In BFS/DFS approach, check for neighboring elements of 1 that are 1, make them 2 and reduce FreshCount, if there is any 1 remaining, means freshcount remaining-> means not all oranges are rotten!
class Solution {
    int[][] dirs;
    //bfs approach
    // Time: O(m*n)
    // Space: O(m*n)
    // public int orangesRotting(int[][] grid) {
    //     dirs= new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
    //     if(grid==null) return 0;
    //     int m=grid.length;
    //     int n= grid[0].length;
    //     int time=0, freshCount=0;
    //     Queue<int[]> q= new LinkedList<>();

    //     //to count 2 and 1
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(grid[i][j]==1)
    //                 freshCount++;
    //             else if(grid[i][j]==2){
    //                 q.add(new int[]{i,j});
    //             }
    //         }
    //     }

    //     //if freshcount is already zero
    //     if(freshCount==0) return time;

    //     while(!q.isEmpty()){
    //         int size= q.size(); // run untill each current node neighbors are added

    //         for(int i=0;i<size;i++){
    //             int[] cur=q.poll();
    //             for(int[] dir: dirs){ // check for current neighbors and process
    //             int neighborRow=dir[0] +cur[0]; // direction array 0 + current 0 is new neighbor row
    //             int neighborCol=dir[1] +cur[1]; // direction array 1 + current 1 is new neighbor Col

    //             //bounds check
    //                 if(neighborRow>=0 && neighborRow<m && neighborCol>=0 && neighborCol<n
    //                 && grid[neighborRow][neighborCol]==1){ // if neighbor in bounds and is 1
    //                     grid[neighborRow][neighborCol]=2; // turn it to 2 so that we dont add duplicate neighbors
    //                     q.add(new int[]{neighborRow,neighborCol}); // add "1" element coordinates in que
    //                     freshCount--; // as we processed a fresh Orange, reduce FreshCount
    //                 }
    //             }
    //         }
    //         time++;
    //     }
    //     if(freshCount!=0) return -1;
    //     return time-1;
    // }

    //dfs approach TC: O(m*n)^2 SC: O(m*n)-> not counting dirs 2d array
    int m,n;
    public int orangesRotting(int[][] grid) {
        dirs= new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
        if(grid==null) return 0;
        m=grid.length;
        n= grid[0].length;

        //     //to count 2 and 1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    dfs(grid, i, j, 2);
                }
            }
        }
        int result=2;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){ //check for remaining 1
                    return -1;
                }
                result=Math.max(result, grid[i][j]);
            }
        }
        return result-2; //keeping offset of 2, so return res-2
    }

    private void dfs(int[][] grid, int i, int j, int time){
        //base
        if(i<0 || j<0 || i==m || j==n) return; //hit boundries
        if(grid[i][j]!=1 && grid[i][j]<time) return;

        //logic
        grid[i][j]=time;
        for(int[] dir: dirs){
            int neighborRow=i+dir[0];
            int neighborCol=j+dir[1];
            dfs(grid, neighborRow, neighborCol, time+1);
        }
    }
}